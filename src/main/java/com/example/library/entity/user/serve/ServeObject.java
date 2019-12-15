package com.example.library.entity.user.serve;

import com.example.library.entity.Borrow;
import com.example.library.entity.strategy.BorrowStrategy;
import com.example.library.entity.user.User;
import lombok.Data;

import javax.persistence.Id;
import java.util.List;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/6 14:05
 */
@Data
public class ServeObject extends User {

    @Id
    private String no;

    private Integer borrowNum;

    private Double oweMoney;

    private String email;

    private BorrowStrategy borrowStrategy;

    private List<Borrow> borrowList;
}
