package com.zack.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Aopp_7001_Main {
    public static void main(String[] args)
    {

        SpringApplication.run(Aopp_7001_Main.class,args);
    }
}
