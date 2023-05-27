package com.interconectados.sgrvbackend.service;

import com.interconectados.sgrvbackend.models.request.*;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msc-comercial", url = "http://localhost:8089")
public interface PedidoService {

    @PostMapping("/pedidos/listadoMesasLocal")
    Response<Object> listadoMesasLocal(@RequestBody BusqMesasRequest request);

    @PostMapping("/pedidos/listarPedidosPorMesa")
    Response<Object> listarPedidosPorMesa(@RequestBody BusqPedidosMesaRequest request);

    @PostMapping("/pedidos/agregarProductoPedido")
    Response<Object> agregarProductoPedido(@RequestBody AgregarProductoPedidoRequest request);

    @PostMapping("/pedidos/crearPedido")
    Response<Object> crearPedido(@RequestBody CrearPedidoRequest request);

    @PostMapping("/pedidos/asignarMesaPedido")
    Response<Object> asignarMesaPedido(@RequestBody AsignarMesaPedidoRequest request);

}
