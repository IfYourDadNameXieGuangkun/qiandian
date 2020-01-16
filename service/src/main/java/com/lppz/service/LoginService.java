package com.lppz.service;

import com.lppz.entity.dto.User;

import java.util.Map;

public interface LoginService {
    public User findUserByUsernameAndPassword(Map<String,Object> params);
}
