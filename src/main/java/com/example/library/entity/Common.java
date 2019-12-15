package com.example.library.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 15:57
 */
@Data
public class Common {

    public static final Integer TEACHER_TYPE=1;

    public static final Integer JUNIOR_TYPE=2;

    public static final Integer BACHELOR_TYPE=3;

    public static final Integer MASTER_TYPE=4;

    public static final Integer DOCTOR_TYPE=5;

    public static final Integer ORDINARY_BOOK_TYPE=1;

    public static final Integer MAGAZINE_TYPE=2;

    public static final Integer PAPER_TYPE=3;

    public static final Integer VALIDATE=1;

    public static final Integer INVALIDATE=2;

    public static final Integer IN_LIBRARY=1;

    public static final Integer BORROW_OUT=2;

    public static final Integer NAN_HU=1;

    public static final Integer XI_YUAN=2;

    public static final Integer DONG_YUAN=3;

}
