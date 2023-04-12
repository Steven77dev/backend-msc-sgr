package com.restaurante.microservicios.mscpersonal.controller;

import com.restaurante.microservicios.mscpersonal.entity.Cargo;
import com.restaurante.microservicios.mscpersonal.service.CargoService;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Api-Cargo", description = "Servicios CRUD de Cargo")
@RestController
@RequestMapping("/cargo")
public class CargoController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CargoService cargoService;

    public CargoController(CargoService cargoService){
        this.cargoService=cargoService;
    }


    @GetMapping("/listado")
    @Operation(description = "Listado sin parametros", summary = "Recurso que devuelve un listado")
    public ResponseEntity<ApiResponse> listar(){
       return cargoService.listado();

    }

    @GetMapping("/{id}")
    @Operation(description = "Obtener cargo por id", summary = "Recurso que devuelve un registro")
    public ResponseEntity<ApiResponse> obtener(@PathVariable("id") Long codigo){
       return cargoService.obtenerPorId(codigo);

    }

    @PostMapping("/guardar")
    @Operation(description = "Registro / actualización de cargo", summary = "Recurso que graba o actualiza el cargo")
    public ResponseEntity<ApiResponse> guardarPersonal(@RequestBody Cargo objeto){
        return cargoService.guardar(objeto);

    }


}
