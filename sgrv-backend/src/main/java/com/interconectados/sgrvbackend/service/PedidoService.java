package com.interconectados.sgrvbackend.service;

import com.interconectados.sgrvbackend.models.request.BusqMesasRequest;
import com.interconectados.sgrvbackend.models.request.BusqPedidosMesaRequest;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msc-comercial", url = "http://localhost:8089")
public interface PedidoService {

    @PostMapping("/pedidos/listadoMesasLocal")
    ResponseEntity<Response<Object>> listadoMesasLocal(@RequestBody BusqMesasRequest request);

    @PostMapping("/pedidos/listarPedidosPorMesa")
    ResponseEntity<Response<Object>> listarPedidosPorMesa(@RequestBody BusqPedidosMesaRequest request);
}
