package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.bean.User;
import com.atguigu.springcloud.component.NameInterface;
import com.atguigu.springcloud.exception.TooLongExceptio;
import com.atguigu.springcloud.service.DeptService;
import com.atguigu.springcloud.service.RedisTestService;
import com.atguigu.springcloud.service.UserService;
import com.atguigu.springcloud.test;
import com.zhang.entityes.Dept;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080/webjars/jquery/3.3.1-1/jquery.js
@RestController
public class DeptController
{

	Logger logger = LoggerFactory.getLogger(Logger.class);
	@Autowired
	private DeptService service;
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept)
	{
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id)
	{
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list()
	{
		return service.list();
	}

	
//	@Autowired
//	private DiscoveryClient client;
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("springcloud8001");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}

	@NameInterface("mytest")
	@RequestMapping("/test")
	public String testaspect(String name,Integer i){
		return "80000000003";
	}
	@NameInterface("mytest")
	@RequestMapping("/test1")
	public String testaspect(Integer i,String name){
		return "fafa";
	}
	@RequestMapping("/testcontrollerAdvice")
	public String testcontrollerAdvice() throws TooLongExceptio
	{
		test t = new test();
		t.test();
		return "fafa";
	}

	@Autowired
	RedisTestService testService;
	@RequestMapping("/testRedis")
	@ResponseBody
	public void testRedis(){
		testService.getInt(1);
	}

	@Autowired
	UserService userService;
	@RequestMapping("/get/{name}")
	@ResponseBody
	public User getUser(@PathVariable("name") String name){
		return userService.getUser(name);
	}
}
