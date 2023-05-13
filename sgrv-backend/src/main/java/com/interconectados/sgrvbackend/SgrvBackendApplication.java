package com.interconectados.sgrvbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.interconectados.sgrvbackend","com.restaurante.microservicios.common"})
@EnableFeignClients
public class SgrvBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgrvBackendApplication.class, args);
	}

}
