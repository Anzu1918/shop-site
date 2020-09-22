package com.co.chubb.test.main;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.co.chubb.test.repository.ItemRepository;
import com.co.chubb.test.repository.StockRepository;

@EnableDiscoveryClient
@SpringBootApplication

@ComponentScan(basePackages = "com.co.chubb.test")
@EnableJpaRepositories(basePackageClasses = {ItemRepository.class, StockRepository.class})
@EntityScan(basePackages = "com.co.chubb.test.entity")
public class MainMicroserviceApplication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SpringApplication.run(MainMicroserviceApplication.class, args);
	}

}
