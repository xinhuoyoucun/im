package com.yuan.chat.controller;

import com.yuan.commons.controller.AbstractBaseController;
import com.yuan.commons.dto.Response;
import com.yuan.domain.User;
import com.yuan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author by yuanlai
 * @Date 2020/7/15 3:23 下午
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/api/account")
public class AccountController extends AbstractBaseController {
    @Autowired
    private AccountService accountService;

    @CrossOrigin
    @PostMapping("/login")
    public Response login(@RequestBody User user){
        User res=accountService.login(user.getAccount(),user.getPassword());
        return success(res);
    }

}
