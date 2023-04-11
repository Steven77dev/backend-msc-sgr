package com.restaurante.microservicios.mscpersona.controller;

import com.restaurante.microservicios.mscpersona.entity.Persona;
import com.restaurante.microservicios.mscpersona.service.impl.PersonaService;
import com.restaurante.microservicios.mscpersona.utils.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "Servicios para el consumo de personas", tags = "api-personas")
@RestController
@RequestMapping("/persona")
public class PersonaController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private PersonaService personaService;

    @GetMapping("/listado")
    @ApiOperation(value = "Obtener listado")
    public ResponseEntity<ApiResponse> listarPersona(){
       return personaService.listado();

    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> obtenerPersona(@PathVariable("id") String codigo){
       return personaService.obtenerUsuarioPorId(codigo);

    }

    @PostMapping("/guardar")
    @ApiOperation(value = "Registrar persona.")
    public ResponseEntity<ApiResponse> guardarPersona(@RequestBody Persona persona){
        return personaService.guardar(persona);

    }
}
