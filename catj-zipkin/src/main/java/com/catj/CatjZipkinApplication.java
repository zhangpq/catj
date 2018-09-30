package com.catj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
@EnableEurekaClient
public class CatjZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatjZipkinApplication.class, args);
	}
}
