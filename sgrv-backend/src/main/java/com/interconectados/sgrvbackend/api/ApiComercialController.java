package com.interconectados.sgrvbackend.api;

import com.interconectados.sgrvbackend.models.request.BusqMesasRequest;
import com.interconectados.sgrvbackend.models.request.BusqPedidosMesaRequest;
import com.interconectados.sgrvbackend.service.PedidoServiceImpl;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/comercial")
public class ApiComercialController {

    private final PedidoServiceImpl pedidoService;

    public ApiComercialController(PedidoServiceImpl pedidoService){
        this.pedidoService = pedidoService;
    }


    @PostMapping(value = "/listadoMesasLocal", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse listadoMesasLocal(@RequestBody BusqMesasRequest request){
        return pedidoService.listadoMesasLocal(request);
    }


    @PostMapping(value = "/pedidosPorMesa", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse listarPedidosPorMesa(@RequestBody BusqPedidosMesaRequest request){
        return pedidoService.listarPedidosPorMesa(request);
    }
}
