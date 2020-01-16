package com.lppz.service.impl;

import com.lppz.dao.mapper.UserMapper;
import com.lppz.entity.dto.User;
import com.lppz.service.LoginService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    public User findUserByUsernameAndPassword(Map<String,Object> params){
        User user = new User();
        User user1 = userMapper.selectByPrimaryKey(1);
        System.out.println(user1.getUserName());
        user.setPhone("13135699022");
        return user;
    }
}
