package com.example.library.config;

import com.example.library.interceptor.BookAdminInterceptor;
import com.example.library.interceptor.JWTInterceptor;
import com.example.library.interceptor.SystemAdminInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {


    @Autowired
    private JWTInterceptor jwtInterceptor;

    @Autowired
    private BookAdminInterceptor bookAdminInterceptor;

    @Autowired
    private SystemAdminInterceptor systemAdminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/user/**")
                .addPathPatterns("/searchBook/**")
                .excludePathPatterns("/user/register")
                .excludePathPatterns("/**/login");

        registry.addInterceptor(bookAdminInterceptor)
                .addPathPatterns("/bookAdmin/**")
                .excludePathPatterns("/**/login");

        registry.addInterceptor(systemAdminInterceptor)
                .addPathPatterns("/systemAdmin/**")
                .excludePathPatterns("/**/login");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
