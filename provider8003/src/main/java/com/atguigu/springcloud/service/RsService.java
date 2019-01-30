package com.atguigu.springcloud.service;

import com.atguigu.springcloud.bean.User;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/userService")
@Produces("*/*")
public interface RsService {
    @Path("/user")
    @POST
    @Consumes()
    public void saveUser(User user);
}
