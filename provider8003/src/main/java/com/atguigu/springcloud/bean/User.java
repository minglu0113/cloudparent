package com.atguigu.springcloud.bean;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@XmlRootElement(name = "User")
public class User {

    private String id;
    private String name;
    private String password;
}
