package com.interconectados.sgrvbackend.service.finanzas;

import com.interconectados.sgrvbackend.models.request.BusqAperturaCierreRequest;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msc-finanzas", url = "http://localhost:8082")
public interface IngresoDiarioRest {

    @PostMapping("/ingresos/verificarAperturaCaja")
    Response<Object> verificarAperturaCaja(@RequestBody BusqAperturaCierreRequest request);
}
