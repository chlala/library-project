package com.example.library.entity.book;

import com.example.library.entity.book.bookitem.MagazineItem;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 14:17
 */
@Data
public class Magazine extends Book {

    private Date date;

    private Integer periodNum;

    private String issn;

    private List<MagazineItem> items;
}
