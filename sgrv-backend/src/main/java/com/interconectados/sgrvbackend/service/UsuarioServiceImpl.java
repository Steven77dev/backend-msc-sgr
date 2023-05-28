package com.interconectados.sgrvbackend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interconectados.sgrvbackend.Objeto;
import com.interconectados.sgrvbackend.models.request.UsuarioRequest;
import com.interconectados.sgrvbackend.models.response.PersonalUsuarioResponse;
import com.interconectados.sgrvbackend.models.response.SesionResponse;
import com.interconectados.sgrvbackend.utils.ApiResponse;
import com.interconectados.sgrvbackend.utils.ConvertirApiResponse;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl  {

    private final UsuarioService usuarioService;
    private final Redis redis;
    private static ObjectMapper objectMapper = Serializer.objectMapper();
    public UsuarioServiceImpl(UsuarioService usuarioService, Redis redis) {
        this.usuarioService = usuarioService;
        this.redis = redis;
    }

    public ApiResponse validarSesion(UsuarioRequest usuarioRequest) {

        if(Objeto.anyEmpty(usuarioRequest.getUsuario(), usuarioRequest.getPassword())){
            return ApiResponse.parametrosIncorrectos();
        }

        Response response=  usuarioService.validarSesion(usuarioRequest).getBody();
        SesionResponse sesionResponse = objectMapper.convertValue(response.getRespuesta(), SesionResponse.class);
        redis.setSession(sesionResponse.getSesion());
        redis.setUsuario(usuarioRequest.getUsuario());
        if (response.hayError()) {
            return ApiResponse.error();
        } else {
            return ConvertirApiResponse.exito(response);
        }
    }

    public ApiResponse obtenerPersonal(String usuario){
        if(Objeto.anyEmpty(usuario)){
            return ApiResponse.error();
        }

        Response response = usuarioService.obtenerPersonal(usuario).getBody();
        PersonalUsuarioResponse personalUsuario = objectMapper.convertValue(response.getRespuesta(), PersonalUsuarioResponse.class);
        redis.setCodPersonal(personalUsuario.getPersonal());
        redis.setCodPersona(personalUsuario.getPersona());
        redis.setCodEntidad(Integer.toString(personalUsuario.getEntidad()));
        redis.setCodAlmacen(Integer.toString(personalUsuario.getAlmacen()));
        redis.setCodPtoAtencion(Integer.toString(personalUsuario.getPuntoAtencion()));
        redis.setCodLocal( Integer.toString(personalUsuario.getLocal()));
        redis.guardarDato("nombres", personalUsuario.getNombres());
        redis.guardarDato("nombreLocal", personalUsuario.getNombreLocal());
        if(response.hayError()){
            return ApiResponse.error();
        } else{
            return ConvertirApiResponse.exito(response);
        }
    }
}
