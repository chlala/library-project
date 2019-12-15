package com.example.library.vo.response;

import com.example.library.entity.user.serve.ServeObject;
import com.example.library.vo.base.BaseResponseVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 14:47
 */
@Data
public class LoginResponseVO extends BaseResponseVO {

    private String no;

    private String name;

    public static LoginResponseVO getEntity(ServeObject serveObject){
        if(Objects.isNull(serveObject)){
            return null;
        }
        LoginResponseVO vo=new LoginResponseVO();
        BeanUtils.copyProperties(serveObject,vo);
        return vo;
    }
}
