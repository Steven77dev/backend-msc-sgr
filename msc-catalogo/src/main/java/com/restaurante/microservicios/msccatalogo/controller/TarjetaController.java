package com.restaurante.microservicios.msccatalogo.controller;


import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.msccatalogo.entity.Tarjeta;
import com.restaurante.microservicios.msccatalogo.service.TarjetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Api-Catalogos", description = "Servicios para consultar tarjetas")
@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {

    @Autowired
    private TarjetaService tarjetaService;

    @Operation(description = "Listado de tarjetas por entidad", summary = "Listado de tarjeta por entidad (@entidad)",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Tarjeta.class))})
            })
    @GetMapping("/listado/{idEntidad}/{estadoRegistro}")
    public Response<Object> listado(@PathVariable int idEntidad, @PathVariable int estadoRegistro){
        return tarjetaService.listado(idEntidad, estadoRegistro);

    }
}
