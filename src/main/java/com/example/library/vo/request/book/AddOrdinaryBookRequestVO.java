package com.example.library.vo.request.book;

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
public class AddOrdinaryBookRequestVO extends BaseRequestVO {

    @NotEmpty
    @NotNull
    private String bookName;

    @NotEmpty
    @NotNull
    private String author;

    @NotEmpty
    @NotNull
    private String press;

    @Past(message = "出版日期错误")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publishTime;

    @NotEmpty
    @NotNull
    private String description;

    @NotEmpty
    @NotNull
    @Min(value = 1,message = "请填写正确的价格")
    private Double price;

    @NotEmpty
    @NotNull
    private String callNumber;

    @NotEmpty
    @NotNull
    @Range(min = 1,max = 15,message = "书籍数量不对")
    private Integer count;

    public static OrdinaryBook getEntity(AddOrdinaryBookRequestVO vo){
        if(Objects.isNull(vo)){
            return null;
        }
        OrdinaryBook ordinaryBook=new OrdinaryBook();
        BeanUtils.copyProperties(vo,ordinaryBook);
        ordinaryBook.setInCount(ordinaryBook.getCount());
        return ordinaryBook;
    }

}
