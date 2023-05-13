package com.restaurante.microservicios.mscseguridad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.mscseguridad","com.restaurante.microservicios.common", "com.restaurante.microservicios.mscseguridad.mapper"})
@EnableFeignClients
//@EnableEurekaClient
public class MscSeguridadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscSeguridadApplication.class, args);
    }

}
