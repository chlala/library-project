package com.example.library.mapper.book;

import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.Paper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 16:23
 */
@Mapper
public interface PaperMapper extends tk.mybatis.mapper.common.Mapper<Paper> {

    @Insert({"insert into paper(book_name,author,date,kind_num,count,in_count) values( " +
            "#{bookName},#{author},#{date},#{kindNum},#{count},#{inCount})"})
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int insert(Paper paper);
}
