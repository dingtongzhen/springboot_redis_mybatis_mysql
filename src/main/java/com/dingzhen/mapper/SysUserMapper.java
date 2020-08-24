package com.dingzhen.mapper;

import com.dingzhen.redisUtils.RedisQueryAnnotation;
import com.dingzhen.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface SysUserMapper {

    int insert(ArrayList<SysUser> sysUsers);
    @RedisQueryAnnotation(redisKey = "sys_user",itemName = "sys_user_all")
    ArrayList<SysUser> getAllUsersByIdNotNull();
}
