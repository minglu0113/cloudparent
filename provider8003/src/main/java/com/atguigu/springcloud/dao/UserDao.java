package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.bean.User;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface UserDao {

    User getUser(String name);
}
