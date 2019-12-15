package com.example.library.mapper.user;

import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.entity.book.bookitem.PaperItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/11 15:59
 */
@Mapper
public interface ReturnMapper {

    int onlyReturnOrdinaryBook(OrdinaryBookItem item);

    int onlyReturnMagazine(MagazineItem item);

    int onlyReturnPaper(PaperItem item);
}
