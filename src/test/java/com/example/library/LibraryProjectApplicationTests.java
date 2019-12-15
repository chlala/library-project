package com.example.library;

import com.example.library.entity.Borrow;
import com.example.library.entity.Common;
import com.example.library.entity.user.BookAdmin;
import com.example.library.entity.user.serve.ServeObject;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.exception.*;
import com.example.library.mapper.user.BorrowMapper;
import com.example.library.mapper.user.BorrowRecordMapper;
import com.example.library.service.bookadmin.BorrowAndReturnService;
import com.example.library.service.user.ServerObjectService;
import com.example.library.util.MailSendUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.List;

@SpringBootTest
@MapperScan("com.example.library.mapper")
class LibraryProjectApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private com.example.library.service.crud.UserService userService;

    @Test
    public void testInsertBookAdmin(){
        BookAdmin bookAdmin=new BookAdmin();
//        bookAdmin.setId(1);
        bookAdmin.setName("肖在");
        bookAdmin.setPassword("123");
        bookAdmin.setLocation(1);
        userService.insertBookAdmin(bookAdmin);
    }

    @Test
    public void testAddTeacher() throws UserAlreadyExistException {
        Teacher teacher=new Teacher();
        teacher.setNo("201913511");
        teacher.setPassword("123");
        teacher.setName("陈就");
        userService.insertTeacher(teacher);
    }

    @Autowired
    private BorrowMapper borrowMapper;

    @Test
    public void testBorrowCheck(){
        Teacher teacher = borrowMapper.selectTeacherAndBorrowStrategy("892321", Common.TEACHER_TYPE, Common.VALIDATE);
        System.out.println(teacher);
    }

    @Autowired
    private ServerObjectService serverObjectService;

    @Test
    public void testBorrowCheckService() throws UserNotFoundException, BookExpiredException, OweMoneyException, BorrowTooMuchException {
        ServeObject serveObject = serverObjectService.selectServeObject("2018341");
        System.out.println(serveObject);
    }

    @Autowired
    private BorrowAndReturnService borrowAndReturnService;

    @Test
    public void testTeacherBorrowOrdinaryBook(){
        int result = borrowAndReturnService.teacherBorrowOrdinaryBook(18, 14, "892321");
        System.out.println(result);
    }

    @Autowired
    private BorrowRecordMapper borrowRecordMapper;

    @Test
    public void testSelectNowBorrow(){
        List<Borrow> borrows = borrowRecordMapper.selectOrdinaryBorrowRecord("1");
        System.out.println(borrows);
    }

    @Autowired
    private MailSendUtil mailSendUtil;

    @Test
    public void testSend(){
        mailSendUtil.sendMail("1032621325@qq.com","chl","哈哈");
    }
}
