package com.interconectados.sgrvbackend.api;

import com.interconectados.sgrvbackend.models.request.UsuarioRequest;
import com.interconectados.sgrvbackend.service.UsuarioServiceImpl;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/usuario")
public class ApiUsuarioController {

    private final UsuarioServiceImpl usuarioService;

    public ApiUsuarioController(UsuarioServiceImpl usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping(value = "/iniciar-sesion",produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse validarSesion(@RequestBody UsuarioRequest usuarioRequest) {
        return usuarioService.validarSesion(usuarioRequest);
    }

    @GetMapping(value = "/obtenerPersonal/{usuario}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse obtenerPersona(@PathVariable String usuario){
        return usuarioService.obtenerPersonal(usuario);
    }


}
