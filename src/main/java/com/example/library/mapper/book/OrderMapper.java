package com.example.library.mapper.book;

import com.example.library.entity.book.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/13 11:59
 */
@Mapper
public interface OrderMapper extends tk.mybatis.mapper.common.Mapper<OrderItem> {
}
