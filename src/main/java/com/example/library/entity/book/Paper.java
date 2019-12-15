package com.example.library.entity.book;

import com.example.library.entity.book.bookitem.PaperItem;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 14:17
 */
@Data
public class Paper extends Book {

    private Date date;

    private String kindNum;

    private List<PaperItem> items;
}
