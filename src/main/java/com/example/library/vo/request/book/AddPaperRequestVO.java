package com.example.library.vo.request.book;

import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.Paper;
import com.example.library.vo.base.BaseRequestVO;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.Objects;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 17:17
 */
@Data
public class AddPaperRequestVO extends BaseRequestVO {

    @NotEmpty
    @NotNull
    private String bookName;

    @NotEmpty
    @NotNull
    private String author;

    @Past(message = "日期错误")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @NotEmpty
    @NotNull
    private String kindNum;

    @NotEmpty
    @NotNull
    @Range(min = 1,max = 15,message = "书籍数量不对")
    private Integer count;

    public static Paper getEntity(AddPaperRequestVO vo){
        if(Objects.isNull(vo)){
            return null;
        }
        Paper paper=new Paper();
        BeanUtils.copyProperties(vo,paper);
        paper.setInCount(paper.getCount());
        return paper;
    }

}
