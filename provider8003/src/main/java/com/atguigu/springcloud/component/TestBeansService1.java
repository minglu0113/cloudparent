package com.atguigu.springcloud.component;

import com.atguigu.springcloud.service.TestBeansService;
import org.springframework.stereotype.Component;

@Component
public class TestBeansService1 implements TestBeansService {
    @Override
    public void say() {
        System.out.println("1111");
    }
}
