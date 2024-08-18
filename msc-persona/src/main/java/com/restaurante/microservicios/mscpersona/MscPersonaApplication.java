package com.restaurante.microservicios.mscpersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.mscpersona","com.restaurante.microservicios.common", "com.restaurante.microservicios.mscpersona.mapper"})
@EnableEurekaClient
public class MscPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscPersonaApplication.class, args);
	}

}
