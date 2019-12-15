package com.example.library.entity.user;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/5 16:05
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -2349250232757188733L;

    private String name;

    private String password;
}
