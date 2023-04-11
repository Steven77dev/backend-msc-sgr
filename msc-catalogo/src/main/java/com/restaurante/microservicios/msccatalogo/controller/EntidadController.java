package com.restaurante.microservicios.msccatalogo.controller;

import com.restaurante.microservicios.msccatalogo.entity.Entidad;
import com.restaurante.microservicios.msccatalogo.utils.ApiResponse;
import com.restaurante.microservicios.msccatalogo.service.EntidadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Servicios para el consumo de la tabla ENTIDAD", tags = "api-catalogo")
@RestController
@RequestMapping("/entidad")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @GetMapping("/listado")
    @ApiOperation(value = "Listado de entidad.")
    public ResponseEntity<ApiResponse> listado(){
        return entidadService.listado();

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener por id.")
    public ResponseEntity<ApiResponse> obtenerPorId(@PathVariable("id") long codigo){
       return entidadService.obtenerPorId(codigo);

    }

    @PostMapping("/guardar")
    @ApiOperation(value = "Registro nueva entidad.")
    public ResponseEntity<ApiResponse> guardar(@RequestBody Entidad objeto){
       return entidadService.guardar(objeto);

    }
}
