package com.yuan.mapper;

import com.yuan.domain.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface UserMapper extends MyMapper<User> {
}