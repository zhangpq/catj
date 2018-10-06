package com.catj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker//打开Hystrix断路器
@SpringBootApplication
public class CatjCasServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatjCasServiceApplication.class, args);
	}

}
