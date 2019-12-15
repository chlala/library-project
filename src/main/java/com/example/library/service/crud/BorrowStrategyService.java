package com.example.library.service.crud;


import com.example.library.entity.strategy.BorrowStrategy;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 15:20
 */
public interface BorrowStrategyService {

    int updateBorrowStrategy(BorrowStrategy borrowStrategy);

    int deleteBorrowStrategyById(Integer id);

    int insertBorrowStrategy(BorrowStrategy borrowStrategy);

    BorrowStrategy selectBorrowStrategyById(Integer id);

    List<BorrowStrategy> selectAllBorrowStrategy();


}
