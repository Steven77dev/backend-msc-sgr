package com.interconectados.sgrvbackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interconectados.sgrvbackend.Respuesta;
import com.interconectados.sgrvbackend.models.request.UsuarioRequest;
import com.interconectados.sgrvbackend.models.response.SesionDTO;
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

        Response responseEntity=  usuarioService.validarSesion(usuarioRequest).getBody();
        if (responseEntity.hayError()) {
            return ApiResponse.error();
        } else {
            ApiResponse respuesta = ConvertirApiResponse.convertirApiResponse(responseEntity);
            return respuesta;
        }

    }

    private SesionDTO deserealizarRespuesta(Object respuestaApiResponse, SesionDTO p) {
        // Crear un objeto ObjectMapper para deserializar la respuesta
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(respuestaApiResponse, p.getClass());
    }
}
