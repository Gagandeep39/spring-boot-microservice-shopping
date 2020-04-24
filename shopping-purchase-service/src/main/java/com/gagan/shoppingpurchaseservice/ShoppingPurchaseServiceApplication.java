package com.gagan.shoppingpurchaseservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrixDashboard
@EnableCircuitBreaker
@EnableSwagger2WebMvc
public class ShoppingPurchaseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingPurchaseServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
	public Docket swaggerCongiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			// .paths(PathSelectors.ant("/"))	// Will prevent some Paths from being Shown
			// .apis(RequestHandlerSelectors.basePackage("com.gagan"))
			.build()
			.apiInfo(apidetails());
	}

	/**
	 * API Info 
	 * Name
	 * Description
	 * Version
	 * Terms of Services
	 * Contacts Info
	 * License Info
	 * Company URL
	 * Addition Vender Info (Collections<VendorInfo> asd)
	 */
	private ApiInfo apidetails() {
		return new ApiInfo(
			"Products API", 
			"It Contains Information about the products that are managed via API",
			"1.0G", 
			"My Terms of Services",
			new Contact("Gagandeep Singh", "github.com/gagandeep39", "singh.gagandeep3911@gmail.com"),
			"API license", 
			"www.gagandeep.com", 
			Collections.emptyList());
	}
}
