package com.atguigu.springcloud;

import com.atguigu.springcloud.service.HelloService;
import com.atguigu.springcloud.service.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args)
    {
        JaxWsServerFactoryBean factoryBean = new JaxWsServerFactoryBean();
        factoryBean.setAddress("http://192.168.3.77/ws");
        HelloService helloService = new HelloServiceImpl();
        factoryBean.setServiceBean(helloService);
        factoryBean.setServiceClass(HelloService.class);
        factoryBean.create();
    }
}
