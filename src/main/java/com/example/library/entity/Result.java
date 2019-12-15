package com.example.library.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 10:11
 */
@Data
public class Result {

    private Boolean flag;

    private String message;

    private Object data;

    private Map map;

    public Result(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Result(Boolean flag, String message, Object data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

    public Result(Boolean flag, String message, Object data, Map map) {
        this.flag = flag;
        this.message = message;
        this.data = data;
        this.map = map;
    }
}
