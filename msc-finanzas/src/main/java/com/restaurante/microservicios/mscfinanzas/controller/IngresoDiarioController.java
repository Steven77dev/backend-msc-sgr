package com.restaurante.microservicios.mscfinanzas.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.mscfinanzas.models.request.*;
import com.restaurante.microservicios.mscfinanzas.models.response.AperturaCierreResponse;
import com.restaurante.microservicios.mscfinanzas.models.response.IngresoEgresoResponse;
import com.restaurante.microservicios.mscfinanzas.models.response.ResumenIngrePersonalResponse;
import com.restaurante.microservicios.mscfinanzas.models.response.SqlSPResponse;
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

@Tag(name = "Api-Ingresos", description = "Servicios de ingreso diario")
@RestController
@RequestMapping("/ingresos")
public class IngresoDiarioController {

    private IngresoDiarioService ingresoDiarioService;

    public IngresoDiarioController(IngresoDiarioService ingresoDiarioService){
        this.ingresoDiarioService = ingresoDiarioService;
    }

    @Operation(description = "Ingresos vs Egresos", summary = "Listado que me retorna mis ingresos y egresos segun local y fecha",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = IngresoEgresoResponse.class))})
            })
    @PostMapping("/ingresosVsEgresos")
    public Response<Object> ingresosVsEgresos(@Valid @RequestBody BusqIngresoEgresoRequest request){
        return ingresoDiarioService.listadoIngresosVsEgresos(request);

    }

    @Operation(description = "Apertura y cierre de caja por personal", summary = "Se obtiene los valores si se puede aperturar o cerrar caja por personal",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AperturaCierreResponse.class))})
            })
    @PostMapping("/aperturaCierre")
    public Response<Object> datosAperturaCierre(@Valid @RequestBody BusqAperturaCierreRequest request){
        return ingresoDiarioService.datosAperturaCierre(request);

    }

    @Operation(description = "Verificar apertura de caja", summary = "Se obtiene los valores si caja está aperturada",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = AperturaCierreResponse.class))})
            })
    @PostMapping("/verificarAperturaCaja")
    public Response<Object> verificarAperturaCaja(@Valid @RequestBody BusqAperturaCierreRequest request){
        return ingresoDiarioService.verificarAperturaCaja(request);

    }

    @Operation(description = "Resumen de Ingresos por el personal", summary = "Se lista los ingresos realizados por el personal que aperturó caja",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = ResumenIngrePersonalResponse.class))})
            })
    @PostMapping("/resumenIngresosPersonal")
    public Response<Object> resumenIngresosPersonal(@Valid @RequestBody BusqIngresoPersonalRequest request){
        return ingresoDiarioService.listadoIngresosPersonal(request);
    }

    @Operation(description = "Cuadrar caja", summary = "Se realiza el cuadre de caja del local en base al personal",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SqlSPResponse.class))})
            })
    @PostMapping("/cuadrarCaja")
    public Response<Object> cuadrarCaja(@Valid @RequestBody CuadrarCajaRequest request){
        return ingresoDiarioService.cuadrarCaja(request);
    }

    @Operation(description = "Cerrar caja", summary = "Se realiza el cierre de caja del local en base al personal",
            responses = {
                    @ApiResponse(responseCode = "200",
                            description = "OK",
                            content = {@Content(mediaType = "application/json",
                                    schema = @Schema(implementation = SqlSPResponse.class))})
            })
    @PostMapping("/cerrarCaja")
    public Response<Object> cerrarCaja(@Valid @RequestBody CerrarCajaRequest request){
        return ingresoDiarioService.cerrarCaja(request);
    }
}
