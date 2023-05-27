package com.interconectados.sgrvbackend.service;

import com.interconectados.sgrvbackend.models.request.*;
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

    @PostMapping("/pedidos/agregarProductoPedido")
    ResponseEntity<Response<Object>> agregarProductoPedido(@RequestBody AgregarProductoPedidoRequest request);

    @PostMapping("/pedidos/crearPedido")
    ResponseEntity<Response<Object>> crearPedido(@RequestBody CrearPedidoRequest request);

    @PostMapping("/pedidos/asignarMesaPedido")
    ResponseEntity<Response<Object>> asignarMesaPedido(@RequestBody AsignarMesaPedidoRequest request);

}
