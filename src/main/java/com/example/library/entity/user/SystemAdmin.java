package com.example.library.entity.user;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/5 16:05
 */
@Data
@Table(name = "system_admin")
public class SystemAdmin extends User {

    @Id
    private Integer id;

}
