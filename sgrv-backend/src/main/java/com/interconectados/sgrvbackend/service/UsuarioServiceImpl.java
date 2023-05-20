package com.interconectados.sgrvbackend.service;

import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.UsuarioRequest;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl  {

    private final UsuarioService usuarioService;

    public UsuarioServiceImpl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ApiResponse validarSesion(UsuarioRequest usuarioRequest) {

        if(Objeto.anyEmpty(usuarioRequest.getUsuario(), usuarioRequest.getPassword())){
            return ApiResponse.parametrosIncorrectos();
        }

        Response responseEntity=  usuarioService.validarSesion(usuarioRequest).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(responseEntity);
        }
    }

    public ApiResponse obtenerPersonal(String usuario){
        if(Objeto.anyEmpty(usuario)){
            return ApiResponse.error();
        }

        Response response = usuarioService.obtenerPersonal(usuario).getBody();
        if(response.hayError()){
            return ApiResponse.error();
        } else{
            return ConvertirApiResponse.exito(response);
        }
    }
}
