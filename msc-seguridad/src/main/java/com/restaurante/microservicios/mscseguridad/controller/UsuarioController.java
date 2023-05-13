package com.restaurante.microservicios.mscseguridad.controller;

import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.mscseguridad.models.request.UsuarioRequest;
import com.restaurante.microservicios.mscseguridad.models.response.SesionDTO;
import com.restaurante.microservicios.mscseguridad.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Tag(name = "Api-Usuario", description = "Servicios para el usuario")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @Operation(description = "Iniciar sesión", summary = "Se pasa el usuario y contraseña para loguearse",
    responses = {
            @ApiResponse(responseCode = "200",
                    description = "OK",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = SesionDTO.class))})
    })
    @PostMapping("/iniciarSesion")
    public ResponseEntity<Response<Object>> iniciarSesion(
            /*@RequestParam(value = "", required = true) @ApiIgnore @RequestHeader(value = "") Map<String,String> headers,*/
            @Valid @RequestBody() UsuarioRequest usuarioRequest, HttpServletRequest request) {
        return usuarioService.iniciarSesion(usuarioRequest, request);

    }
}
