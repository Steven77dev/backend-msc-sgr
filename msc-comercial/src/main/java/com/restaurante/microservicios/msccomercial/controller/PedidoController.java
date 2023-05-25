package com.restaurante.microservicios.msccomercial.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.msccomercial.models.request.BusqMesasRequest;
import com.restaurante.microservicios.msccomercial.models.request.BusqPedidosMesaRequest;
import com.restaurante.microservicios.msccomercial.models.response.ListadoMesasAtencionResponse;
import com.restaurante.microservicios.msccomercial.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Tag(name = "Api-Pedido", description = "Servicios para pedidos")
@RestController
@CrossOrigin
@RequestMapping("/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService){
        this.pedidoService = pedidoService;
    }

    @Operation(description = "Mesas de local", summary = "Listado de mesas ocupadas y disponibles",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ListadoMesasAtencionResponse.class))})
            })
    @PostMapping("/listadoMesasLocal")
    public ResponseEntity<Response<Object>> listadoMesasLocal(@Valid @RequestBody BusqMesasRequest request){
        return pedidoService.listadoMesasLocal(request);

    }

    @PostMapping("/listarPedidosPorMesa")
    public ResponseEntity<Response<Object>> listarPedidosPorMesa(@Valid @RequestBody BusqPedidosMesaRequest request){
        return pedidoService.listarPedidosPorMesa(request);

    }


}
