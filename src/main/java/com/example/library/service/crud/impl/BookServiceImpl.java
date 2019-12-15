package com.example.library.service.crud.impl;

import com.example.library.entity.Common;
import com.example.library.entity.book.Book;
import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.Paper;
import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.entity.book.bookitem.PaperItem;
import com.example.library.exception.BookNotFoundException;
import com.example.library.mapper.book.BookDetailMapper;
import com.example.library.mapper.book.MagazineMapper;
import com.example.library.mapper.book.OrdinaryBookMapper;
import com.example.library.mapper.book.PaperMapper;
import com.example.library.mapper.book.item.MagazineItemMapper;
import com.example.library.mapper.book.item.OrdinaryBookItemMapper;
import com.example.library.mapper.book.item.PaperItemMapper;
import com.example.library.service.crud.BookService;
import com.example.library.util.CommonUtil;
import com.example.library.vo.request.book.AddMagazineRequestVO;
import com.example.library.vo.request.book.AddOrdinaryBookRequestVO;
import com.example.library.vo.request.book.AddPaperRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 10:05
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private OrdinaryBookMapper ordinaryBookMapper;

    @Autowired
    private MagazineMapper magazineMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private OrdinaryBookItemMapper ordinaryBookItemMapper;

    @Autowired
    private MagazineItemMapper magazineItemMapper;

    @Autowired
    private PaperItemMapper paperItemMapper;

    @Autowired
    private CommonUtil commonUtil;

    @Autowired
    private BookDetailMapper bookDetailMapper;

    @Override
    @Transactional
    public int insertOrdinaryBook(AddOrdinaryBookRequestVO vo, Integer l1, Integer l2, Integer l3) {
        OrdinaryBook ordinaryBook = AddOrdinaryBookRequestVO.getEntity(vo);
        ordinaryBookMapper.insert(ordinaryBook);
        Integer bookId=ordinaryBook.getId();
        List<OrdinaryBookItem> list = commonUtil.getOrdinaryBookItems(bookId, l1, l2, l3,OrdinaryBookItem.class);
        return ordinaryBookItemMapper.insertBookItemBatch(list);
    }

//    @Override
//    public int updateOrdinaryBook(AddOrdinaryBookRequestVO vo) {
//        OrdinaryBook ordinaryBook = AddOrdinaryBookRequestVO.getEntity(vo);
//        ordinaryBookMapper.updateByPrimaryKeySelective(ordinaryBook);
//        return ordinaryBook.getId();
//    }

    @Override
    @Transactional
    public int insertMagazine(AddMagazineRequestVO vo, Integer l1, Integer l2, Integer l3) {
        Magazine magazine = AddMagazineRequestVO.getEntity(vo);
        magazineMapper.insert(magazine);
        Integer bookId=magazine.getId();
        List<MagazineItem> list = commonUtil.getMagazineItems(bookId, l1, l2, l3,MagazineItem.class);
        return magazineItemMapper.insertBookItemBatch(list);
    }


//    @Override
//    public int updateMagazine(AddOrdinaryBookRequestVO vo) {
//        Magazine magazine = Add.getMagazineEntity(vo);
//        magazineMapper.updateByPrimaryKeySelective(magazine);
//        return magazine.getId();
//    }

    @Override
    @Transactional
    public int insertPaper(AddPaperRequestVO vo, Integer l1, Integer l2, Integer l3) {
        Paper paper = AddPaperRequestVO.getEntity(vo);
        paperMapper.insert(paper);
        Integer bookId=paper.getId();
        List<PaperItem> list = commonUtil.getPaperItems(bookId, l1, l2, l3,PaperItem.class);
        return paperItemMapper.insertBookItemBatch(list);
    }

    @Override
    public Book findBook(Integer bookType, Integer biId) throws BookNotFoundException {
        if(bookType.equals(Common.ORDINARY_BOOK_TYPE)){
            OrdinaryBookItem item = ordinaryBookItemMapper.selectByPrimaryKey(biId);
            OrdinaryBook book = ordinaryBookMapper.selectByPrimaryKey(item.getBookId());
            return book;
        }
        if(bookType.equals(Common.MAGAZINE_TYPE)){
            MagazineItem item = magazineItemMapper.selectByPrimaryKey(biId);
            Magazine book = magazineMapper.selectByPrimaryKey(item.getBookId());
            return book;
        }
        if(bookType.equals(Common.PAPER_TYPE)){
            PaperItem item = paperItemMapper.selectByPrimaryKey(biId);
            Paper book = paperMapper.selectByPrimaryKey(item.getBookId());
            return book;
        }
        throw new BookNotFoundException("该书不存在");
    }

//
//    @Override
//    public int updatePaper(AddOrdinaryBookRequestVO vo) {
//        Paper paper = AddOrdinaryBookRequestVO.getPaperEntity(vo);
//        paperMapper.updateByPrimaryKeySelective(paper);
//        return paper.getId();
//    }
}
