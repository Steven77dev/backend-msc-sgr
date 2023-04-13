package com.restaurante.microservicios.mscpersonal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.mscpersonal","com.restaurante.microservicios.common", "com.restaurante.microservicios.mscpersonal.mapper"})
@EnableFeignClients
@EnableEurekaClient
public class MscPersonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscPersonalApplication.class, args);
    }

}
