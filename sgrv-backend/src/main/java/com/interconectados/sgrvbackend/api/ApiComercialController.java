package com.interconectados.sgrvbackend.api;

import com.interconectados.sgrvbackend.models.request.*;
import com.interconectados.sgrvbackend.service.comercial.PedidoService;
import com.interconectados.sgrvbackend.service.comercial.ProductoService;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/comercial")
public class ApiComercialController {

    private final PedidoService pedidoService;
    private final ProductoService productoService;

    public ApiComercialController(PedidoService pedidoService, ProductoService productoService){
        this.pedidoService = pedidoService;
        this.productoService= productoService;
    }


    @PostMapping(value = "/listadoMesasLocal", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse listadoMesasLocal(@RequestBody BusqMesasRequest request){
        return pedidoService.listadoMesasLocal(request);
    }


    @PostMapping(value = "/pedidosPorMesa", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse listarPedidosPorMesa(@RequestBody BusqPedidosMesaRequest request){
        return pedidoService.listarPedidosPorMesa(request);
    }

    @PostMapping(value = "/productosPorPedir", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse listarProductosPorPedir(@RequestBody BusqProductoPorPedirRequest request){
        return productoService.listarProductosPedir(request);
    }

    @PostMapping(value = "/agregarProductoPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse agregarProductoPedido(@RequestBody AgregarProductoPedidoRequest request){
        return pedidoService.agregarProductoPedido(request);
    }

    @PostMapping(value = "/crearPedido", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse crearPedido(@RequestBody CrearPedidoRequest request){
        return pedidoService.crearPedido(request);
    }
}
