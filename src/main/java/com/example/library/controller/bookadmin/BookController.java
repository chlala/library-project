package com.example.library.controller.bookadmin;

import com.example.library.entity.Result;
import com.example.library.entity.user.BookAdmin;
import com.example.library.entity.user.serve.ServeObject;
import com.example.library.exception.*;
import com.example.library.service.bookadmin.BorrowAndReturnService;
import com.example.library.service.crud.AdminService;
import com.example.library.service.crud.BookService;
import com.example.library.service.crud.UserService;
import com.example.library.service.user.ServerObjectService;
import com.example.library.util.JWTUtils;
import com.example.library.vo.request.book.AddMagazineRequestVO;
import com.example.library.vo.request.book.AddOrdinaryBookRequestVO;
import com.example.library.vo.request.book.AddPaperRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 17:08
 */
@RestController
@RequestMapping("/bookAdmin")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ServerObjectService serverObjectService;

    @Autowired
    private BorrowAndReturnService borrowAndReturnService;

    @Autowired
    private AdminService adminService;

    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result login(@RequestParam("no") String name,String password) throws UserNotFoundException {
        BookAdmin bookAdmin = adminService.selectBookAdminByNameAndPassword(name, password);
        String role="bookAdmin";
        String token = jwtUtils.createJWT(String.valueOf(bookAdmin.getId()), bookAdmin.getName(), role);
        Map<String,String> map=new HashMap<>();
        map.put("token",token);
        map.put("role",role);
        return new Result(true,"登录成功",bookAdmin,map);
    }

    @PostMapping("/addOrdinaryBook")
    public Result addOrdinaryBook(@RequestBody AddOrdinaryBookRequestVO vo, @RequestParam Integer l1, @RequestParam Integer l2, @RequestParam Integer l3) {
        bookService.insertOrdinaryBook(vo, l1, l2, l3);
        return new Result(true, "添加成功");
    }

    @PostMapping("/addMagazine")
    public Result addMagazine(@RequestBody AddMagazineRequestVO vo, @RequestParam Integer l1, @RequestParam Integer l2, @RequestParam Integer l3) {
        bookService.insertMagazine(vo, l1, l2, l3);
        return new Result(true, "添加成功");
    }

    @PostMapping("/addPaper")
    public Result addPaper(@RequestBody AddPaperRequestVO vo, @RequestParam Integer l1, @RequestParam Integer l2, @RequestParam Integer l3) {
        bookService.insertPaper(vo, l1, l2, l3);
        return new Result(true, "添加成功");
    }

    @GetMapping("/findUser")
    public Result findUser(String name) throws UserNotFoundException, BookExpiredException, OweMoneyException, BorrowTooMuchException {
        ServeObject serveObject = serverObjectService.selectServeObject(name);
        return new Result(true,"验证成功",serveObject);
    }

    @PostMapping("/borrowOrdinaryBook")
    public Result borrowOrdinaryBook(String no,Integer role, Integer biId,Integer location) throws BookNotFoundException, ErrorLocationException, BookNotInException, SystemException {
        borrowAndReturnService.borrowOrdinaryBook(no,role,biId,location);
        return new Result(true,"借书成功");
    }

    @PostMapping("/borrowMagazine")
    public Result borrowMagazine(String no,Integer role, Integer biId,Integer location) throws BookNotFoundException, ErrorLocationException, BookNotInException, SystemException {
        borrowAndReturnService.borrowMagazine(no,role,biId,location);
        return new Result(true,"借书成功");
    }

    @PostMapping("/borrowPaper")
    public Result borrowPaper(String no,Integer role, Integer biId,Integer location) throws BookNotFoundException, ErrorLocationException, BookNotInException, SystemException {
        borrowAndReturnService.borrowPaper(no,role,biId,location);
        return new Result(true,"借书成功");
    }

    @GetMapping("/checkBook")
    public Result checkBook(Integer biId,Integer bookType,Integer location) throws SystemException, ErrorLocationException, StateErrorException, BookNotFoundException {
        borrowAndReturnService.findBookItem(biId, bookType, location);
        return new Result(true,"验证成功");
    }

    @PostMapping("/returnBook")
    public Result returnBook(Integer biId,Integer bookType) throws UserNotFoundException, BookExpiredException, OweMoneyException, BorrowTooMuchException, SystemException, BookNotFoundException {
        String no=borrowAndReturnService.returnBook(biId,bookType);
        if(no!=null){
            return new Result(true,"还书成功",no);
        }
        return new Result(false,"还书失败");
    }

    @PostMapping("/updatePwd")
    public Result updatePwd(@RequestBody BookAdmin bookAdmin) throws SystemException {
        userService.updateBookAdmin(bookAdmin);
        return new Result(true,"修改成功");
    }

    @GetMapping("/checkUser")
    public Result checkUser(String no) throws UserNotFoundException {
        ServeObject serveObject=new ServeObject();
        int role = serverObjectService.findUser(no, serveObject);
        Map<String,Integer> map=new HashMap<>();
        map.put("role",role);
        return new Result(true,"查询成功",serveObject,map);
    }

    @PostMapping("/pay")
    public Result pay(String no) throws UserNotFoundException, SystemException {
        serverObjectService.pay(no);
        return new Result(true,"缴费成功");
    }

    @PostMapping("/reset")
    public Result reset(String no) throws UserNotFoundException, SystemException {
        serverObjectService.reset(no);
        return new Result(true,"重置密码成功");
    }

}
