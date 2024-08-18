package com.restaurante.microservicios.mscfinanzas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.mscfinanzas","com.restaurante.microservicios.common", "com.restaurante.microservicios.mscfinanzas.mapper"})
@EnableFeignClients
@EnableEurekaClient
public class MscFinanzasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscFinanzasApplication.class, args);
    }

}
