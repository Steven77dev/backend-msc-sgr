package com.restaurante.microservicios.msccomercial.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.msccomercial.models.SqlSPResponse;
import com.restaurante.microservicios.msccomercial.models.request.*;
import com.restaurante.microservicios.msccomercial.models.response.ListadoMesasAtencionResponse;
import com.restaurante.microservicios.msccomercial.models.response.PedidoCreadoResponse;
import com.restaurante.microservicios.msccomercial.models.response.ProductoPedidoItemResponse;
import com.restaurante.microservicios.msccomercial.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Tag(name = "Api-Pedido", description = "Servicios para pedidos")
@RestController
@CrossOrigin
@RequestMapping("/pedidos")
public class PedidoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
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

    @Operation(description = "Agregar producto a pedido", summary = "Se agregar el producto al pedido con la cantidad",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ProductoPedidoItemResponse.class))})
            })
    @PostMapping("/agregarProductoPedido")
    public ResponseEntity<Response<Object>> agregarProductoPedido(@Valid @RequestBody AgregarProductoPedidoRequest request){
        logger.info("Agregar producto al pedido {}", request );
        return pedidoService.agregarProductoPedido(request);
    }

    @Operation(description = "Crear pedido", summary = "Se crea pedido para la mesa",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = PedidoCreadoResponse.class))})
            })
    @PostMapping("/crearPedido")
    public ResponseEntity<Response<Object>> crearPedido(@Valid @RequestBody CrearPedidoRequest request){
        return pedidoService.crearPedido(request);
    }

    @Operation(description = "Asignar mesa", summary = "Se asigna mesa a pedido",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SqlSPResponse.class))})
            })
    @PostMapping("/asignarMesaPedido")
    public ResponseEntity<Response<Object>> asignarMesaPedido(@Valid @RequestBody AsignarMesaPedidoRequest request){
        return pedidoService.asignarMesaPedido(request);
    }
}
