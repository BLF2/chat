package com.blf2.chat.config;

import com.blf2.chat.common.CommonConstants;
import com.blf2.chat.util.CacheUtil;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;


public class TokenFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    private CacheUtil cacheUtil;

    public TokenFilter(CacheUtil cacheUtil) {
        this.cacheUtil = cacheUtil;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String url = httpServletRequest.getRequestURL().toString();
        String requestMethod = httpServletRequest.getMethod();
        if(url.contains(CommonConstants.HEALTH)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if(url.endsWith(".html") || url.endsWith(".css") || url.endsWith(".js")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        logger.info("接收到请求信息 url={} method={}", url, requestMethod);
        //判断是否是登录 是的话直接放过
        if(url.contains(CommonConstants.LOGIN_URL) && CommonConstants.LOGIN_METHOD.equals(requestMethod)){
            logger.info("当前请求是登录请求 通过");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //获取header中的token信息
        logger.info("开始验证token");
        String token = httpServletRequest.getHeader(CommonConstants.TOKEN_HEADER);
        logger.info("获取到的token {}", StringUtils.hasText(token) ? token : "");
        if (!StringUtils.hasText(token)) {
            //没有token 直接跳转回登录页面
            logger.info("token为空 跳转到登录页");
            toLoginHtml(httpServletResponse);
            return;
        }
        //有token 验证下token是否还在
        String username = cacheUtil.getValue(token);
        if (!StringUtils.hasText(username)) {
            //不存在 直接跳转登录页
            logger.info("token未在缓存内 跳转登录页");
            toLoginHtml(httpServletResponse);
            return;
        }

        logger.info("token验证通过");
        //全部验证通过 继续往下走
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private void toLoginHtml(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_FOUND);
        httpServletResponse.sendRedirect(CommonConstants.TO_LOGIN_HTML_URL);
        httpServletResponse.flushBuffer();
    }
}
