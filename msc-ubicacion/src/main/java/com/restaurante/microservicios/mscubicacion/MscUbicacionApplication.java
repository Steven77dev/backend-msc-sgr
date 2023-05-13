package com.restaurante.microservicios.mscubicacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.mscubicacion","com.restaurante.microservicios.common", "com.restaurante.microservicios.mscubicacion.mapper"})
@EnableFeignClients
//@EnableEurekaClient
public class MscUbicacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscUbicacionApplication.class, args);
    }

}
