package com.catj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@EnableZipkinServer
@SpringBootApplication
public class CatjZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatjZipkinApplication.class, args);
	}
}