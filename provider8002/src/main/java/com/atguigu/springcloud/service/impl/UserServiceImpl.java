package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.dao.UserDao;
import com.atguigu.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public User getUser(String name) {
        return userDao.getUser(name);
    }
}
