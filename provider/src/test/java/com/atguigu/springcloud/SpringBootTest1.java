package com.atguigu.springcloud;

import com.atguigu.springcloud.exception.TooLongExceptio;
import com.atguigu.springcloud.service.TestBeansService;
import com.sun.xml.internal.ws.model.JavaMethodImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTest1 {


    @Autowired
    Properties loadRabbitProperties;

    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;//websocket
    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired
    DataSource dataSource;
    @Test
    public void testJavaMail2() throws MessagingException {

        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage,true);
        mimeMessageHelper.setSubject("复杂邮件头");
        mimeMessageHelper.setText("<b style='red'>6666666</b>",true);
        mimeMessageHelper.setFrom("303086052@qq.com");
        mimeMessageHelper.setTo("2053544827@qq.com");
        mimeMessageHelper.addAttachment("1.jpg",new File("D:\\WorkSpace\\apache-maven-3.5.3\\settings.xml"));
        javaMailSender.send(mimeMailMessage);
    }
    @Test
    public void testJavaMaill(){

        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("简单邮件头");
        message.setText("简单邮件体");

        message.setTo("2053544827@qq.com");
        message.setFrom("303086052@qq.com");
        for(int i=0;i<5;i++){
            javaMailSender.send(message);
        }
    }
    @Test
    public void test(){
        System.out.println(dataSource.getClass());
    }

    //创建交换器
    @Test
    public void amqp(){
        //amqpAdmin.declareQueue(new Queue(""));
        amqpAdmin.declareExchange(new DirectExchange("testamqp"));
    }
    //绑定交换器
    @Test
    public void amqp2(){
        Binding binding = new Binding("zhang2",Binding.DestinationType.QUEUE,"testamqp","testamqpkey",null);
        amqpAdmin.declareBinding(binding);
    }
    @Test
    public void testSendRabbit(){
        Map map = new HashMap();
        map.put("message","zhangluming");

        rabbitTemplate.convertAndSend("luming","zhangluming",map);
    }

    @Test
    public void testRabbit(){
        Object o = rabbitTemplate.receiveAndConvert("zhang");
        System.out.println(o.getClass());
        System.out.println(o);
    }
    @Test
    public void testLoadProperties(){
        System.out.println(loadRabbitProperties.getProperty("name"));
    }

    @Test
    public void testMyException(){
        test t = new test();
        try {
            t.test();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void testaspect(){
        test t = new test();
        t.testInterface();
    }
    @Test
    public void testss(){
        Integer i = 2;
        Integer j = i;
        System.out.println(j==i);
        i =333;
        System.out.println(j);
    }
    @Test
    public void testss11(){
        Integer i = new Integer(100);
        int j = 100;
        System.out.println(j==i);
    }
    @Test
    public void testaaa(){
        Person person = new Person();
        Person person1 = person;
        System.out.println(person==person1);
        person.setName("zhang");
        System.out.println(person1);
    }
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void testredis(){

        stringRedisTemplate.opsForValue().append("keys","values");
    }
    @Autowired
    RedisTemplate perRedisTemplate;
    @Test
    public void testpersonredis(){
        com.atguigu.springcloud.bean.Person person = new com.atguigu.springcloud.bean.Person("zhang",12);
        perRedisTemplate.opsForValue().set("person",person);
    }
    @Test
    public void testgetpersonredis(){
        com.atguigu.springcloud.bean.Person person = new com.atguigu.springcloud.bean.Person("zhang",12);
        Object person1 = perRedisTemplate.opsForValue().get("person");
        System.out.println(person1);
    }
    @Autowired
    private Set<TestBeansService> testBeansServices;
    @Test
    public void setTestBeansServices(){
        for (TestBeansService t: testBeansServices
             ) {
            t.say();
        }
    }

    @Autowired
    private com.atguigu.springcloud.bean.Person person;
    @Test
    public void testperson(){
        System.out.println(person.getNamej());
    }
}
