package com.mike.backJava2024FreshmanTask;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = {"com.mike.backJava2024FreshmanTask.repository"})
public class BackJava2024FreshmanTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackJava2024FreshmanTaskApplication.class, args);
	}

}
