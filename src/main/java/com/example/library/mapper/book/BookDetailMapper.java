package com.example.library.mapper.book;

import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.Paper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/8 20:22
 */
@Mapper
public interface BookDetailMapper {

    OrdinaryBook selectOrdinaryBookDetailByBookId(Integer id);

    Magazine selectMagazineDetailByBookId(Integer id);

    Paper selectPaperDetailByBookId(Integer id);


}
