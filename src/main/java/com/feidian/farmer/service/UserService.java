package com.feidian.farmer.service;

import com.feidian.farmer.dao.entity.User;
import com.feidian.farmer.dao.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {

    @Resource
    UserMapper userMapper;

    public User getOne(String username) {
        return userMapper.selectOneByUsername(username);
    }

}
