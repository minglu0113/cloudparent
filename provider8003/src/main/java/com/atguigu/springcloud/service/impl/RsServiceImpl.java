package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.service.RsService;

public class RsServiceImpl implements RsService {
    @Override
    public void saveUser(User user) {
        System.out.println(user);
    }
}
