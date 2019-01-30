package com.atguigu.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan("com.atguigu.springcloud.dao")
@EnableRabbit
@EnableWebSocket
@EnableCaching
//@EnableSwagger2
public class DeptProvider8001_Config_App
{
	public static void main(String[] args)
	{
		SpringApplication.run(DeptProvider8001_Config_App.class, args);
	}
}
