package com.example.library.controller;

import com.example.library.entity.Result;
import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.Paper;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.SystemException;
import com.example.library.service.user.SearchBookService;
import com.example.library.vo.response.OrdinaryBookDetailResponseVO;
import com.example.library.vo.response.SearchBookResponseVO;
import com.github.pagehelper.PageInfo;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/8 14:05
 */
@RestController
@RequestMapping("/searchBook")
@CrossOrigin
public class SearchBookController {

    @Autowired
    private SearchBookService searchBookService;

    @GetMapping("/searchOrdinaryBookByBookName")
    public Result searchOrdinaryBookByBookName(String bookName,Integer start,Integer size) throws BookNotFoundException {
        PageInfo<OrdinaryBook> pageInfo = searchBookService.selectOrdinaryBook(bookName, "bookName",start, size);
        PageInfo<SearchBookResponseVO> vo = SearchBookResponseVO.getOrdinaryBookEntity(pageInfo);
        if(vo.getSize()<=0){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",vo);
    }

    @GetMapping("/searchOrdinaryBookByAuthor")
    public Result searchOrdinaryBookByAuthor(String author,Integer start,Integer size) throws BookNotFoundException {
        PageInfo<OrdinaryBook> pageInfo = searchBookService.selectOrdinaryBook(author, "author",start, size);
        PageInfo<SearchBookResponseVO> vo = SearchBookResponseVO.getOrdinaryBookEntity(pageInfo);
        if(vo.getPages()<=0){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",vo);
    }

    @GetMapping("/searchOrdinaryBookByBookId")
    public Result searchOrdinaryBookByBookId(Integer bookId) throws BookNotFoundException {
        OrdinaryBook book = searchBookService.selectOrdinaryBookById(bookId);
        if(book==null){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",book);
    }

    @GetMapping("/searchMagazineByBookName")
    public Result searchMagazineByBookName(String bookName,Integer start,Integer size) throws BookNotFoundException {
        PageInfo<Magazine> pageInfo = searchBookService.selectMagazine(bookName,"bookName", start, size);
        PageInfo<SearchBookResponseVO> vo = SearchBookResponseVO.getMagazineEntity(pageInfo);
        if(vo.getPages()<=0){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",vo);
    }

    @GetMapping("/searchMagazineByAuthor")
    public Result searchMagazineByAuthor(String author,Integer start,Integer size) throws BookNotFoundException {
        PageInfo<Magazine> pageInfo = searchBookService.selectMagazine(author,"author" ,start, size);
        PageInfo<SearchBookResponseVO> vo = SearchBookResponseVO.getMagazineEntity(pageInfo);
        if(vo.getSize()<=0){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",vo);
    }

    @GetMapping("/searchMagazineByBookId")
    public Result searchMagazineByBookId(Integer bookId) throws BookNotFoundException {
        Magazine book = searchBookService.selectMagazineBookById(bookId);
        if(book==null){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",book);
    }

    @GetMapping("/searchPaperByBookName")
    public Result searchPaperByBookName(String bookName,Integer start,Integer size) throws BookNotFoundException {
        PageInfo<Paper> pageInfo = searchBookService.selectPaper(bookName,"bookName", start, size);
        PageInfo<SearchBookResponseVO> vo = SearchBookResponseVO.getPaperEntity(pageInfo);
        if(vo.getSize()<=0){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",vo);
    }

    @GetMapping("/searchPaperByAuthor")
    public Result searchPaperByAuthor(String author,Integer start,Integer size) throws BookNotFoundException {
        PageInfo<Paper> pageInfo = searchBookService.selectPaper(author, "author",start, size);
        PageInfo<SearchBookResponseVO> vo = SearchBookResponseVO.getPaperEntity(pageInfo);
        if(vo.getPages()<=0){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",vo);
    }

    @GetMapping("/searchPaperByBookId")
    public Result searchPaperByBookId(Integer bookId) throws BookNotFoundException {
        Paper book = searchBookService.selectPaperById(bookId);
        if(book==null){
            throw new BookNotFoundException("暂无记录");
        }
        return new Result(true,"查询成功",book);
    }

    @GetMapping("/ordinaryBookDetail/{bookId}")
    public Result ordinaryBookDetail(@PathVariable Integer bookId) throws SystemException {
        OrdinaryBook ordinaryBook = searchBookService.ordinaryBookDetail(bookId);
        if(ordinaryBook==null){
            throw new SystemException("系统异常");
        }
        return new Result(true,"查询成功",ordinaryBook);
    }

    @GetMapping("/magazineDetail/{bookId}")
    public Result magazineDetail(@PathVariable Integer bookId) throws SystemException {
        Magazine magazine = searchBookService.magazineDetail(bookId);
        if(magazine==null){
            throw new SystemException("系统异常");
        }
        return new Result(true,"查询成功",magazine);
    }

    @GetMapping("/paperDetail/{bookId}")
    public Result paperDetail(@PathVariable Integer bookId) throws SystemException {
        Paper paper = searchBookService.paperDetail(bookId);
        if(paper==null){
            throw new SystemException("系统异常");
        }
        return new Result(true,"查询成功",paper);
    }



}
