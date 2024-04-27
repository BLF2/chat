package com.blf2.chat.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blf2.chat.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserInfoDao extends BaseMapper<UserInfo> {

    @Select("select * from user_info where username = #{username}")
    UserInfo getByUsername(String username);
}
