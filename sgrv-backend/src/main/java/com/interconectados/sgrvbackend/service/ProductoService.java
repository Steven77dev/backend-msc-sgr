package com.interconectados.sgrvbackend.service;

import com.interconectados.sgrvbackend.models.request.BusqProductoPorPedirRequest;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msc-productos", url = "http://localhost:8089")
public interface ProductoService {

    @PostMapping("/productos/listarProductosPedir")
    Response<Object> listarProductosPedir(@RequestBody BusqProductoPorPedirRequest request);
}
