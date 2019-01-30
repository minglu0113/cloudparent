package com.atguigu.springcloud.config;

import com.atguigu.springcloud.exception.TooLongExceptio;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice//只在controller中起作用
public class MyExceptionHandler {

    @ExceptionHandler(TooLongExceptio.class)//异常发生时所进入的方法
    public String handlerException(TooLongExceptio tooLongExceptio){
        tooLongExceptio.printStackTrace();
        Map map = new HashMap();
        map.put("msg",tooLongExceptio.getMessage());
        return "异常发生时所进入的方法";
    }
}
