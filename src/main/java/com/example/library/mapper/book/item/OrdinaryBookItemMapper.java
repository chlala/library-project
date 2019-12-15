package com.example.library.mapper.book.item;

import com.example.library.entity.book.bookitem.MagazineItem;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 21:40
 */
@Mapper
public interface OrdinaryBookItemMapper extends tk.mybatis.mapper.common.Mapper<OrdinaryBookItem> {
    int insertBookItemBatch(List<OrdinaryBookItem> bookItems);
}
