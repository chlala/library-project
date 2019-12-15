package com.example.library.service.user;

import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.Paper;
import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.entity.book.bookitem.PaperItem;
import com.example.library.exception.BookNotFoundException;
import com.example.library.exception.BookNotInException;
import com.example.library.exception.ErrorLocationException;
import com.github.pagehelper.PageInfo;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/8 13:28
 */
public interface SearchBookService {

    PageInfo<OrdinaryBook> selectOrdinaryBook(String bookName, String property, Integer start, Integer size);

    PageInfo<Magazine> selectMagazine(String bookName, String property, Integer start, Integer size);

    PageInfo<Paper> selectPaper(String bookName, String property, Integer start, Integer size);

    OrdinaryBook selectOrdinaryBookById(Integer id);

    Magazine selectMagazineBookById(Integer id);

    Paper selectPaperById(Integer id);

    OrdinaryBook ordinaryBookDetail(Integer id);

    Magazine magazineDetail(Integer id);

    Paper paperDetail(Integer id);

    OrdinaryBookItem selectOrdinaryBookItemById(Integer id,Integer location) throws BookNotFoundException, ErrorLocationException, BookNotInException;

    MagazineItem selectMagazineItemById(Integer id,Integer location) throws BookNotFoundException, ErrorLocationException, BookNotInException;

    PaperItem selectPaperItemById(Integer id,Integer location) throws ErrorLocationException, BookNotFoundException, BookNotInException;
}
