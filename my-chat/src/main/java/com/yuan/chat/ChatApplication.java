package com.yuan.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author by yuanlai
 * @Date 2020/7/15 3:21 下午
 * @Description: TODO
 * @Version 1.0
 */

@SpringBootApplication(scanBasePackages = "com.yuan")
@MapperScan(basePackages = "com.yuan.mapper")
public class ChatApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class,args);
    }
}
