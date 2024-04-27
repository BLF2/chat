package com.blf2.chat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blf2.chat.common.ResultBase;
import com.blf2.chat.entity.UserInfo;

public interface UserInfoService extends IService<UserInfo> {

    ResultBase<String> login(String username,String password);

    ResultBase<String> logout(String token);
}
