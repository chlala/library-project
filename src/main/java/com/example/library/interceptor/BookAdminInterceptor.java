package com.example.library.interceptor;

import com.example.library.exception.AuthorizeException;
import com.example.library.util.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class BookAdminInterceptor implements HandlerInterceptor {

    Logger logger= LoggerFactory.getLogger(BookAdminInterceptor.class);

    @Autowired
    private JWTUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug(request.getRequestURI());
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Headers","*");
        response.setHeader("Access-Control-Allow-Methods","*");

        try {
            String token=request.getHeader("authorize");
            if(token!=null&&!token.equals("")){
                String  role = (String) jwtUtils.parseJWT(token).get("role");
                if("bookAdmin".equals(role)){
                    return true;
                }
            }
        } catch (Exception e) {
            throw new AuthorizeException("权限不足");
        }
        return false;
    }
}
