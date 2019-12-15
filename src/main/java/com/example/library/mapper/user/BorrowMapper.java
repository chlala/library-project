package com.example.library.mapper.user;

import com.example.library.entity.Borrow;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/10 13:00
 */
@Mapper
public interface BorrowMapper {

    Teacher selectTeacherAndBorrowStrategy(String no, Integer type,Integer validate);

    Junior selectJuniorAndBorrowStrategy(String no, Integer type,Integer validate);

    Bachelor selectBachelorAndBorrowStrategy(String no, Integer type,Integer validate);

    Master selectMasterAndBorrowStrategy(String no, Integer type,Integer validate);

    Doctor selectDoctorAndBorrowStrategy(String no, Integer type,Integer validate);

    int teacherBorrowOrdinaryBook(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int teacherBorrowMagazine(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int teacherBorrowPaper(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int juniorBorrowOrdinaryBook(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int juniorBorrowMagazine(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int juniorBorrowPaper(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int bachelorBorrowOrdinaryBook(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int bachelorBorrowMagazine(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int bachelorBorrowPaper(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int masterBorrowOrdinaryBook(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int masterBorrowMagazine(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int masterBorrowPaper(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int doctorBorrowOrdinaryBook(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int doctorBorrowMagazine(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

    int doctorBorrowPaper(Integer bookId, Integer biId,Integer bookType, String no,Date shouldReturnTime, Borrow borrow);

}
