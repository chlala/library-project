package com.example.library.controller;

import com.example.library.entity.Borrow;
import com.example.library.entity.Result;
import com.example.library.entity.user.serve.ServeObject;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import com.example.library.exception.*;
import com.example.library.service.user.ServerObjectService;
import com.example.library.util.JWTUtils;
import com.example.library.vo.request.user.RegisterRequestVO;
import com.example.library.vo.response.LoginResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 11:00
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class ServerObjectController {

    @Autowired
    private ServerObjectService serverObjectService;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("/register")
    public Result register(@RequestBody @Valid RegisterRequestVO vo, @RequestParam String role) throws Exception {
        if(role==null||role.equals("")){
            return new Result(false,"请选择身份");
        }
        int result = serverObjectService.register(vo, role);
        if(result==1){
            return new Result(true,"注册成功");
        }
        return new Result(false,"该卡号已注册");
    }

    @GetMapping("/login")
    public Result login(String no, String password) throws UserNotFoundException {
        ServeObject serveObject = serverObjectService.selectServeObject(no, password);
        String role;
        if(serveObject instanceof Teacher){
            role="teacher";
        } else if(serveObject instanceof Junior){
            role="junior";
        } else if(serveObject instanceof Bachelor){
            role="bachelor";
        } else if(serveObject instanceof Master){
            role="master";
        } else {
            role="doctor";
        }
        LoginResponseVO vo = LoginResponseVO.getEntity(serveObject);
        String token = jwtUtils.createJWT(no, serveObject.getName(), role);
        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        map.put("role",role);
        return new Result(true,"登录成功",vo,map);
    }

    @GetMapping("/nowBorrowRecord")
    public Result nowBorrowRecord(String no) throws NotRecordException {
        List<Borrow> borrows = serverObjectService.selectNowBorrowRecord(no);
        return new Result(true,"查询成功",borrows);
    }

    @PostMapping("/updateTeacherPwd")
    public Result updateTeacherPwd(@RequestBody Teacher teacher) throws SystemException {
        serverObjectService.updateServeObject(teacher);
        return new Result(true,"修改成功");
    }

    @PostMapping("/updateJuniorPwd")
    public Result updateJuniorPwd(@RequestBody Junior junior) throws SystemException {
        serverObjectService.updateServeObject(junior);
        return new Result(true,"修改成功");
    }

    @PostMapping("/updateBachelorPwd")
    public Result updateBachelorPwd(@RequestBody Bachelor bachelor) throws SystemException {
        serverObjectService.updateServeObject(bachelor);
        return new Result(true,"修改成功");
    }

    @PostMapping("/updateMasterPwd")
    public Result updateMasterPwd(@RequestBody Master master) throws SystemException {
        serverObjectService.updateServeObject(master);
        return new Result(true,"修改成功");
    }

    @PostMapping("/updateDoctorPwd")
    public Result updateDoctorPwd(@RequestBody Doctor doctor) throws SystemException {
        serverObjectService.updateServeObject(doctor);
        return new Result(true,"修改成功");
    }

    @PostMapping("/orderOrdinaryBook")
    public Result orderOrdinaryBook(Integer biId,String no) throws UserNotFoundException, BookNotFoundException, NotBindEmailException, AlreadyOrderException {
        serverObjectService.orderOrdinaryBook(biId,no);
        return new Result(true,"预约成功");
    }

    @PostMapping("/orderMagazine")
    public Result orderMagazine(Integer biId,String no) throws UserNotFoundException, BookNotFoundException, NotBindEmailException, AlreadyOrderException {
        serverObjectService.orderMagazine(biId,no);
        return new Result(true,"预约成功");
    }

    @PostMapping("/orderPaper")
    public Result orderPaper(Integer biId,String no) throws UserNotFoundException, BookNotFoundException, NotBindEmailException, AlreadyOrderException {
        serverObjectService.orderPaper(biId,no);
        return new Result(true,"预约成功");
    }

    @PutMapping("/bindEmail")
    public Result bindEmail(String role,String no,String email) throws SystemException {
        serverObjectService.bindEmail(role,no,email);
        return new Result(true,"绑定成功");
    }
}
