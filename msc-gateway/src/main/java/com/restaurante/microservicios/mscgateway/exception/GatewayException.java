package com.restaurante.microservicios.mscgateway.exception;

public class GatewayException extends RuntimeException
{

	public GatewayException(String message, Throwable cause) {
		super(message, cause);
	}
	
}