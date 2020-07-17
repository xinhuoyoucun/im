package com.yuan.consumer.service.impl;

import com.yuan.domain.User;
import com.yuan.mapper.UserMapper;
import com.yuan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author by yuanlai
 * @Date 2020/7/15 3:00 下午
 * @Description: TODO
 * @Version 1.0
 */

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        return userMapper.select(user).get(0);
    }

    @Override
    public User Register(String account, String password, String nickname) {
        return null;
    }
}
