package com.lppz.web.controller;

import com.lppz.entity.dto.User;
import com.lppz.service.LoginService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private LoginService loginService;
    @PostMapping(value = "/user/login")
    public String login (@RequestParam("username")String username,
                         @RequestParam("password")String password,
                         Map<String,Object> map,
                         HttpSession session){
        if (!StringUtils.isEmpty(username)&&"123456".equals(password)){
            session.setAttribute("loginUser",username);
            logger.info("这是我的日志框架");
            HashMap<String, Object> params = new HashMap<>();
            User user = loginService.findUserByUsernameAndPassword(params);
            logger.info("手机号码为:{}",user.getPhone());
            //登录成功防止重复提交 重定向页面
            return "redirect:/main.html";
        }else {
            map.put("msg","登录失败!");
            return "login";
        }
    }
}
