package com.example.library.service.user;

import com.example.library.entity.Borrow;
import com.example.library.entity.user.serve.ServeObject;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import com.example.library.exception.*;
import com.example.library.vo.request.user.RegisterRequestVO;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 10:27
 */
public interface ServerObjectService {

    ServeObject selectServeObject(String no,String password) throws UserNotFoundException;

    ServeObject selectServeObject(String no) throws UserNotFoundException, BorrowTooMuchException, OweMoneyException, BookExpiredException;

    ServeObject findServeObject(String no) throws UserNotFoundException;

    int findServerObject(String no) throws UserNotFoundException;

    int findUser(String no,ServeObject serveObject) throws UserNotFoundException;

    int register(RegisterRequestVO vo, String role) throws Exception;

    List<Borrow> selectNowBorrowRecord(String no) throws NotRecordException;

    void updateServeObject(Teacher teacher) throws SystemException;

    void updateServeObject(Junior junior) throws SystemException;

    void updateServeObject(Bachelor bachelor) throws SystemException;

    void updateServeObject(Master master) throws SystemException;

    void updateServeObject(Doctor doctor) throws SystemException;

    void pay(String no) throws UserNotFoundException, SystemException;

    void reset(String no) throws UserNotFoundException, SystemException;

    void bindEmail(String role,String no,String email) throws SystemException;

    void orderOrdinaryBook(Integer biId,String no) throws UserNotFoundException, NotBindEmailException, BookNotFoundException, AlreadyOrderException;

    void orderMagazine(Integer biId,String no) throws UserNotFoundException, NotBindEmailException, BookNotFoundException, AlreadyOrderException;

    void orderPaper(Integer biId,String no) throws UserNotFoundException, NotBindEmailException, BookNotFoundException, AlreadyOrderException;


}
