package com.example.library.mapper.book;

import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 16:23
 */
@Mapper
public interface OrdinaryBookMapper extends tk.mybatis.mapper.common.Mapper<OrdinaryBook> {

    @Insert({"insert into ordinary_book(book_name,author,call_number,price,press,publish_time,description,count,in_count) values (" +
            "#{bookName},#{author},#{callNumber},#{price},#{press},#{publishTime},#{description},#{count},#{inCount})"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(OrdinaryBook ordinaryBook);
}
