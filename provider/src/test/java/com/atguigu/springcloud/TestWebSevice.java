package com.atguigu.springcloud;

import com.atguigu.springcloud.service.HelloService;
import com.atguigu.springcloud.service.serviceImpl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.ws.Endpoint;

public class TestWebSevice {
    @Test
    public void testService(){
        HelloService helloService = new HelloServiceImpl();
        String address = "http://192.168.3.77/ws/hello";
        Endpoint.publish(address,helloService);
    }
    public static void main(String[] args)
    {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress("http://192.168.3.77/ws/hello");
        factoryBean.setServiceClass(HelloService.class);
        factoryBean.setServiceBean(new HelloServiceImpl());
        factoryBean.create();
        System.out.println("端口8000");
    }
}
