package com.example.library.entity.strategy;

import lombok.Data;

import javax.persistence.Id;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/11 15:39
 */
@Data
public class FineStrategy {

    @Id
    private Integer id;

    private Double money;
}
