package com.yuan.mapper;

import com.yuan.domain.Message;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface MessageMapper extends MyMapper<Message> {
}