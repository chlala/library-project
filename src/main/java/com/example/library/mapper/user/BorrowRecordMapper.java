package com.example.library.mapper.user;

import com.example.library.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/11 16:22
 */
@Mapper
public interface BorrowRecordMapper extends tk.mybatis.mapper.common.Mapper<Borrow> {

    List<Borrow> selectOrdinaryBorrowRecord(String no);

    List<Borrow> selectMagazineBorrowRecord(String no);

    List<Borrow> selectPaperBorrowRecord(String no);
}
