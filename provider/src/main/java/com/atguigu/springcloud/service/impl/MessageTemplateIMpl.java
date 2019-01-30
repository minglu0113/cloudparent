package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.MessageTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class MessageTemplateIMpl implements MessageTemplate {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;
    @Override
    public void sent(String string, Object object) {

        simpMessagingTemplate.convertAndSend(string,object);
    }
}
