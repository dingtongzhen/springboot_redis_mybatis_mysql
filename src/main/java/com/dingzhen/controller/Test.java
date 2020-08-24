package com.dingzhen.controller;

import com.dingzhen.entity.SysUser;
import com.dingzhen.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
@Slf4j
@RestController
@RequestMapping("/sysUser")
public class Test {
    @Resource
    SysUserMapper sysUserMapper;

    @PostMapping("/save")
    public void save() {
        ArrayList<SysUser> sysUsers = new ArrayList<>();
        for (int i = 190001; i < 230000; i++) {
            SysUser sysUser = new SysUser();
            sysUser.setUserId(String.valueOf(i));
            sysUser.setUserCode("code" + i);
            sysUser.setUserName("Jack" + i);
            sysUsers.add(sysUser);
        }
        int in = sysUserMapper.insert(sysUsers);
        System.err.println("插入：" + in + "条");
    }

    @PostMapping("/getAllUsersByIdNotNull")
    public ArrayList<SysUser> getAllUsers() {
        long begintime = System.currentTimeMillis();
        ArrayList<SysUser> list = sysUserMapper.getAllUsersByIdNotNull();
        long endtime = System.currentTimeMillis();
        long costTime = (endtime - begintime);
       log.info("getAllUsersByIdNotNull耗时：===="+costTime);
        System.err.println("getAllUsersByIdNotNull耗时：====" + costTime);
        return list;
    }

}
