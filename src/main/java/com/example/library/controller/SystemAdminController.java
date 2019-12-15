package com.example.library.controller;

import com.example.library.entity.Result;
import com.example.library.entity.user.BookAdmin;
import com.example.library.entity.user.SystemAdmin;
import com.example.library.exception.UserNotFoundException;
import com.example.library.service.crud.AdminService;
import com.example.library.service.crud.UserService;
import com.example.library.util.JWTUtils;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/11 21:32
 */
@RestController
@CrossOrigin
@RequestMapping("/systemAdmin")
public class SystemAdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result login(@RequestParam("no") String name, String password) throws UserNotFoundException {
        SystemAdmin systemAdmin = adminService.selectSystemAdminByNameAndPassword(name, password);
        String role="systemAdmin";
        String token = jwtUtils.createJWT(String.valueOf(systemAdmin.getId()), systemAdmin.getName(), role);
        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        map.put("role",role);
        return new Result(true,"登录成功",systemAdmin,map);
    }

    @GetMapping("/listBookAdmin")
    public Result listBookAdmin(){
        List<BookAdmin> bookAdmins = userService.selectAllBookAdmin();
        return new Result(true,"查询成功",bookAdmins);
    }

    @PostMapping("/addBookAdmin")
    public Result addBookAdmin(@RequestBody BookAdmin bookAdmin){
        userService.insertBookAdmin(bookAdmin);
        return new Result(true,"添加成功");
    }

    @PutMapping("/updateBookAdmin")
    public Result updateBookAdmin(@RequestBody BookAdmin bookAdmin){
        userService.updateBookAdmin(bookAdmin);
        return new Result(true,"修改成功");
    }

    @DeleteMapping("/deleteBookAdmin")
    public Result deleteBookAdmin(Integer id){
        userService.deleteBookAdminById(id);
        return new Result(true,"删除成功");
    }

    @PostMapping("/addSystemAdmin")
    public Result addSystemAdmin(@RequestBody SystemAdmin systemAdmin){
        userService.insertSystemAdmin(systemAdmin);
        return new Result(true,"添加成功");
    }

    @PutMapping("/changePwd")
    public Result changePwd(@RequestBody SystemAdmin systemAdmin){
        userService.updateSystemAdmin(systemAdmin);
        return new Result(true,"修改成功");
    }

}
