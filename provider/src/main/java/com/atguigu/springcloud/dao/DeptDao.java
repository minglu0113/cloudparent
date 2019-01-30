package com.atguigu.springcloud.dao;

import com.zhang.entityes.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;


@MapperScan
public interface DeptDao
{
	boolean addDept(Dept dept);

	Dept findById(Long id);

	List<Dept> findAll();

	List<Dept> list();
}
