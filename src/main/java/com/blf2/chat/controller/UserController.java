package com.blf2.chat.controller;

import com.blf2.chat.common.CommonConstants;
import com.blf2.chat.common.ResultBase;
import com.blf2.chat.dto.LoginReq;
import com.blf2.chat.service.UserInfoService;
import com.blf2.chat.util.HttpRequestUtil;
import jakarta.annotation.Resource;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public ResultBase<String> login(@RequestBody LoginReq loginReq){
        //校验数据
        if(!StringUtils.hasText(loginReq.getUsername()) || !StringUtils.hasText(loginReq.getUsername())) {
            return ResultBase.fail(CommonConstants.RESULT_MSG_LOGIN_FAIL);
        }
        return userInfoService.login(loginReq.getUsername(),loginReq.getPassword());
    }

    @GetMapping("/logout")
    public ResultBase<String> logout(){

        String currentToken = HttpRequestUtil.getRequestToken();
        if(!StringUtils.hasText(currentToken)){
            return ResultBase.fail(CommonConstants.NEED_LOGIN);
        }
        return userInfoService.logout(currentToken);
    }
}
