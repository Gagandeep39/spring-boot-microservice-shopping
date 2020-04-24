package com.gagan.shoppingproductservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication	// Mark it as Pring boot
@EnableEurekaClient	// Enables app to fetch registry from dicovery server
@EnableSwagger2WebMvc	//Enable swagger
// @EnableAspectJAutoProxy	// Enable logging, can be replaced with spring.aop.auto
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
