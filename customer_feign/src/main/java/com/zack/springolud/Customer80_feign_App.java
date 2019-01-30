package com.zack.springolud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Customer80_feign_App {
    public static void main(String[] args)
    {
        SpringApplication.run(Customer80_feign_App.class,args);
    }

}
