package com.example.library.service.crud.impl;

import com.example.library.entity.strategy.BorrowStrategy;
import com.example.library.mapper.startegy.BorrowStrategyMapper;
import com.example.library.service.crud.BorrowStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 15:27
 */
@Service
public class BorrowStrategyServiceImpl implements BorrowStrategyService {

    @Autowired
    private BorrowStrategyMapper borrowStrategyMapper;

    @Override
    public int updateBorrowStrategy(BorrowStrategy borrowStrategy) {
        return borrowStrategyMapper.updateByPrimaryKeySelective(borrowStrategy);
    }

    @Override
    public int deleteBorrowStrategyById(Integer id) {
        return borrowStrategyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertBorrowStrategy(BorrowStrategy borrowStrategy) {
        return borrowStrategyMapper.insert(borrowStrategy);
    }

    @Override
    public BorrowStrategy selectBorrowStrategyById(Integer id) {
        return borrowStrategyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BorrowStrategy> selectAllBorrowStrategy() {
        return borrowStrategyMapper.selectAll();
    }
}
