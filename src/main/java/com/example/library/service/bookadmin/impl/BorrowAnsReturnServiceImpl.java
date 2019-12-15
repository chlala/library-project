package com.example.library.service.bookadmin.impl;

import com.example.library.entity.Borrow;
import com.example.library.entity.Common;
import com.example.library.entity.book.Book;
import com.example.library.entity.book.OrderItem;
import com.example.library.entity.book.bookitem.BookItem;
import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.entity.book.bookitem.PaperItem;
import com.example.library.entity.strategy.BorrowStrategy;
import com.example.library.entity.strategy.FineStrategy;
import com.example.library.entity.user.serve.ServeObject;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import com.example.library.exception.*;
import com.example.library.mapper.book.OrderMapper;
import com.example.library.mapper.book.item.MagazineItemMapper;
import com.example.library.mapper.book.item.OrdinaryBookItemMapper;
import com.example.library.mapper.book.item.PaperItemMapper;
import com.example.library.mapper.startegy.BorrowStrategyMapper;
import com.example.library.mapper.startegy.FineStrategyMapper;
import com.example.library.mapper.user.*;
import com.example.library.service.bookadmin.BorrowAndReturnService;
import com.example.library.service.crud.BookService;
import com.example.library.service.user.SearchBookService;
import com.example.library.service.user.ServerObjectService;
import com.example.library.util.CommonUtil;
import com.example.library.util.MailSendUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/10 14:59
 */
@Service
public class BorrowAnsReturnServiceImpl implements BorrowAndReturnService {

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private BorrowStrategyMapper borrowStrategyMapper;

    @Autowired
    private SearchBookService searchBookService;

    @Autowired
    private BorrowAndReturnService borrowAndReturnService;
    
    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private OrdinaryBookItemMapper ordinaryBookItemMapper;

    @Autowired
    private MagazineItemMapper magazineItemMapper;

    @Autowired
    private PaperItemMapper paperItemMapper;

    @Autowired
    private ServerObjectService serverObjectService;

    @Autowired
    private ReturnMapper returnMapper;

    @Autowired
    private FineStrategyMapper fineStrategyMapper;

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private JuniorMapper juniorMapper;

    @Autowired
    private BachelorMapper bachelorMapper;

    @Autowired
    private MasterMapper masterMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private BookService bookService;

    @Autowired
    private MailSendUtil mailSendUtil;

    @Override
    @Transactional
    public int teacherBorrowOrdinaryBook(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.TEACHER_TYPE, Common.ORDINARY_BOOK_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.ORDINARY_BOOK_TYPE,shouldReturnTime,borrow);
        return borrowMapper.teacherBorrowOrdinaryBook(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int juniorBorrowOrdinaryBook(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.JUNIOR_TYPE, Common.ORDINARY_BOOK_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.ORDINARY_BOOK_TYPE,shouldReturnTime,borrow);
        return borrowMapper.juniorBorrowOrdinaryBook(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int bachelorBorrowOrdinaryBook(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.BACHELOR_TYPE, Common.ORDINARY_BOOK_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.ORDINARY_BOOK_TYPE,shouldReturnTime,borrow);
        return borrowMapper.bachelorBorrowOrdinaryBook(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int masterBorrowOrdinaryBook(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.MASTER_TYPE, Common.ORDINARY_BOOK_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.ORDINARY_BOOK_TYPE,shouldReturnTime,borrow);
        return borrowMapper.masterBorrowOrdinaryBook(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int doctorBorrowOrdinaryBook(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.DOCTOR_TYPE, Common.ORDINARY_BOOK_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.ORDINARY_BOOK_TYPE,shouldReturnTime,borrow);
        return borrowMapper.doctorBorrowOrdinaryBook(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int teacherBorrowMagazine(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.TEACHER_TYPE, Common.MAGAZINE_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.MAGAZINE_TYPE,shouldReturnTime,borrow);
        return borrowMapper.teacherBorrowMagazine(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int juniorBorrowMagazine(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.JUNIOR_TYPE, Common.MAGAZINE_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.MAGAZINE_TYPE,shouldReturnTime,borrow);
        return borrowMapper.juniorBorrowMagazine(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int bachelorBorrowMagazine(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.BACHELOR_TYPE, Common.MAGAZINE_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.MAGAZINE_TYPE,shouldReturnTime,borrow);
        return borrowMapper.bachelorBorrowMagazine(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int masterBorrowMagazine(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.MASTER_TYPE, Common.MAGAZINE_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.MAGAZINE_TYPE,shouldReturnTime,borrow);
        return borrowMapper.masterBorrowMagazine(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int doctorBorrowMagazine(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.DOCTOR_TYPE, Common.MAGAZINE_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.MAGAZINE_TYPE,shouldReturnTime,borrow);
        return borrowMapper.doctorBorrowMagazine(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int teacherBorrowPaper(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.TEACHER_TYPE, Common.PAPER_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.PAPER_TYPE,shouldReturnTime,borrow);
        return borrowMapper.teacherBorrowPaper(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int juniorBorrowPaper(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.JUNIOR_TYPE, Common.PAPER_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.PAPER_TYPE,shouldReturnTime,borrow);
        return borrowMapper.juniorBorrowPaper(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int bachelorBorrowPaper(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.BACHELOR_TYPE, Common.PAPER_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.PAPER_TYPE,shouldReturnTime,borrow);
        return borrowMapper.bachelorBorrowPaper(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int masterBorrowPaper(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.MASTER_TYPE, Common.PAPER_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.PAPER_TYPE,shouldReturnTime,borrow);
        return borrowMapper.masterBorrowPaper(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int doctorBorrowPaper(Integer bookId, Integer biId, String no) {
        Example example = commonUtil.borrowStrategyCriteria(BorrowStrategy.class, Common.DOCTOR_TYPE, Common.PAPER_TYPE);
        BorrowStrategy strategy = borrowStrategyMapper.selectOneByExample(example);
        Borrow borrow=new Borrow();
        Date shouldReturnTime = new Date();
        commonUtil.setBorrow(strategy,no,biId,Common.PAPER_TYPE,shouldReturnTime,borrow);
        return borrowMapper.doctorBorrowPaper(bookId,biId, Common.IN_LIBRARY, no, shouldReturnTime, borrow);
    }

    @Override
    public int borrowOrdinaryBook(String no, Integer role, Integer biId, Integer location) throws SystemException, BookNotInException, ErrorLocationException, BookNotFoundException {
        OrdinaryBookItem item = searchBookService.selectOrdinaryBookItemById(biId, location);
        if(role.equals(Common.TEACHER_TYPE)){
            return borrowAndReturnService.teacherBorrowOrdinaryBook(item.getBookId(),biId,no);
        } else if(role.equals(Common.JUNIOR_TYPE)){
            return borrowAndReturnService.juniorBorrowOrdinaryBook(item.getBookId(),biId,no);
        } else if(role.equals(Common.BACHELOR_TYPE)){
            return borrowAndReturnService.bachelorBorrowOrdinaryBook(item.getBookId(),biId,no);
        } else if(role.equals(Common.MASTER_TYPE)){
            return borrowAndReturnService.masterBorrowOrdinaryBook(item.getBookId(),biId,no);
        } else if(role.equals(Common.DOCTOR_TYPE)){
            return borrowAndReturnService.doctorBorrowOrdinaryBook(item.getBookId(),biId,no);
        }
        throw new SystemException("系统异常");
    }

    @Override
    public int borrowMagazine(String no, Integer role, Integer biId, Integer location) throws SystemException, BookNotInException, ErrorLocationException, BookNotFoundException {
        MagazineItem item = searchBookService.selectMagazineItemById(biId, location);
        if(role.equals(Common.TEACHER_TYPE)){
            return borrowAndReturnService.teacherBorrowMagazine(item.getBookId(),biId,no);
        } else if(role.equals(Common.JUNIOR_TYPE)){
            return borrowAndReturnService.juniorBorrowMagazine(item.getBookId(),biId,no);
        } else if(role.equals(Common.BACHELOR_TYPE)){
            return borrowAndReturnService.bachelorBorrowMagazine(item.getBookId(),biId,no);
        } else if(role.equals(Common.MASTER_TYPE)){
            return borrowAndReturnService.masterBorrowMagazine(item.getBookId(),biId,no);
        } else if(role.equals(Common.DOCTOR_TYPE)){
            return borrowAndReturnService.doctorBorrowMagazine(item.getBookId(),biId,no);
        }
        throw new SystemException("系统异常");
    }

    @Override
    public int borrowPaper(String no, Integer role, Integer biId, Integer location) throws SystemException, BookNotInException, ErrorLocationException, BookNotFoundException {
        PaperItem item = searchBookService.selectPaperItemById(biId, location);
        if(role.equals(Common.TEACHER_TYPE)){
            return borrowAndReturnService.teacherBorrowPaper(item.getBookId(),biId,no);
        } else if(role.equals(Common.JUNIOR_TYPE)){
            return borrowAndReturnService.juniorBorrowPaper(item.getBookId(),biId,no);
        } else if(role.equals(Common.BACHELOR_TYPE)){
            return borrowAndReturnService.bachelorBorrowPaper(item.getBookId(),biId,no);
        } else if(role.equals(Common.MASTER_TYPE)){
            return borrowAndReturnService.masterBorrowPaper(item.getBookId(),biId,no);
        } else if(role.equals(Common.DOCTOR_TYPE)){
            return borrowAndReturnService.doctorBorrowPaper(item.getBookId(),biId,no);
        }
        throw new SystemException("系统异常");
    }

    @Override
    public BookItem findBookItem(Integer biId, Integer bookType, Integer location) throws SystemException, ErrorLocationException, BookNotFoundException, StateErrorException {
        BookItem item;
        if(bookType.equals(Common.ORDINARY_BOOK_TYPE)){
            item = ordinaryBookItemMapper.selectByPrimaryKey(biId);
        } else if (bookType.equals(Common.MAGAZINE_TYPE)) {
            item = magazineItemMapper.selectByPrimaryKey(biId);
        } else if(bookType.equals(Common.PAPER_TYPE)){
            item = paperItemMapper.selectByPrimaryKey(biId);
        } else {
            throw new SystemException("系统异常");
        }
        if(item==null){
            throw new BookNotFoundException("该书不存在");
        }
        if(!item.getLocation().equals(location)){
            throw new ErrorLocationException("该书不是本馆图书");
        }
        if(item.getState().equals(Common.IN_LIBRARY)){
            throw new StateErrorException("该书尚未借阅，不能归还");
        }
        return item;
    }

    @Override
    @Transactional
    public String returnBook(Integer biId, Integer bookType) throws UserNotFoundException, SystemException, BookNotFoundException {
        Example selectBorrowExample = commonUtil.selectBorrowRecord(biId, bookType);
        Borrow borrowRecord = borrowRecordMapper.selectOneByExample(selectBorrowExample);
        String no = borrowRecord.getSerNo();
        int userType = serverObjectService.findServerObject(no);
        Date shouldReturnDate = borrowRecord.getShouldReturnTime();
        updateBook(bookType,biId,shouldReturnDate);
        Calendar now=Calendar.getInstance();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(shouldReturnDate);
        boolean isExpired = now.after(calendar);
        double fineMoney=0.0;
        if(isExpired){
            int day= (int) ((now.getTimeInMillis()-shouldReturnDate.getTime())/(1000*3600*24));
            FineStrategy fineStrategy = fineStrategyMapper.selectByPrimaryKey(bookType);
            fineMoney=day*fineStrategy.getMoney();
        }
        Borrow borrow=new Borrow();
        borrow.setValidate(Common.INVALIDATE);
        borrow.setReturnDate(now.getTime());
        Example example = commonUtil.selectBorrowRecord(biId, bookType);
        borrowRecordMapper.updateByExampleSelective(borrow,example);
        updateUser(userType,no,fineMoney);
        sendMail(biId);
        return no;
    }

    @Override
    public void updateUser(int userType,String no,double fineMoney) throws SystemException {
        if(userType==Common.TEACHER_TYPE){
            Teacher teacher = teacherMapper.selectByPrimaryKey(no);
            teacher.setBorrowNum(teacher.getBorrowNum()-1);
            teacher.setOweMoney(fineMoney);
            teacherMapper.updateByPrimaryKeySelective(teacher);
        } else if(userType==Common.JUNIOR_TYPE){
            Junior junior = juniorMapper.selectByPrimaryKey(no);
            junior.setBorrowNum(junior.getBorrowNum()-1);
            junior.setOweMoney(fineMoney);
            juniorMapper.updateByPrimaryKeySelective(junior);
        } else if(userType==Common.BACHELOR_TYPE){
            Bachelor bachelor = bachelorMapper.selectByPrimaryKey(no);
            bachelor.setBorrowNum(bachelor.getBorrowNum()-1);
            bachelor.setOweMoney(fineMoney);
            bachelorMapper.updateByPrimaryKeySelective(bachelor);
        } else if(userType==Common.MASTER_TYPE){
            Master master = masterMapper.selectByPrimaryKey(no);
            master.setBorrowNum(master.getBorrowNum()-1);
            master.setOweMoney(fineMoney);
            masterMapper.updateByPrimaryKeySelective(master);
        } else if(userType==Common.DOCTOR_TYPE){
            Doctor doctor = doctorMapper.selectByPrimaryKey(no);
            doctor.setBorrowNum(doctor.getBorrowNum()-1);
            doctor.setOweMoney(fineMoney);
            doctorMapper.updateByPrimaryKeySelective(doctor);
        } else {
            throw new SystemException("系统异常");
        }
    }

    @Override
    public void updateBook(Integer bookType,Integer biId,Date shouldReturnDate) throws SystemException {
        if(bookType.equals(Common.ORDINARY_BOOK_TYPE)){
            OrdinaryBookItem item = ordinaryBookItemMapper.selectByPrimaryKey(biId);
            shouldReturnDate.setTime(item.getShouldReturnTime().getTime());
            item.setShouldReturnTime(null);
            item.setState(Common.IN_LIBRARY);
            returnMapper.onlyReturnOrdinaryBook(item);
        } else if(bookType.equals(Common.MAGAZINE_TYPE)){
            MagazineItem item = magazineItemMapper.selectByPrimaryKey(biId);
            shouldReturnDate.setTime(item.getShouldReturnTime().getTime());
            item.setShouldReturnTime(null);
            item.setState(Common.IN_LIBRARY);
            returnMapper.onlyReturnMagazine(item);
        } else if(bookType.equals(Common.PAPER_TYPE)){
            PaperItem item = paperItemMapper.selectByPrimaryKey(biId);
            shouldReturnDate.setTime(item.getShouldReturnTime().getTime());
            item.setShouldReturnTime(null);
            item.setState(Common.IN_LIBRARY);
            returnMapper.onlyReturnPaper(item);
        } else {
            throw new SystemException("系统异常");
        }
    }

    @Override
    public void sendMail(Integer biId) throws UserNotFoundException, BookNotFoundException {
        Example example = commonUtil.selectValidateOrderItem(biId);
        List<OrderItem> orderItems = orderMapper.selectByExample(example);
        Integer bookType;
        String no;
        String email;
        String bookName;
        String userName;
        for (OrderItem orderItem:orderItems){
            bookType = orderItem.getBookType();
            no=orderItem.getNo();
            ServeObject serveObject = serverObjectService.findServeObject(no);
            userName=serveObject.getName();
            email = serveObject.getEmail();
            Book book = bookService.findBook(bookType, biId);
            bookName=book.getBookName();
            mailSendUtil.sendMail(email,userName,bookName);
            orderItem.setValidate(Common.INVALIDATE);
            orderMapper.updateByPrimaryKeySelective(orderItem);
        }
    }

}
