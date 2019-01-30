package com.atguigu.springcloud;

import com.atguigu.springcloud.component.NameInterface;
import com.atguigu.springcloud.exception.TooLongExceptio;
import com.atguigu.springcloud.service.HelloService;
import com.atguigu.springcloud.service.impl.HelloServiceImpl;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import java.io.IOException;

public class test {

    //这个也是
    public void test() throws TooLongExceptio{
        throw new TooLongExceptio();
    }
    //不起作用,因为只能用在controller里面
    @NameInterface(value = "张三")
    public void testInterface(){
        System.out.println("方法体");
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
