package com.example.library.mapper.book;

import com.example.library.entity.book.Magazine;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 16:23
 */
@Mapper
public interface MagazineMapper extends tk.mybatis.mapper.common.Mapper<Magazine> {

    @Insert({"insert into magazine(book_name,author,date,period_num,issn,count,in_count) values( " +
            "#{bookName},#{author},#{date},#{periodNum},#{issn},#{count},#{inCount})"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(Magazine magazine);

}
