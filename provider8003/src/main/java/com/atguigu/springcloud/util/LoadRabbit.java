package com.atguigu.springcloud.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class  LoadRabbit {
    @Bean
    public Properties loadRabbitProperties(){
        Properties properties = new Properties();
        InputStream is = this.getClass().getResourceAsStream("/rabbitmq.properties");

        try {
            properties.load(is);
        }catch (IOException e){
            System.out.println("加载rabbitmq文件出错");
        }
        return properties;
    }
}
