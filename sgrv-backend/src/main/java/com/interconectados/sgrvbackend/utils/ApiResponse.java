package com.interconectados.sgrvbackend.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ApiResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String mensaje;

    private Object respuesta;

    public ApiResponse() {
       this.setCodigo(0);
    }

    public static ApiResponse error() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMensaje("ERROR");
       return apiResponse;
    }

    public static ApiResponse exito(String mensaje,Object respuesta) {
        ApiResponse response = new ApiResponse();
        response.setMensaje(mensaje);
        response.setRespuesta(respuesta);
        return response;
    }

    public static ApiResponse parametrosIncorrectos() {
        ApiResponse response = new ApiResponse();
        response.setCodigo(-1);
        response.setMensaje("PARAMETROS_INCORRECTOS");
        return  response;
    }

}
