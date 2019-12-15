package com.example.library.service.crud.impl;

import com.example.library.entity.user.BookAdmin;
import com.example.library.entity.user.SystemAdmin;
import com.example.library.exception.UserNotFoundException;
import com.example.library.mapper.user.BookAdminMapper;
import com.example.library.mapper.user.SystemAdminMapper;
import com.example.library.service.crud.AdminService;
import com.example.library.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/11 21:23
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private BookAdminMapper bookAdminMapper;

    @Autowired
    private SystemAdminMapper systemAdminMapper;

    @Autowired
    private CommonUtil commonUtil;

    @Override
    public BookAdmin selectBookAdminByNameAndPassword(String name, String password) throws UserNotFoundException {
        Example example = commonUtil.loginCriteria(BookAdmin.class, "name", name);
        BookAdmin bookAdmin = bookAdminMapper.selectOneByExample(example);
        if(bookAdmin==null){
            throw new UserNotFoundException("用户不存在");
        }
        if(encoder.matches(password,bookAdmin.getPassword())){
            return bookAdmin;
        }
        throw new UserNotFoundException("用户名或密码错误");
    }

    @Override
    public SystemAdmin selectSystemAdminByNameAndPassword(String name, String password) throws UserNotFoundException {
        Example example = commonUtil.loginCriteria(BookAdmin.class, "name", name);
        SystemAdmin systemAdmin = systemAdminMapper.selectOneByExample(example);
        if(systemAdmin==null){
            throw new UserNotFoundException("用户不存在");
        }
        if(encoder.matches(password,systemAdmin.getPassword())){
            return systemAdmin;
        }
        throw new UserNotFoundException("用户名或密码错误");
    }
}
