package com.example.library.service.bookadmin;

import com.example.library.entity.Borrow;
import com.example.library.entity.book.bookitem.BookItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.exception.*;

import java.util.Date;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/10 14:58
 */
public interface BorrowAndReturnService {

    int teacherBorrowOrdinaryBook(Integer bookId,Integer biId,String no);

    int juniorBorrowOrdinaryBook(Integer bookId,Integer biId,String no);

    int bachelorBorrowOrdinaryBook(Integer bookId,Integer biId,String no);

    int masterBorrowOrdinaryBook(Integer bookId,Integer biId,String no);

    int doctorBorrowOrdinaryBook(Integer bookId,Integer biId,String no);

    int teacherBorrowMagazine(Integer bookId,Integer biId,String no);

    int juniorBorrowMagazine(Integer bookId,Integer biId,String no);

    int bachelorBorrowMagazine(Integer bookId,Integer biId,String no);

    int masterBorrowMagazine(Integer bookId,Integer biId,String no);

    int doctorBorrowMagazine(Integer bookId,Integer biId,String no);

    int teacherBorrowPaper(Integer bookId,Integer biId,String no);

    int juniorBorrowPaper(Integer bookId,Integer biId,String no);

    int bachelorBorrowPaper(Integer bookId,Integer biId,String no);

    int masterBorrowPaper(Integer bookId,Integer biId,String no);

    int doctorBorrowPaper(Integer bookId,Integer biId,String no);

    int borrowOrdinaryBook(String no,Integer role, Integer biId,Integer location) throws SystemException, BookNotInException, ErrorLocationException, BookNotFoundException;

    int borrowMagazine(String no,Integer role, Integer biId,Integer location) throws SystemException, BookNotInException, ErrorLocationException, BookNotFoundException;

    int borrowPaper(String no,Integer role, Integer biId,Integer location) throws SystemException, BookNotInException, ErrorLocationException, BookNotFoundException;

    BookItem findBookItem(Integer biId,Integer bookType,Integer location) throws SystemException, ErrorLocationException, BookNotFoundException, StateErrorException;

    String returnBook(Integer biId,Integer bookType) throws UserNotFoundException, BookExpiredException, OweMoneyException, BorrowTooMuchException, SystemException, BookNotFoundException;

    void updateUser(int userType,String no,double fineMoney) throws SystemException;

    void updateBook(Integer bookType, Integer biId, Date shouldReturnDate) throws SystemException;

    void sendMail(Integer biId) throws UserNotFoundException, BookNotFoundException;

}
