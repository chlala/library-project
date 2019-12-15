package com.example.library.entity.book;

import com.example.library.entity.strategy.FineStrategy;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 14:16
 */
@Data
public class Book implements Serializable {

    private static final long serialVersionUID = 1323714808651014153L;

    @Id
    private Integer id;

    private String bookName;

    private String author;

    private Integer count;

    private Integer inCount;

    private FineStrategy fineStrategy;

}
