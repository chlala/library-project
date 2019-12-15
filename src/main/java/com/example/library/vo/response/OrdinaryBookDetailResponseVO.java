package com.example.library.vo.response;

import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.bookitem.OrdinaryBookItem;
import com.example.library.vo.base.BaseResponseVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/8 19:30
 */
@Data
public class OrdinaryBookDetailResponseVO extends BaseResponseVO {

    private String bookName;

    private String author;

    private Integer count;

    private Integer inCount;

    private String press;

    private Date publishTime;

    private String callNumber;

    private String description;

    private Double price;

    private List<OrdinaryBookItem> bookItemList;

    public static OrdinaryBookDetailResponseVO getEntity(OrdinaryBook book){
        if(Objects.isNull(book)){
            return null;
        }
        OrdinaryBookDetailResponseVO vo=new OrdinaryBookDetailResponseVO();
        BeanUtils.copyProperties(book,vo);
        return vo;
    }
}
