package com.example.library.service.user.impl;

import com.example.library.entity.Borrow;
import com.example.library.entity.Common;
import com.example.library.entity.book.OrderItem;
import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.entity.book.bookitem.PaperItem;
import com.example.library.entity.user.serve.ServeObject;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import com.example.library.exception.*;
import com.example.library.mapper.book.OrderMapper;
import com.example.library.mapper.book.item.MagazineItemMapper;
import com.example.library.mapper.book.item.OrdinaryBookItemMapper;
import com.example.library.mapper.book.item.PaperItemMapper;
import com.example.library.mapper.user.*;
import com.example.library.service.crud.UserService;
import com.example.library.service.user.ServerObjectService;
import com.example.library.util.CommonUtil;
import com.example.library.vo.request.user.RegisterRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 10:35
 */
@Service
public class ServerObjectServiceImpl implements ServerObjectService {

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowMapper borrowMapper;

    @Autowired
    private CommonUtil commonUtil;
    
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
    private BorrowRecordMapper borrowRecordMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private ServerObjectService serverObjectService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrdinaryBookItemMapper ordinaryBookItemMapper;

    @Autowired
    private MagazineItemMapper magazineItemMapper;

    @Autowired
    private PaperItemMapper paperItemMapper;

    @Override
    public ServeObject selectServeObject(String no, String password) throws UserNotFoundException {
        Teacher teacher = userService.selectTeacherByNoAndPassword(no, password);
        if(teacher!=null){
            return teacher;
        }
        Bachelor bachelor = userService.selectBachelorByNoAndPassword(no, password);
        if(bachelor!=null){
            return bachelor;
        }
        Junior junior = userService.selectJuniorByNoAndPassword(no, password);
        if(junior!=null){
            return junior;
        }
        Master master = userService.selectMasterByNoAndPassword(no, password);
        if(master!=null){
            return master;
        }
        Doctor doctor = userService.selectDoctorByNoAndPassword(no, password);
        if(doctor!=null){
            return doctor;
        }
        throw new UserNotFoundException("用户名或密码错误");
    }

    @Override
    public ServeObject selectServeObject(String no) throws UserNotFoundException, BorrowTooMuchException, OweMoneyException, BookExpiredException {
        Teacher teacher = borrowMapper.selectTeacherAndBorrowStrategy(no, Common.TEACHER_TYPE,Common.VALIDATE);
        if(commonUtil.checkUser(teacher)){
            return teacher;
        }
        Junior junior = borrowMapper.selectJuniorAndBorrowStrategy(no,Common.JUNIOR_TYPE,Common.VALIDATE);
        if(commonUtil.checkUser(junior)){
            return junior;
        }
        Bachelor bachelor = borrowMapper.selectBachelorAndBorrowStrategy(no, Common.BACHELOR_TYPE, Common.VALIDATE);
        if(commonUtil.checkUser(bachelor)){
            return bachelor;
        }
        Master master = borrowMapper.selectMasterAndBorrowStrategy(no, Common.MASTER_TYPE, Common.VALIDATE);
        if(commonUtil.checkUser(master)){
            return master;
        }
        Doctor doctor = borrowMapper.selectDoctorAndBorrowStrategy(no, Common.DOCTOR_TYPE, Common.VALIDATE);
        if(commonUtil.checkUser(doctor)){
            return doctor;
        }
        throw new UserNotFoundException("该用户不存在");
    }

    @Override
    public ServeObject findServeObject(String no) throws UserNotFoundException {
        ServeObject serveObject;
        serveObject = teacherMapper.selectByPrimaryKey(no);
        if(serveObject!=null){
            return serveObject;
        }
        serveObject=juniorMapper.selectByPrimaryKey(no);
        if(serveObject!=null){
            return serveObject;
        }
        serveObject=bachelorMapper.selectByPrimaryKey(no);
        if(serveObject!=null){
            return serveObject;
        }
        serveObject=masterMapper.selectByPrimaryKey(no);
        if(serveObject!=null){
            return serveObject;
        }
        serveObject=doctorMapper.selectByPrimaryKey(no);
        if(serveObject!=null){
            return serveObject;
        }
        throw new UserNotFoundException("用户不存在");
    }

    @Override
    public int findServerObject(String no) throws UserNotFoundException {
        Teacher teacher = teacherMapper.selectByPrimaryKey(no);
        if(teacher!=null){
            return Common.TEACHER_TYPE;
        }
        Junior junior = juniorMapper.selectByPrimaryKey(no);
        if(junior!=null){
            return Common.JUNIOR_TYPE;
        }
        Bachelor bachelor = bachelorMapper.selectByPrimaryKey(no);
        if(bachelor!=null){
            return Common.BACHELOR_TYPE;
        }
        Master master = masterMapper.selectByPrimaryKey(no);
        if(master!=null){
            return Common.MASTER_TYPE;
        }
        Doctor doctor = doctorMapper.selectByPrimaryKey(no);
        if(doctor!=null){
            return Common.DOCTOR_TYPE;
        }
        throw new UserNotFoundException("该用户不存在");
    }

    @Override
    public int findUser(String no,ServeObject serveObject) throws UserNotFoundException {
        Teacher teacher = teacherMapper.selectByPrimaryKey(no);
        if(teacher!=null){
            serveObject.setNo(no);
            serveObject.setName(teacher.getName());
            serveObject.setOweMoney(teacher.getOweMoney());
            return Common.TEACHER_TYPE;
        }
        Junior junior = juniorMapper.selectByPrimaryKey(no);
        if(junior!=null){
            serveObject.setNo(no);
            serveObject.setName(junior.getName());
            serveObject.setOweMoney(junior.getOweMoney());
            return Common.JUNIOR_TYPE;
        }
        Bachelor bachelor = bachelorMapper.selectByPrimaryKey(no);
        if(bachelor!=null){
            serveObject.setNo(no);
            serveObject.setName(bachelor.getName());
            serveObject.setOweMoney(bachelor.getOweMoney());
            return Common.BACHELOR_TYPE;
        }
        Master master = masterMapper.selectByPrimaryKey(no);
        if(master!=null){
            serveObject.setNo(no);
            serveObject.setName(master.getName());
            serveObject.setOweMoney(master.getOweMoney());
            return Common.MASTER_TYPE;
        }
        Doctor doctor = doctorMapper.selectByPrimaryKey(no);
        if(doctor!=null){
            serveObject.setNo(no);
            serveObject.setName(doctor.getName());
            serveObject.setOweMoney(doctor.getOweMoney());
            return Common.DOCTOR_TYPE;
        }
        throw new UserNotFoundException("该用户不存在");
    }

    @Override
    public int register(RegisterRequestVO vo, String role) throws Exception {
        ServeObject serveObject = RegisterRequestVO.getEntity(vo,role);
        if(role.equals("teacher")){
            return userService.insertTeacher((Teacher) serveObject);
        }
        if(role.equals("junior")){
            return userService.insertJunior((Junior) serveObject);
        }
        if(role.equals("bachelor")){
            return userService.inertBachelor((Bachelor) serveObject);
        }
        if (role.equals("master")) {
            return userService.insertMaster((Master) serveObject);
        }
        if(role.equals("doctor")){
            return userService.insertDoctor((Doctor) serveObject);
        }
        throw new SystemException("系统异常");
    }

    @Override
    public List<Borrow> selectNowBorrowRecord(String no) throws NotRecordException {
        List<Borrow> borrows=new ArrayList<>();
        List<Borrow> ordinaryBorrowRecord = borrowRecordMapper.selectOrdinaryBorrowRecord(no);
        List<Borrow> magazineBorrowRecord = borrowRecordMapper.selectMagazineBorrowRecord(no);
        List<Borrow> paperBorrowRecord = borrowRecordMapper.selectPaperBorrowRecord(no);
        borrows.addAll(ordinaryBorrowRecord);
        borrows.addAll(magazineBorrowRecord);
        borrows.addAll(paperBorrowRecord);
        if(borrows.size()==0){
            throw new NotRecordException("暂无记录");
        }
        return borrows;
    }

    @Override
    public void updateServeObject(Teacher teacher) throws SystemException {
        String encode = encoder.encode(teacher.getPassword());
        teacher.setPassword(encode);
        int result = teacherMapper.updateByPrimaryKeySelective(teacher);
        if(result==1){
            return;
        }
        throw new SystemException("系统异常");
    }

    @Override
    public void updateServeObject(Junior junior) throws SystemException {
        String encode = encoder.encode(junior.getPassword());
        junior.setPassword(encode);
        int result = juniorMapper.updateByPrimaryKeySelective(junior);
        if(result==1){
            return;
        }
        throw new SystemException("系统异常");
    }

    @Override
    public void updateServeObject(Bachelor bachelor) throws SystemException {
        String encode = encoder.encode(bachelor.getPassword());
        bachelor.setPassword(encode);
        int result = bachelorMapper.updateByPrimaryKeySelective(bachelor);
        if(result==1){
            return;
        }
        throw new SystemException("系统异常");
    }

    @Override
    public void updateServeObject(Master master) throws SystemException {
        String encode = encoder.encode(master.getPassword());
        master.setPassword(encode);
        int result = masterMapper.updateByPrimaryKeySelective(master);
        if(result==1){
            return;
        }
        throw new SystemException("系统异常");
    }

    @Override
    public void updateServeObject(Doctor doctor) throws SystemException {
        String encode = encoder.encode(doctor.getPassword());
        doctor.setPassword(encode);
        int result = doctorMapper.updateByPrimaryKeySelective(doctor);
        if(result==1){
            return;
        }
        throw new SystemException("系统异常");
    }

    @Override
    public void pay(String no) throws UserNotFoundException, SystemException {
        int type = serverObjectService.findServerObject(no);
        int result;
        if(type==Common.TEACHER_TYPE){
            Teacher teacher=new Teacher();
            teacher.setNo(no);
            teacher.setOweMoney(0.0);
            result=teacherMapper.updateByPrimaryKeySelective(teacher);
        } else if(type==Common.JUNIOR_TYPE){
            Junior junior=new Junior();
            junior.setNo(no);
            junior.setOweMoney(0.0);
            result=juniorMapper.updateByPrimaryKeySelective(junior);
        } else if(type==Common.BACHELOR_TYPE){
            Bachelor bachelor=new Bachelor();
            bachelor.setNo(no);
            bachelor.setOweMoney(0.0);
            result=bachelorMapper.updateByPrimaryKeySelective(bachelor);
        } else if(type==Common.MASTER_TYPE){
            Master master=new Master();
            master.setName(no);
            master.setOweMoney(0.0);
            result=masterMapper.updateByPrimaryKeySelective(master);
        } else {
            Doctor doctor=new Doctor();
            doctor.setName(no);
            doctor.setOweMoney(0.0);
            result=doctorMapper.updateByPrimaryKeySelective(doctor);
        }
        if(result==1){
            return;
        }
        throw new SystemException("系统异常");
    }

    @Override
    public void reset(String no) throws UserNotFoundException, SystemException {
        int type = serverObjectService.findServerObject(no);
        int result;
        if(type==Common.TEACHER_TYPE){
            Teacher teacher=new Teacher();
            teacher.setNo(no);
            teacher.setPassword(encoder.encode(no));
            result=teacherMapper.updateByPrimaryKeySelective(teacher);
        } else if(type==Common.JUNIOR_TYPE){
            Junior junior=new Junior();
            junior.setNo(no);
            junior.setPassword(encoder.encode(no));
            result=juniorMapper.updateByPrimaryKeySelective(junior);
        } else if(type==Common.BACHELOR_TYPE){
            Bachelor bachelor=new Bachelor();
            bachelor.setNo(no);
            bachelor.setPassword(encoder.encode(no));
            result=bachelorMapper.updateByPrimaryKeySelective(bachelor);
        } else if(type==Common.MASTER_TYPE){
            Master master=new Master();
            master.setName(no);
            master.setPassword(encoder.encode(no));
            result=masterMapper.updateByPrimaryKeySelective(master);
        } else {
            Doctor doctor=new Doctor();
            doctor.setName(no);
            doctor.setPassword(encoder.encode(no));
            result=doctorMapper.updateByPrimaryKeySelective(doctor);
        }
        if(result==1){
            return;
        }
        throw new SystemException("系统异常");
    }

    @Override
    public void bindEmail(String role, String no,String email) throws SystemException {
        if(role.equals("teacher")){
            Teacher teacher=new Teacher();
            teacher.setNo(no);
            teacher.setEmail(email);
            teacherMapper.updateByPrimaryKeySelective(teacher);
        } else if(role.equals("junior")){
            Junior junior=new Junior();
            junior.setNo(no);
            junior.setEmail(email);
            juniorMapper.updateByPrimaryKeySelective(junior);
        } else if(role.equals("bachelor")){
            Bachelor bachelor=new Bachelor();
            bachelor.setNo(no);
            bachelor.setEmail(email);
            bachelorMapper.updateByPrimaryKeySelective(bachelor);
        } else if(role.equals("master")){
            Master master=new Master();
            master.setNo(no);
            master.setEmail(email);
            masterMapper.updateByPrimaryKeySelective(master);
        } else if(role.equals("doctor")){
            Doctor doctor=new Doctor();
            doctor.setNo(no);
            doctor.setEmail(email);
            doctorMapper.updateByPrimaryKeySelective(doctor);
        } else {
            throw new SystemException("系统异常");
        }
    }

    @Override
    public void orderOrdinaryBook(Integer biId, String no) throws UserNotFoundException, NotBindEmailException, BookNotFoundException, AlreadyOrderException {
        ServeObject serveObject = serverObjectService.findServeObject(no);
        if(serveObject.getEmail()==null){
            throw new NotBindEmailException("请先绑定邮箱");
        }
        OrdinaryBookItem item = ordinaryBookItemMapper.selectByPrimaryKey(biId);
        if(item==null){
            throw new BookNotFoundException("该书不存在");
        }
        Example example = commonUtil.selectOrderItem(biId, Common.ORDINARY_BOOK_TYPE, no);
        OrderItem orderItem = orderMapper.selectOneByExample(example);
        if(orderItem!=null){
            throw new AlreadyOrderException("已经预约过了");
        }
        OrderItem order=new OrderItem();
        order.setBiId(biId);
        order.setNo(no);
        order.setValidate(Common.VALIDATE);
        order.setBookType(Common.ORDINARY_BOOK_TYPE);
        orderMapper.insert(order);
    }

    @Override
    public void orderMagazine(Integer biId, String no) throws UserNotFoundException, NotBindEmailException, BookNotFoundException, AlreadyOrderException {
        ServeObject serveObject = serverObjectService.findServeObject(no);
        if(serveObject.getEmail()==null){
            throw new NotBindEmailException("请先绑定邮箱");
        }
        MagazineItem item = magazineItemMapper.selectByPrimaryKey(biId);
        if(item==null){
            throw new BookNotFoundException("该书不存在");
        }
        Example example = commonUtil.selectOrderItem(biId, Common.MAGAZINE_TYPE, no);
        OrderItem orderItem = orderMapper.selectOneByExample(example);
        if(orderItem!=null){
            throw new AlreadyOrderException("已经预约过了");
        }
        OrderItem order=new OrderItem();
        order.setBiId(biId);
        order.setNo(no);
        order.setValidate(Common.VALIDATE);
        order.setBookType(Common.MAGAZINE_TYPE);
        orderMapper.insert(order);
    }

    @Override
    public void orderPaper(Integer biId, String no) throws UserNotFoundException, NotBindEmailException, BookNotFoundException, AlreadyOrderException {
        ServeObject serveObject = serverObjectService.findServeObject(no);
        if(serveObject.getEmail()==null){
            throw new NotBindEmailException("请先绑定邮箱");
        }
        PaperItem item = paperItemMapper.selectByPrimaryKey(biId);
        if(item==null){
            throw new BookNotFoundException("该书不存在");
        }
        Example example = commonUtil.selectOrderItem(biId, Common.PAPER_TYPE, no);
        OrderItem orderItem = orderMapper.selectOneByExample(example);
        if(orderItem!=null){
            throw new AlreadyOrderException("已经预约过了");
        }
        OrderItem order=new OrderItem();
        order.setBiId(biId);
        order.setNo(no);
        order.setValidate(Common.VALIDATE);
        order.setBookType(Common.PAPER_TYPE);
        orderMapper.insert(order);
    }

}
