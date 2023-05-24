package com.restaurante.microservicios.msccomercial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.msccomercial","com.restaurante.microservicios.common"})
@EnableFeignClients
//@EnableEurekaClient
public class MscComercialApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscComercialApplication.class, args);
    }

}
