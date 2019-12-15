package com.example.library.util;

import com.example.library.entity.Borrow;
import com.example.library.entity.Common;
import com.example.library.entity.book.OrderItem;
import com.example.library.entity.book.bookitem.BookItem;
import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.entity.book.bookitem.PaperItem;
import com.example.library.entity.strategy.BorrowStrategy;
import com.example.library.entity.user.serve.ServeObject;
import com.example.library.exception.BookExpiredException;
import com.example.library.exception.BorrowTooMuchException;
import com.example.library.exception.OweMoneyException;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 16:58
 */
@Component
public class CommonUtil {

    public Example loginCriteria(Class<?> entityClass,String property,String value){
        Example example=new Example(entityClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo(property,value);
        return example;
    }

    public Example searchBookCriteria(Class<?> entityClass,String property,String name){
        Example example=new Example(entityClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike(property,"%"+name+"%");
        return example;
    }

    public Example borrowStrategyCriteria(Class<?> entityClass,Integer userType,Integer bookType){
        Example example=new Example(entityClass);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userType",userType);
        criteria.andEqualTo("bookType",bookType);
        return example;
    }

    public Example selectBorrowRecord(Integer biId,Integer bookType){
        Example example=new Example(Borrow.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("biId",biId);
        criteria.andEqualTo("validate",Common.VALIDATE);
        criteria.andEqualTo("type",bookType);
        return example;
    }

    public Example selectOrderItem(Integer biId,Integer bookType,String no){
        Example example=new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("biId",biId);
        criteria.andEqualTo("validate",Common.VALIDATE);
        criteria.andEqualTo("bookType",bookType);
        criteria.andEqualTo("no",no);
        return example;
    }

    public Example selectValidateOrderItem(Integer biId){
        Example example=new Example(OrderItem.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("validate",Common.VALIDATE);
        criteria.andEqualTo("biId",biId);
        return example;
    }

    public List<OrdinaryBookItem> getOrdinaryBookItems(Integer bookId,Integer l1,Integer l2,Integer l3,Class<?> entityClass){
        List<OrdinaryBookItem> list=new ArrayList<>();
        loopAddList(bookId,l1,l2,l3,entityClass,list);
        return list;
    }

    public List<MagazineItem> getMagazineItems(Integer bookId,Integer l1,Integer l2,Integer l3,Class<?> entityClass){
        List<MagazineItem> list=new ArrayList<>();
        loopAddList(bookId,l1,l2,l3,entityClass,list);
        return list;
    }

    public List<PaperItem> getPaperItems(Integer bookId,Integer l1,Integer l2,Integer l3,Class<?> entityClass){
        List<PaperItem> list=new ArrayList<>();
        loopAddList(bookId,l1,l2,l3,entityClass,list);
        return list;
    }

    private void loopAddList(Integer bookId,Integer l1,Integer l2,Integer l3,Class<?> entityClass,List list){
        while (l1>0){
            addList(list,bookId,1,entityClass);
            l1--;
        }
        while (l2>0){
            addList(list,bookId,2,entityClass);
            l2--;
        }
        while (l3>0){
            addList(list,bookId,3,entityClass);
            l3--;
        }
    }

    private void addList(List list,Integer bookId,int location,Class<?> entityClass){
        if(entityClass.getName().equals(OrdinaryBookItem.class.getName())){
            OrdinaryBookItem ordinaryBookItem=new OrdinaryBookItem();
            ordinaryBookItem.setBookId(bookId);
            ordinaryBookItem.setLocation(location);
            list.add(ordinaryBookItem);
        } else if(entityClass.getName().equals(MagazineItem.class.getName())){
            MagazineItem magazineItem=new MagazineItem();
            magazineItem.setBookId(bookId);
            magazineItem.setLocation(location);
            list.add(magazineItem);
        } else if(entityClass.getName().equals(PaperItem.class.getName())){
            PaperItem paperItem=new PaperItem();
            paperItem.setBookId(bookId);
            paperItem.setLocation(location);
            list.add(paperItem);
        }
    }
    
    
    public boolean checkUser(ServeObject user) throws BorrowTooMuchException, OweMoneyException, BookExpiredException {
        if(user!=null){
            if(user.getBorrowNum()>=user.getBorrowStrategy().getMaxBorrowNum()){
                throw new BorrowTooMuchException("借书量已达上限");
            }
            if(user.getOweMoney()>0){
                throw new OweMoneyException("该账户已欠费，请先缴费");
            }
            List<Borrow> borrowList = user.getBorrowList();
            if(borrowList!=null&&borrowList.size()>0){
                Calendar calendar = Calendar.getInstance();
                for (Borrow borrow:borrowList){
                    Calendar shouldReturnTime=Calendar.getInstance();
                    shouldReturnTime.setTime(borrow.getShouldReturnTime());
                    if(calendar.after(shouldReturnTime)){
                        throw new BookExpiredException("有书已过期，请先还书");
                    }
                }
            }
            return true;
        }
        return false;
    }


    public void setBorrow(BorrowStrategy strategy,String no,Integer biId,Integer bookType,Date shouldReturnTime,Borrow borrow){
        Integer day = strategy.getMaxBorrowDay();
        Calendar calendar=Calendar.getInstance();
        borrow.setBorrowDate(calendar.getTime());
        calendar.add(Calendar.DAY_OF_YEAR,day);
        shouldReturnTime.setTime(calendar.getTimeInMillis());
        borrow.setSerNo(no);
        borrow.setType(bookType);
        borrow.setValidate(Common.IN_LIBRARY);
        borrow.setBiId(biId);
        borrow.setShouldReturnTime(shouldReturnTime);
    }



}
