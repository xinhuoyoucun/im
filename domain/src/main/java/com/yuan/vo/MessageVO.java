package com.yuan.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.yuan.domain.User;
import lombok.Data;

/**
 * @author by yuanlai
 * @Date 2020/7/15 10:06 上午
 * @Description: TODO
 * @Version 1.0
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageVO {
    private String id;

    private String type;

    private Integer time;

    private Integer fromuserid;

    private Integer touserid;

    private String flow;

    private String msgtype;

    private String content;

    private User user;


    public User getUser() {
        user.setAccount(null);
        user.setPassword(null);
        return user;
    }
}
