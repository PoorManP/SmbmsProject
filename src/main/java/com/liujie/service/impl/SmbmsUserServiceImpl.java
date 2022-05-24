package com.liujie.service.impl;

import com.liujie.dao.SmbmsUserMapper;
import com.liujie.exception.LoginExcetion;
import com.liujie.model.SmbmsUser;
import com.liujie.service.SmbmsUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SmbmsUserServiceImpl implements SmbmsUserService {

    @Resource
    SmbmsUserMapper userMapper;
    @Override
    public SmbmsUser login(SmbmsUser user) throws LoginExcetion {
        SmbmsUser user1 = userMapper.login(user);
        System.out.println(user1);
        if(user1==null){
            throw new LoginExcetion("账号或密码错误");
        }

        return user1;

    }
}
