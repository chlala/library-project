package com.example.library.controller;

import com.example.library.entity.Result;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 10:44
 */
@ResponseBody
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public Result handleException(Exception e){
        if(e instanceof MethodArgumentNotValidException){
            return new Result(false,"校园卡号 姓名 密码不能为空");
        }
        return new Result(false,e.getMessage());
    }

}
