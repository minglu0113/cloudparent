package com.atguigu.springcloud;

import com.atguigu.springcloud.component.NameInterface;
import com.atguigu.springcloud.exception.TooLongExceptio;
import com.atguigu.springcloud.service.impl.RsServiceImpl;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

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
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setAddress("http://localhost/rs/hello");
        factoryBean.setServiceBean(new RsServiceImpl());
        factoryBean.create();
    }
}
