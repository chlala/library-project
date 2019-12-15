package com.example.library.vo.response;

import com.example.library.entity.book.Book;
import com.example.library.entity.book.Magazine;
import com.example.library.entity.book.OrdinaryBook;
import com.example.library.entity.book.Paper;
import com.example.library.vo.base.BaseResponseVO;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/8 14:29
 */
@Data
public class SearchBookResponseVO extends BaseResponseVO {

    private Integer id;

    private String bookName;

    private String author;

    private Integer count;

    private Integer inCount;

    public static PageInfo<SearchBookResponseVO> getOrdinaryBookEntity(PageInfo<OrdinaryBook> bookPageInfo){
        if(Objects.isNull(bookPageInfo.getList())){
            return null;
        }
        List<OrdinaryBook> bookList=bookPageInfo.getList();
        List<SearchBookResponseVO> voList=new ArrayList<>();
        PageInfo<SearchBookResponseVO> voPageInfo=new PageInfo<>();
        BeanUtils.copyProperties(bookPageInfo,voPageInfo);
        for (OrdinaryBook book:bookList){
            SearchBookResponseVO vo=new SearchBookResponseVO();
            BeanUtils.copyProperties(book,vo);
            voList.add(vo);
        }
        voPageInfo.setList(voList);
        return voPageInfo;
    }

    public static PageInfo<SearchBookResponseVO> getMagazineEntity(PageInfo<Magazine> bookPageInfo){
        if(Objects.isNull(bookPageInfo.getList())){
            return null;
        }
        List<Magazine> bookList=bookPageInfo.getList();
        List<SearchBookResponseVO> voList=new ArrayList<>();
        PageInfo<SearchBookResponseVO> voPageInfo=new PageInfo<>();
        BeanUtils.copyProperties(bookPageInfo,voPageInfo);
        for (Magazine book:bookList){
            SearchBookResponseVO vo=new SearchBookResponseVO();
            BeanUtils.copyProperties(book,vo);
            voList.add(vo);
        }
        voPageInfo.setList(voList);
        return voPageInfo;
    }

    public static PageInfo<SearchBookResponseVO> getPaperEntity(PageInfo<Paper> bookPageInfo){
        if(Objects.isNull(bookPageInfo.getList())){
            return null;
        }
        List<Paper> bookList=bookPageInfo.getList();
        List<SearchBookResponseVO> voList=new ArrayList<>();
        PageInfo<SearchBookResponseVO> voPageInfo=new PageInfo<>();
        BeanUtils.copyProperties(bookPageInfo,voPageInfo);
        for (Paper book:bookList){
            SearchBookResponseVO vo=new SearchBookResponseVO();
            BeanUtils.copyProperties(book,vo);
            voList.add(vo);
        }
        voPageInfo.setList(voList);
        return voPageInfo;
    }

}
