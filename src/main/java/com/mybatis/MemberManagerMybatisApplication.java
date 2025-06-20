package com.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Mapper
@SpringBootApplication
public class MemberManagerMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberManagerMybatisApplication.class, args);
	}

}
