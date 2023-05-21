package com.restaurante.microservicios.mscfinanzas.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.mscfinanzas.models.request.BusqAperturaCierreRequest;
import com.restaurante.microservicios.mscfinanzas.models.request.BusqIngresoEgresoRequest;
import com.restaurante.microservicios.mscfinanzas.models.request.BusqIngresoPersonalRequest;
import com.restaurante.microservicios.mscfinanzas.models.response.AperturaCierreResponse;
import com.restaurante.microservicios.mscfinanzas.models.response.IngresoEgresoResponse;
import com.restaurante.microservicios.mscfinanzas.models.response.ResumenEgrePersonalResponse;
import com.restaurante.microservicios.mscfinanzas.models.response.ResumenIngrePersonalResponse;
import com.restaurante.microservicios.mscfinanzas.service.EgresoDiarioService;
import com.restaurante.microservicios.mscfinanzas.service.IngresoDiarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name = "Api-Egresos", description = "Servicios de egreso diario")
@RestController
@RequestMapping("/egresos")
public class EgresoDiarioController {

    private EgresoDiarioService egresoDiarioService;

    public EgresoDiarioController(EgresoDiarioService egresoDiarioService){
        this.egresoDiarioService = egresoDiarioService;
    }



    @Operation(description = "Resumen de Egresos por el personal", summary = "Se lista los egresos realizados por el personal que aperturó caja",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ResumenEgrePersonalResponse.class))})
            })
    @PostMapping("/resumenEgresosPersonal")
    public ResponseEntity<Response<Object>> resumenEgresosPersonal(@Valid @RequestBody BusqIngresoPersonalRequest request){
        return egresoDiarioService.listadoEgresosPersonal(request);
    }

    @PostMapping("/cajaCierreAnterior")
    public ResponseEntity<Response<Object>> cajaCierreAnterior(@Valid @RequestBody BusqIngresoEgresoRequest request){
        return egresoDiarioService.cierreCajaDiaAnterior(request);
    }
}
