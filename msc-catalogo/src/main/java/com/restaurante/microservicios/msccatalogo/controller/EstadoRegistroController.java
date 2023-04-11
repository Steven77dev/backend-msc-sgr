package com.restaurante.microservicios.msccatalogo.controller;

import com.restaurante.microservicios.msccatalogo.entity.EstadoRegistros;
import com.restaurante.microservicios.msccatalogo.utils.ApiResponse;
import com.restaurante.microservicios.msccatalogo.service.EstadoRegistroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Servicios para el consumo de la tabla ESTADO_REGISTROS", tags = "api-catalogo")
@RestController
@RequestMapping("/estado-registro")
public class EstadoRegistroController {

    @Autowired
    private EstadoRegistroService estadoRegistroService;

    @GetMapping("/listado")
    @ApiOperation(value = "Listado de estados de registros.")
    public ResponseEntity<ApiResponse> listado(){
        return estadoRegistroService.listado();

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listado de estados de registros.")
    public ResponseEntity<ApiResponse> obtenerPorId(@PathVariable("id") long codigo){
       return estadoRegistroService.obtenerPorId(codigo);

    }

    @PostMapping("/guardar")
    @ApiOperation(value = "Registro nuevo estado.")
    public ResponseEntity<ApiResponse> guardar(@RequestBody EstadoRegistros objeto){
       return estadoRegistroService.guardar(objeto);

    }
}
