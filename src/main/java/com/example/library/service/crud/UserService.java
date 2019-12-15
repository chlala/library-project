package com.example.library.service.crud;

import com.example.library.entity.user.BookAdmin;
import com.example.library.entity.user.SystemAdmin;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import com.example.library.exception.UserAlreadyExistException;
import com.example.library.exception.UserNotFoundException;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 15:24
 */
public interface UserService {

    List<BookAdmin> selectAllBookAdmin();

    BookAdmin selectBookAdminByNameAndPassword(String name,String password) throws UserNotFoundException;

    int insertBookAdmin(BookAdmin bookAdmin);

    int updateBookAdmin(BookAdmin bookAdmin);

    int deleteBookAdminById(Integer id);

    int insertSystemAdmin(SystemAdmin systemAdmin);

    int updateSystemAdmin(SystemAdmin systemAdmin);

    List<SystemAdmin> selectAllSystemAdmin();

    SystemAdmin selectSystemAdminByNameAndPassword(String name,String password) throws UserNotFoundException;

    int insertTeacher(Teacher teacher) throws UserAlreadyExistException;

    Teacher selectTeacherByNoAndPassword(String no,String password);

    int updateTeacher(Teacher teacher);

    int deleteTeacherById(String no);

    int insertJunior(Junior junior) throws UserAlreadyExistException;

    Junior selectJuniorByNoAndPassword(String no,String password);

    int updateJunior(Junior junior);

    int deleteJuniorById(String no);

    int inertBachelor(Bachelor bachelor) throws UserAlreadyExistException;

    Bachelor selectBachelorByNoAndPassword(String no,String password);

    int updateBachelor(Bachelor bachelor);

    int deleteBachelorById(String no);

    int insertMaster(Master master) throws UserAlreadyExistException;

    Master selectMasterByNoAndPassword(String no, String password);

    int updateMaster(Master master);

    int deleteMasterById(String no);

    int insertDoctor(Doctor doctor) throws UserAlreadyExistException;

    Doctor selectDoctorByNoAndPassword(String no, String password);

    int updateDoctor(Doctor doctor);

    int deleteDoctorById(String no);

    Teacher selectTeacherById(String no);

    Junior selectJuniorById(String no);

    Bachelor selectBachelorById(String no);

    Master selectMasterById(String no);

    Doctor selectDoctorById(String no);
}
