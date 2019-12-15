package com.example.library.service.crud;

import com.example.library.entity.user.BookAdmin;
import com.example.library.entity.user.SystemAdmin;
import com.example.library.exception.UserNotFoundException;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/11 21:23
 */
public interface AdminService {

    BookAdmin selectBookAdminByNameAndPassword(String name,String password) throws UserNotFoundException;

    SystemAdmin selectSystemAdminByNameAndPassword(String name, String password) throws UserNotFoundException;

}
