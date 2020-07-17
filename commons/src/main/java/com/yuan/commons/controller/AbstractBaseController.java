package com.yuan.commons.controller;

import com.yuan.commons.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author by laiyuan
 * @Date 2019/9/19 14:38
 * @Description: 通用的控制器
 * @Version 1.0
 */
public abstract class AbstractBaseController {

    @Resource
    protected HttpServletRequest request;
    @Resource
    protected HttpServletResponse response;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @ModelAttribute
    public void initReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    /**
     * 请求成功
     * @param attribute
     * @return
     */
    protected Response success(Object attribute) {
        return new Response().success(attribute);
    }



    /**
     * 请求失败
     * @param message
     * @return
     */
    protected Response error(String message) {
        return new Response().failure(message);
    }
}