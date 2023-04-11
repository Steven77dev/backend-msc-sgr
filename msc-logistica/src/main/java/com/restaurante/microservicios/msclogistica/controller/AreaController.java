package com.restaurante.microservicios.msclogistica.controller;

import com.restaurante.microservicios.msclogistica.entity.Area;
import com.restaurante.microservicios.msclogistica.service.AreaService;
import com.restaurante.microservicios.msclogistica.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService areaService;


    @GetMapping(value = "/listado")
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
