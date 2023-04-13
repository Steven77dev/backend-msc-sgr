package com.restaurante.microservicios.mscpersonal.feignclients;

import com.restaurante.microservicios.mscpersonal.utils.ApiResponse;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponseBuilder;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "msc-persona")
public interface PersonaFeignClient {

    @CircuitBreaker(name = "persona-cb", fallbackMethod = "fallbackObtenerDatosPersona")
    @GetMapping("/persona/{id}")
    ResponseEntity<ApiResponse> obtenerPorId(@PathVariable("id") String codigo);

    default ResponseEntity<ApiResponse> fallbackObtenerDatosPersona(String codigo, Throwable throwable) {
        return new ApiResponseBuilder().respuestaConErrorMicroservicio(null);
    }
}
