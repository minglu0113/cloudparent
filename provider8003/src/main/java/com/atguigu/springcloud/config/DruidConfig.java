package com.atguigu.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.springcloud.bean.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
       return new DruidDataSource();
    }
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
//
//        return bean;
//    }
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean bean = new FilterRegistrationBean(new StatViewFilter());
//        return bean;
//    }
    @Bean
    //application.yml 有com.zhang.test.person=zhangluming时会创建bean放进容器中
    @ConditionalOnProperty(prefix = "com.zhang.test",name = "person",havingValue = "zhangluming")
    public Person person(){
        return new Person("zhangluming",12);
    }
}
