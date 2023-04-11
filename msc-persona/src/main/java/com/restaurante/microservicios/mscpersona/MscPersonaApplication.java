package com.restaurante.microservicios.mscpersona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MscPersonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscPersonaApplication.class, args);
	}

}
