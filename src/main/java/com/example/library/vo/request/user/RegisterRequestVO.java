package com.example.library.vo.request.user;

import com.example.library.entity.user.serve.ServeObject;
import com.example.library.entity.user.serve.Teacher;
import com.example.library.entity.user.serve.student.Bachelor;
import com.example.library.entity.user.serve.student.Doctor;
import com.example.library.entity.user.serve.student.Junior;
import com.example.library.entity.user.serve.student.Master;
import com.example.library.vo.base.BaseRequestVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/7 11:17
 */
@Data
public class RegisterRequestVO  extends BaseRequestVO {

    @NotNull
    @NotEmpty
    private String no;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String password;

    public static ServeObject getEntity(RegisterRequestVO vo,String role){
        if(Objects.isNull(vo)){
            return null;
        }
        if(role.equals("teacher")){
            Teacher teacher=new Teacher();
            BeanUtils.copyProperties(vo,teacher);
            teacher.setBorrowNum(0);
            teacher.setOweMoney(0.0);
            return teacher;
        }
        if(role.equals("junior")){
            Junior junior=new Junior();
            BeanUtils.copyProperties(vo,junior);
            junior.setBorrowNum(0);
            junior.setOweMoney(0.0);
            return junior;
        }
        if(role.equals("bachelor")){
            Bachelor bachelor=new Bachelor();
            BeanUtils.copyProperties(vo,bachelor);
            bachelor.setBorrowNum(0);
            bachelor.setOweMoney(0.0);
            return bachelor;
        }
        if (role.equals("master")) {
            Master master=new Master();
            BeanUtils.copyProperties(vo,master);
            master.setBorrowNum(0);
            master.setOweMoney(0.0);
            return master;
        }
        if(role.equals("doctor")){
            Doctor doctor=new Doctor();
            BeanUtils.copyProperties(vo,doctor);
            doctor.setBorrowNum(0);
            doctor.setOweMoney(0.0);
            return doctor;
        }
        return null;
    }
}
