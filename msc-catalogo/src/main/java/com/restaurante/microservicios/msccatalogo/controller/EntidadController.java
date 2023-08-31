package com.restaurante.microservicios.msccatalogo.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.msccatalogo.entity.Entidad;
import com.restaurante.microservicios.msccatalogo.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Api(value = "Servicios para el consumo de la tabla ENTIDAD", tags = "api-catalogo")
@RestController
@RequestMapping("/entidad")
public class EntidadController {

    @Autowired
    private EntidadService entidadService;

    @GetMapping("/listado")
    //@ApiOperation(value = "Listado de entidad.")
    public Response<Object> listado(){
        return entidadService.listado();

    }

    @GetMapping("/{id}")
    //@ApiOperation(value = "Obtener por id.")
    public Response<Object> obtenerPorId(@PathVariable("id") long codigo){
       return entidadService.obtenerPorId(codigo);

    }

    @PostMapping("/guardar")
    //@ApiOperation(value = "Registro nueva entidad.")
    public Response<Object> guardar(@RequestBody Entidad objeto){
       return entidadService.guardar(objeto);

    }
}
