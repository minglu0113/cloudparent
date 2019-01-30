package com.atguigu.springcloud.service.serviceImpl;

import com.atguigu.springcloud.service.HelloService;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
        return name+":HelloWorld";
    }
}
