package com.example.library.entity.book.bookitem;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 14:36
 */
@Data
public class BookItem implements Serializable {

    private static final long serialVersionUID = 604445161107123723L;

    @Id
    private Integer id;

    private Integer bookId;

    private Date shouldReturnTime;

    private Integer state;

    private Integer location;

}
