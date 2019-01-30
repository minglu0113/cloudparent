package com.zack.springolud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class CustomerController {
    @Autowired
    RestTemplate restTemplate;
    private static final String REST_URK_PREFIX ="http://SPRINGCLOUD";//SPRINGCLOUD
    @ResponseBody
    @RequestMapping(value = "/test")
    public String test(){
        ResponseEntity<String> responseEntity = restTemplate.exchange(REST_URK_PREFIX+"/test",HttpMethod.GET,null,String.class);
        System.out.println(responseEntity.getBody());
        return "success122";
    }

    // 测试@EnableDiscoveryClient,消费端可以调用服务发现
    @RequestMapping(value = "/consumer/dept/discovery")
    @ResponseBody
    public Object discovery()
    {
        return restTemplate.getForObject("http://localhost:8001" + "/dept/discovery", Object.class);
    }
}
