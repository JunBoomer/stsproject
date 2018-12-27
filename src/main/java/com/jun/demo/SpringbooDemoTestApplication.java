package com.jun.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.jun.demo.mapper")
@EnableScheduling
public class SpringbooDemoTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbooDemoTestApplication.class, args);
	}

}

