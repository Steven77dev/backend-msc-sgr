package com.restaurante.microservicios.mscpersonal.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msc-persona",url = "http://localhost:8091")
public interface PersonaFeignClient {

    @GetMapping("/persona/{id}")
    public ResponseEntity<String> obtenerPorId(@PathVariable("id") String codigo);
}
