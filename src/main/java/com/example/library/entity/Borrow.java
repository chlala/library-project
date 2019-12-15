package com.example.library.entity;

import com.example.library.entity.book.Book;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 17:16
 */
@Data
public class Borrow implements Serializable {

    private static final long serialVersionUID = -4644822939040601149L;

    private Integer biId;

    private Integer type;

    private String serNo;

    private Integer validate;

    private Date borrowDate;

    private Date returnDate;

    private Date shouldReturnTime;

    private Book book;

}
