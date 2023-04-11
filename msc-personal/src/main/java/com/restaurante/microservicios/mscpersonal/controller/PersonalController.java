package com.restaurante.microservicios.mscpersonal.controller;

import com.restaurante.microservicios.mscpersonal.dto.RegistrarPersonalOficinaDTO;
import com.restaurante.microservicios.mscpersonal.service.PersonalOficinaService;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Api(value = "Api-Personal", tags = "Servicios de personal y personal asignado")
@RestController
@RequestMapping("/personal")
public class PersonalController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private PersonalOficinaService personalOficinaService;

    @PostMapping("/guardar")
    @Operation(description ="", summary = "Registrar personal.")
    public ResponseEntity<ApiResponse> guardarPersonal(@RequestBody RegistrarPersonalOficinaDTO personalOficinaDTO, HttpServletRequest request){
        return personalOficinaService.guardar(personalOficinaDTO,request);

    }

    @GetMapping("/listar-personal-asignado-sp")
    @Operation(description = "Listado sin paginado", summary = "Obtener listado de personal asignado a oficina y cargo")
    public ResponseEntity<ApiResponse> listarPersonalAsignadoSinPaginado(){
        return personalOficinaService.listadoSinPaginado();

    }

    @GetMapping("/listar-personal-asignado")
    @Operation(description ="", summary = "Obtener listado de personal asignado a oficina y cargo")
    public ResponseEntity<ApiResponse> listarPersonalAsignado(@RequestParam(value = "page", defaultValue = "0") int page,
                                                              @RequestParam(value = "size", defaultValue = "10") int size){
        return personalOficinaService.listado(page,size);

    }

    @GetMapping("/listar-personal-asignadoV2")
    @Operation(description ="Listado usando feignclient que consume el msc-persona", summary =  "Obtener listado de personal asignado a oficina y cargo")
    public ResponseEntity<ApiResponse> listarPersonalAsignadov2(@RequestParam(value = "page", defaultValue = "0") int page,
                                                                        @RequestParam(value = "size", defaultValue = "10") int size) throws IOException {
        return personalOficinaService.listadoV2(page,size);

    }

    @GetMapping("/personal-asignado/{id}")
    @Operation(description ="Se pasa el codigo personal para listar", summary =  "Recurso para obtener los cargos y oficinas por codigo perosna")
    public ResponseEntity<ApiResponse> listarPersonalAsignadoPorId(/*@ApiParam(value = "codigo personal")*/ @PathVariable("id") String codigo){
        return personalOficinaService.listarPersonalAsignadoPorId(codigo);

    }
}
