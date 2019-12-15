package com.example.library.service.user.impl;

import com.example.library.entity.Common;
import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.Paper;
import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.entity.book.bookitem.PaperItem;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.BookNotInException;
import com.example.library.exception.ErrorLocationException;
import com.example.library.mapper.book.BookDetailMapper;
import com.example.library.mapper.book.MagazineMapper;
import com.example.library.mapper.book.OrdinaryBookMapper;
import com.example.library.mapper.book.PaperMapper;
import com.example.library.mapper.book.item.MagazineItemMapper;
import com.example.library.mapper.book.item.OrdinaryBookItemMapper;
import com.example.library.mapper.book.item.PaperItemMapper;
import com.example.library.service.user.SearchBookService;
import com.example.library.util.CommonUtil;
import com.example.library.vo.response.OrdinaryBookDetailResponseVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/8 13:28
 */
@Service
public class SearchBookServiceImpl implements SearchBookService {

    @Autowired
    private OrdinaryBookMapper ordinaryBookMapper;
    
    @Autowired
    private MagazineMapper magazineMapper;
    
    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private BookDetailMapper bookDetailMapper;

    @Autowired
    private OrdinaryBookItemMapper ordinaryBookItemMapper;

    @Autowired
    private MagazineItemMapper magazineItemMapper;

    @Autowired
    private PaperItemMapper paperItemMapper;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public PageInfo<OrdinaryBook> selectOrdinaryBook(String bookName,String property, Integer start, Integer size) {
        PageHelper.startPage(start,size);
        Example example = commonUtil.searchBookCriteria(OrdinaryBook.class, property, bookName);
        return new PageInfo<>(ordinaryBookMapper.selectByExample(example));
    }

    @Override
    public OrdinaryBook selectOrdinaryBookById(Integer id) {
        return ordinaryBookMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Magazine> selectMagazine(String bookName,String property, Integer start, Integer size) {
        PageHelper.startPage(start,size);
        Example example = commonUtil.searchBookCriteria(Magazine.class, property, bookName);
        return new PageInfo<>(magazineMapper.selectByExample(example));
    }

    @Override
    public Magazine selectMagazineBookById(Integer id) {
        return magazineMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Paper> selectPaper(String bookName,String property,  Integer start, Integer size) {
        PageHelper.startPage(start,size);
        Example example = commonUtil.searchBookCriteria(Paper.class, property, bookName);
        return new PageInfo<>(paperMapper.selectByExample(example));
    }

    @Override
    public Paper selectPaperById(Integer id) {
        return paperMapper.selectByPrimaryKey(id);
    }


    @Override
    public OrdinaryBook ordinaryBookDetail(Integer id) {
        return bookDetailMapper.selectOrdinaryBookDetailByBookId(id);
    }

    @Override
    public Magazine magazineDetail(Integer id) {
        return bookDetailMapper.selectMagazineDetailByBookId(id);
    }

    @Override
    public Paper paperDetail(Integer id) {
        return bookDetailMapper.selectPaperDetailByBookId(id);
    }

    @Override
    public OrdinaryBookItem selectOrdinaryBookItemById(Integer id,Integer location) throws BookNotFoundException, ErrorLocationException, BookNotInException {
        OrdinaryBookItem item = ordinaryBookItemMapper.selectByPrimaryKey(id);
        if(item==null){
            throw new BookNotFoundException("该书不存在");
        }
        if(!location.equals(item.getLocation())){
            throw  new ErrorLocationException("该书不是这个馆藏的书");
        }
        if(item.getState()== Common.BORROW_OUT){
            throw new BookNotInException("该书已借出");
        }
        return item;
    }

    @Override
    public MagazineItem selectMagazineItemById(Integer id,Integer location) throws BookNotFoundException, ErrorLocationException, BookNotInException {
        MagazineItem item = magazineItemMapper.selectByPrimaryKey(id);
        if(item==null){
            throw new BookNotFoundException("该书不存在");
        }
        if(location!=item.getLocation()){
            throw  new ErrorLocationException("该书不是这个馆藏的书");
        }
        if(item.getState()== Common.BORROW_OUT){
            throw new BookNotInException("该书已借出");
        }
        return item;
    }

    @Override
    public PaperItem selectPaperItemById(Integer id,Integer location) throws ErrorLocationException, BookNotFoundException, BookNotInException {
        PaperItem item = paperItemMapper.selectByPrimaryKey(id);
        if(item==null){
            throw new BookNotFoundException("该书不存在");
        }
        if(location!=item.getLocation()){
            throw  new ErrorLocationException("该书不是这个馆藏的书");
        }
        if(item.getState()== Common.BORROW_OUT){
            throw new BookNotInException("该书已借出");
        }
        return item;
    }

}
