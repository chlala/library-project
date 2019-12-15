package com.example.library.entity.book;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/13 10:58
 */
@Data
@Table(name = "order_item")
public class OrderItem {

    @Id
    private Integer id;

    private String no;

    private Integer biId;

    private Integer bookType;

    private Integer validate;
}
