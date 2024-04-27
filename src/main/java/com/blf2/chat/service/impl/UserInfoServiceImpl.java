package com.blf2.chat.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blf2.chat.common.CommonConstants;
import com.blf2.chat.common.ResultBase;
import com.blf2.chat.dao.UserInfoDao;
import com.blf2.chat.entity.UserInfo;
import com.blf2.chat.service.UserInfoService;
import com.blf2.chat.util.CacheUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, UserInfo> implements UserInfoService {

    @Resource
    private CacheUtil cacheUtil;

    @Override
    public ResultBase<String> login(String username, String password) {

        //查询数据库中的数据
        UserInfo userInfo = this.baseMapper.getByUsername(username);
        if(userInfo == null){
            //数据库中不存在数据 直接登录失败
            return ResultBase.fail(CommonConstants.RESULT_MSG_LOGIN_FAIL);
        }
        //查到数据了 比对password
        if(password.equals(userInfo.getPassword())){
            String token = UUID.randomUUID().toString(true);
            cacheUtil.setCache(token,username);
            return ResultBase.success(token);
        }
        return ResultBase.fail(CommonConstants.RESULT_MSG_LOGIN_FAIL);
    }

    public ResultBase<String> logout(String token){
        cacheUtil.removeKey(token);
        return ResultBase.success();
    }
}
