package com.example.library.entity.book;

import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 14:17
 */
@Data
public class OrdinaryBook extends Book {

    private String press;

    private Date publishTime;

    private String callNumber;

    private String description;

    private Double price;

    private List<OrdinaryBookItem> items;
}
