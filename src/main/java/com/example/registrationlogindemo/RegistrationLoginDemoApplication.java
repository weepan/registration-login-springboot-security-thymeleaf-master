package com.example.registrationlogindemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.example.registrationlogindemo.mapper")
public class RegistrationLoginDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginDemoApplication.class, args);
	}

}
