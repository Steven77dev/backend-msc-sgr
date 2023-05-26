package com.restaurante.microservicios.msccomercial.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.msccomercial.models.request.BusqProductoPorPedirRequest;
import com.restaurante.microservicios.msccomercial.models.response.ListadoMesasAtencionResponse;
import com.restaurante.microservicios.msccomercial.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Tag(name = "Api-Producto", description = "Servicios para productos")
@RestController
@CrossOrigin
@RequestMapping("/productos")
public class ProductoController {

    private ProductoService productoService;

    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @Operation(description = "Productos para pedir",
            summary = "Listado de productos filtrado por almacen (@LSPARAM1), familia (@LSPARAM2), local (@LSPARAM3), entidad (@LIENTIDAD)",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ListadoMesasAtencionResponse.class))})
            })
    @PostMapping("/listarProductosPedir")
    public ResponseEntity<Response<Object>> productosPorPedir(@Valid @RequestBody BusqProductoPorPedirRequest request){
        return productoService.productosPorPedir(request);

    }



}
