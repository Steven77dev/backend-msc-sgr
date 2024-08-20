package com.restaurante.microservicios.msccomercial;

import feign.Retryer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.restaurante.microservicios.msccomercial","com.restaurante.microservicios.common"})
@EnableFeignClients
@EnableEurekaClient
public class MscComercialApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscComercialApplication.class, args);
    }

    @Bean
    public Retryer feignRetryer() {
        return new Retryer.Default(100, 1000, 5);
    }

}
