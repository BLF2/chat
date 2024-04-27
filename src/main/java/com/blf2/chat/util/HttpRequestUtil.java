package com.blf2.chat.util;

import com.blf2.chat.common.CommonConstants;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class HttpRequestUtil {

    public static String getRequestToken(){
        HttpServletRequest currentHttpRequest = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest();
        if(currentHttpRequest != null){
            return currentHttpRequest.getHeader(CommonConstants.TOKEN_HEADER);
        }
        return null;
    }
}
