package com.restaurante.microservicios.msclogistica.controller;

import com.restaurante.microservicios.msclogistica.entity.Area;
import com.restaurante.microservicios.msclogistica.service.AreaService;
import com.restaurante.microservicios.msclogistica.utils.ApiResponse;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/area")
@Tag(name = "Api-Cargo", description = "Servicios CRUD de Cargo")
public class AreaController {

    @Autowired
    private AreaService areaService;


    @GetMapping(value = "/listado")
    @Operation(description ="", summary = "Registrar personal.")
    public ResponseEntity<ApiResponse> listado() {
        return areaService.listado();
    }

    @GetMapping(value = "/{id}")
    public Area obtenerPorId(@PathVariable long id){
        return areaService.obtenerPorId(id);
    }

    @PostMapping(value = "/guardar")
    public Area guardar(@RequestBody Area area){
        return areaService.guardar(area);
    }
}
