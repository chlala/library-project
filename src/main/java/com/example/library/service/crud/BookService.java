package com.example.library.service.crud;

import com.example.library.entity.book.Book;
import com.example.library.exception.BookNotFoundException;
import com.example.library.vo.request.book.AddMagazineRequestVO;
import com.example.library.vo.request.book.AddOrdinaryBookRequestVO;
import com.example.library.vo.request.book.AddPaperRequestVO;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 18:07
 */
public interface BookService {

    int insertOrdinaryBook(AddOrdinaryBookRequestVO vo, Integer l1, Integer l2, Integer l3);

//    int updateOrdinaryBook(AddOrdinaryBookRequestVO vo);

    int insertMagazine(AddMagazineRequestVO vo, Integer l1, Integer l2, Integer l3);

//    int updateMagazine(AddOrdinaryBookRequestVO vo);

    int insertPaper(AddPaperRequestVO vo, Integer l1, Integer l2, Integer l3);

//    int updatePaper(AddOrdinaryBookRequestVO vo);

    Book findBook(Integer bookType,Integer biId) throws BookNotFoundException;

}
