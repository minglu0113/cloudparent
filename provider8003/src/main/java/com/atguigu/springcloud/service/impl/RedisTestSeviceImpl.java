package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.RedisTestService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class RedisTestSeviceImpl  implements RedisTestService {

    @Override
    @Cacheable(value="users", key="#id")
    public int getInt(Integer id) {
        System.out.println(12345);
        return 0;
    }
}
