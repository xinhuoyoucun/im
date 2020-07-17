package com.yuan.service;

import com.yuan.domain.User;

/**
 * @author by yuanlai
 * @Date 2020/7/15 2:58 下午
 * @Description: TODO
 * @Version 1.0
 */
public interface AccountService {
    User login(String account,String password);

    User Register(String account,String password,String nickname);
}
