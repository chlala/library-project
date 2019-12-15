package com.example.library.mapper.user;

import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/5 16:07
 */
@Mapper
public interface MasterMapper extends tk.mybatis.mapper.common.Mapper<Master> {
}
