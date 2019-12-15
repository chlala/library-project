package com.example.library.vo.request.book;

import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import com.example.library.vo.base.BaseRequestVO;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
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
public class AddMagazineRequestVO extends BaseRequestVO {

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
    private String issn;

    @NotEmpty
    @NotNull
    private Integer periodNum;

    @NotEmpty
    @NotNull
    @Range(min = 1,max = 15,message = "书籍数量不对")
    private Integer count;

    public static Magazine getEntity(AddMagazineRequestVO vo){
        if(Objects.isNull(vo)){
            return null;
        }
        Magazine magazine=new Magazine();
        BeanUtils.copyProperties(vo,magazine);
        magazine.setInCount(magazine.getCount());
        return magazine;
    }

}
