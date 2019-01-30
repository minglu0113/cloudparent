package com.atguigu.springcloud.exception;

public class TooLongExceptio extends Exception {

    public  TooLongExceptio(){
        super("该用户已有加值记录，如要修改请点击修改按钮");
    }
    public TooLongExceptio(String message) {
        super("用户："+message+"已经存在！");
    }
}
