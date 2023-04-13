package com.restaurante.microservicios.common.exception;

public class GatewayException extends RuntimeException {

    public GatewayException(String message, Throwable cause) {
        super(message, cause);
    }

}