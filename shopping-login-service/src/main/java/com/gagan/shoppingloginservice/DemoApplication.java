/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-24 01:22:24
 * @modify date 2020-04-24 01:22:24
 * @desc [description]
 */
package com.gagan.shoppingloginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Enabled Client Discover
 * Was working even without the annotation
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableSwagger2WebMvc
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
