package com.catj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;

@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker//打开Hystrix断路器
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableJpaRepositories(basePackages = "com.catj.dao")
public class CatjUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatjUserServiceApplication.class, args);
	}

}
