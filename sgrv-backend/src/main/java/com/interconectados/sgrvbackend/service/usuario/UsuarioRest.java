package com.interconectados.sgrvbackend.service.usuario;

import com.interconectados.sgrvbackend.models.request.UsuarioRequest;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "msc-usuario", url = "http://localhost:8080")
public interface UsuarioRest {

    @PostMapping("/usuario/iniciarSesion")
    ResponseEntity<Response<Object>> validarSesion(@RequestBody UsuarioRequest usuarioRequest);

    @GetMapping("/usuario/obtenerPersonal/{usuario}")
    ResponseEntity<Response<Object>> obtenerPersonal(@PathVariable String usuario);
}
