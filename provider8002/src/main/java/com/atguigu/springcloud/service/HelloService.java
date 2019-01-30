package com.atguigu.springcloud.service;

import javax.jws.WebService;

@WebService
public interface HelloService {
    public String say(String name);
}
