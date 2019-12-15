package com.example.library.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class JWTUtils {

    @Value("chli")
    private String key;

    @Value("#{1000*60*30}")
    private Integer ttl;

    public String createJWT(String id,String subject,String role){
        long nowMills=System.currentTimeMillis();
        Date date=new Date();
        JwtBuilder jwtBuilder= Jwts.builder()
                .setId(id)
                .setSubject(subject)
                .setIssuedAt(date)
                .claim("role",role)
                .signWith(SignatureAlgorithm.HS256,key);
        if(ttl>0){
            jwtBuilder.setExpiration(new Date(nowMills+ttl));
        }
        return jwtBuilder.compact();
    }

    public Claims parseJWT(String jwtStr){
        Claims claims= Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwtStr)
                .getBody();
        return claims;
    }
}
