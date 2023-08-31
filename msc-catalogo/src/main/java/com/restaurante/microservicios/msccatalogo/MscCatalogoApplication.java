package com.restaurante.microservicios.msccatalogo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.msccatalogo","com.restaurante.microservicios.common"})
public class MscCatalogoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MscCatalogoApplication.class, args);
	}

}
