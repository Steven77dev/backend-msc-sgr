package com.restaurante.microservicios.mscusuario.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.mscusuario.models.request.BusqCajaPorUsuarioRequest;
import com.restaurante.microservicios.mscusuario.models.request.UsuarioRequest;
import com.restaurante.microservicios.mscusuario.models.response.SesionResponse;
import com.restaurante.microservicios.mscusuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Tag(name = "Api-Usuario", description = "Servicios para el usuario")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Operation(description = "Iniciar sesión", summary = "Se pasa el usuario y contraseña para loguearse",
    responses = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SesionResponse.class))})
    })
    @PostMapping("/iniciarSesion")
    public ResponseEntity<Response<Object>> iniciarSesion(
            @Valid @RequestBody() UsuarioRequest usuarioRequest, HttpServletRequest request) {
        return usuarioService.iniciarSesion(usuarioRequest, request);

    }


    @GetMapping("/obtenerPersonal/{codigoUsuario}")
    public ResponseEntity<Response<Object>> obtenerPersonalPorUsuario(@PathVariable String codigoUsuario ){
        return usuarioService.obtenerPersonalPorUsuario(codigoUsuario);

    }

    @PostMapping("/obtenerCaja")
    public ResponseEntity<Response<Object>> obtenerCaja(@RequestBody BusqCajaPorUsuarioRequest request){
        return usuarioService.obtenerCajaDefectoPorUsuario(request);

    }
}
