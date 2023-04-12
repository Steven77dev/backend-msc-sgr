package com.restaurante.microservicios.msclogistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages  = { "com.restaurante.microservicios.msclogistica"})
public class MscLogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscLogisticaApplication.class, args);
	}

}
