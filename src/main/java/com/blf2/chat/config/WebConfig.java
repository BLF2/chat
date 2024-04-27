package com.blf2.chat.config;

import com.blf2.chat.util.CacheUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Resource
    private CacheUtil cacheUtil;

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>(new TokenFilter(cacheUtil));
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
