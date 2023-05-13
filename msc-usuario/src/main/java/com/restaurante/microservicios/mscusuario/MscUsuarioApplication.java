package com.restaurante.microservicios.mscusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.mscusuario","com.restaurante.microservicios.common", "com.restaurante.microservicios.mscusuario.mapper"})
@EnableFeignClients
//@EnableEurekaClient
public class MscUsuarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscUsuarioApplication.class, args);
    }

}
