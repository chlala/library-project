package com.example.library.entity.strategy;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 15:12
 */
@Data
public class BorrowStrategy {

    private Integer bookType;

    private Integer userType;

    private Integer maxBorrowNum;

    private Integer maxBorrowDay;
}
