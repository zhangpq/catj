package com.catj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker//打开Hystrix断路器
public class CatjMidwareServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatjMidwareServiceApplication.class, args);
	}
}
