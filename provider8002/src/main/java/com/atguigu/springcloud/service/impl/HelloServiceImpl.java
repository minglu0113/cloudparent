package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String say(String name) {
        return name;
    }
}
