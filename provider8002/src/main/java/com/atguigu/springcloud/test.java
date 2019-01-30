package com.atguigu.springcloud;

import com.atguigu.springcloud.component.NameInterface;
import com.atguigu.springcloud.exception.TooLongExceptio;

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
}
