package com.example.library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

/**
 * @author Chl
 * @version 1.0
 * @date 2019/12/13 11:03
 */
@Component
public class MailSendUtil {

    @Autowired
    private MailSender mailSender;

    public void sendMail(String email,String name,String bookName){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("图书馆预约提醒");
        String text=name+",您所预约的"+bookName+"已在馆，请及时借阅";
        message.setText(text);
        message.setTo(email);
        message.setFrom("1032621325@qq.com");
        mailSender.send(message);
    }

}
