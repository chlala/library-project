package com.example.library.service.crud.impl;

import com.example.library.entity.user.BookAdmin;
import com.example.library.entity.user.SystemAdmin;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import com.example.library.exception.UserAlreadyExistException;
import com.example.library.exception.UserNotFoundException;
import com.example.library.mapper.user.*;
import com.example.library.service.crud.UserService;
import com.example.library.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 15:25
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SystemAdminMapper systemAdminMapper;

    @Autowired
    private BookAdminMapper bookAdminMapper;

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
    private BCryptPasswordEncoder encoder;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public List<BookAdmin> selectAllBookAdmin() {
        return bookAdminMapper.selectAll();
    }

    @Override
    public BookAdmin selectBookAdminByNameAndPassword(String name, String password) throws UserNotFoundException {
        Example example = commonUtil.loginCriteria(BookAdmin.class, "name",name);
        BookAdmin bookAdmin= bookAdminMapper.selectOneByExample(example);
        if (bookAdmin != null && encoder.matches(password,bookAdmin.getPassword())) {
            return bookAdmin;
        }
        throw new UserNotFoundException("用户名或密码错误");
    }

    @Override
    public int insertBookAdmin(BookAdmin bookAdmin) {
        bookAdmin.setPassword(encoder.encode("123"));
        return bookAdminMapper.insert(bookAdmin);
    }

    @Override
    public int updateBookAdmin(BookAdmin bookAdmin) {
        if(bookAdmin.getPassword()!=null){
            bookAdmin.setPassword(encoder.encode(bookAdmin.getPassword()));
        }
        return bookAdminMapper.updateByPrimaryKeySelective(bookAdmin);
    }

    @Override
    public int deleteBookAdminById(Integer id) {
        return bookAdminMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSystemAdmin(SystemAdmin systemAdmin) {
        systemAdmin.setPassword(encoder.encode("123"));
        return systemAdminMapper.insert(systemAdmin);
    }

    @Override
    public int updateSystemAdmin(SystemAdmin systemAdmin) {
        systemAdmin.setPassword(encoder.encode(systemAdmin.getPassword()));
        return systemAdminMapper.updateByPrimaryKeySelective(systemAdmin);
    }

    @Override
    public List<SystemAdmin> selectAllSystemAdmin() {
        return systemAdminMapper.selectAll();
    }

    @Override
    public SystemAdmin selectSystemAdminByNameAndPassword(String name, String password) throws UserNotFoundException {
        Example example = commonUtil.loginCriteria(SystemAdmin.class,"name", name);
        SystemAdmin systemAdmin= systemAdminMapper.selectOneByExample(example);
        if (systemAdmin != null && encoder.matches(password,systemAdmin.getPassword())) {
            return systemAdmin;
        }
        throw new UserNotFoundException("用户名或密码错误");
    }

    @Override
    public int insertTeacher(Teacher teacher) throws UserAlreadyExistException {
        teacher.setPassword(encoder.encode(teacher.getPassword()));
        int result;
        try {
            result = teacherMapper.insert(teacher);
        } catch (DataAccessException e) {
            throw new UserAlreadyExistException("该卡号已被注册");
        }
        return result;
    }

    @Override
    public Teacher selectTeacherByNoAndPassword(String no, String password) {
        Example example = commonUtil.loginCriteria(Teacher.class,"no",no);
        Teacher teacher= teacherMapper.selectOneByExample(example);
        if (teacher != null && encoder.matches(password,teacher.getPassword())) {
            return teacher;
        }
        return null;
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        teacher.setPassword(encoder.encode(teacher.getPassword()));
        return teacherMapper.updateByPrimaryKeySelective(teacher);
    }

    @Override
    public int deleteTeacherById(String no) {
        return teacherMapper.deleteByPrimaryKey(no);
    }

    @Override
    public int insertJunior(Junior junior) throws UserAlreadyExistException {
        junior.setPassword(encoder.encode(junior.getPassword()));
        int result;
        try {
            result = juniorMapper.insert(junior);
        } catch (DataAccessException e) {
            throw new UserAlreadyExistException("该卡号已被注册");
        }
        return result;
    }

    @Override
    public Junior selectJuniorByNoAndPassword(String no, String password) {
        Example example = commonUtil.loginCriteria(Junior.class,"no", no);
        Junior junior= juniorMapper.selectOneByExample(example);
        if (junior != null && encoder.matches(password,junior.getPassword())) {
            return junior;
        }
        return null;
    }

    @Override
    public int updateJunior(Junior junior) {
        return juniorMapper.updateByPrimaryKeySelective(junior);
    }

    @Override
    public int deleteJuniorById(String no) {
        return juniorMapper.deleteByPrimaryKey(no);
    }

    @Override
    public int inertBachelor(Bachelor bachelor) throws UserAlreadyExistException {
        bachelor.setPassword(encoder.encode(bachelor.getPassword()));
        int result;
        try {
            result = bachelorMapper.insert(bachelor);
        } catch (DataAccessException e) {
            throw new UserAlreadyExistException("该卡号已被注册");
        }
        return result;
    }

    @Override
    public Bachelor selectBachelorByNoAndPassword(String no, String password) {
        Example example = commonUtil.loginCriteria(Bachelor.class, "no",no);
        Bachelor bachelor= bachelorMapper.selectOneByExample(example);
        if (bachelor != null && encoder.matches(password,bachelor.getPassword())) {
            return bachelor;
        }
        return null;
    }

    @Override
    public int updateBachelor(Bachelor bachelor) {
        return bachelorMapper.updateByPrimaryKeySelective(bachelor);
    }

    @Override
    public int deleteBachelorById(String no) {
        return bachelorMapper.deleteByPrimaryKey(no);
    }

    @Override
    public int insertMaster(Master master) throws UserAlreadyExistException {
        master.setPassword(encoder.encode(master.getPassword()));
        int result;
        try {
            result = masterMapper.insert(master);
        } catch (DataAccessException e) {
            throw new UserAlreadyExistException("该卡号已被注册");
        }
        return result;
    }

    @Override
    public Master selectMasterByNoAndPassword(String no, String password) {
        Example example = commonUtil.loginCriteria(Master.class, "no",no);
        Master master= masterMapper.selectOneByExample(example);
        if (master != null && encoder.matches(password,master.getPassword())) {
            return master;
        }
        return null;
    }

    @Override
    public int updateMaster(Master master) {
        return masterMapper.updateByPrimaryKeySelective(master);
    }

    @Override
    public int deleteMasterById(String no) {
        return masterMapper.deleteByPrimaryKey(no);
    }

    @Override
    public int insertDoctor(Doctor doctor) throws UserAlreadyExistException {
        doctor.setPassword(encoder.encode(doctor.getPassword()));
        int result;
        try {
            result = doctorMapper.insert(doctor);
        } catch (DataAccessException e) {
            throw new UserAlreadyExistException("该卡号已被注册");
        }
        return result;
    }

    @Override
    public Doctor selectDoctorByNoAndPassword(String no, String password) {
        Example example = commonUtil.loginCriteria(Doctor.class, "no",no);
        Doctor doctor= doctorMapper.selectOneByExample(example);
        if (doctor != null && encoder.matches(password,doctor.getPassword())) {
            return doctor;
        }
        return null;
    }

    @Override
    public int updateDoctor(Doctor doctor) {
        return doctorMapper.updateByPrimaryKeySelective(doctor);
    }

    @Override
    public int deleteDoctorById(String no) {
        return doctorMapper.deleteByPrimaryKey(no);
    }

    @Override
    public Teacher selectTeacherById(String no) {
        return teacherMapper.selectByPrimaryKey(no);
    }

    @Override
    public Junior selectJuniorById(String no) {
        return juniorMapper.selectByPrimaryKey(no);
    }

    @Override
    public Bachelor selectBachelorById(String no) {
        return bachelorMapper.selectByPrimaryKey(no);
    }

    @Override
    public Master selectMasterById(String no) {
        return masterMapper.selectByPrimaryKey(no);
    }

    @Override
    public Doctor selectDoctorById(String no) {
        return doctorMapper.selectByPrimaryKey(no);
    }
}
