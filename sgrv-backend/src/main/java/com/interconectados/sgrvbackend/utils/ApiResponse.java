package com.interconectados.sgrvbackend.utils;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ApiResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private int codigo;
    private String mensaje;
    private Object respuesta;


    public static ApiResponse error() {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMensaje("ERROR");
       return apiResponse;
    }



}
