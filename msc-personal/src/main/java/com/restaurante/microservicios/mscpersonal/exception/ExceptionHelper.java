package com.restaurante.microservicios.mscpersonal.exception;

import com.restaurante.microservicios.mscpersonal.utils.ApiResponse;
import com.restaurante.microservicios.mscpersonal.utils.ApiResponseBuilder;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.net.ConnectException;


@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHelper {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    private final ApiResponseBuilder responseBuilder;

    public ExceptionHelper(ApiResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    @ExceptionHandler(value = {ConnectException.class})
    public ResponseEntity<ApiResponse<String>> handleConnectException(ConnectException ex) {
        logger.error("ConnectException: {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.errorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), "Se presentó un error al conectar con el microservicio");
        ex.printStackTrace();
        return apiResponse;
    }

    @ExceptionHandler(value = {GatewayException.class})
    public ResponseEntity<ApiResponse<String>> handleGatewayException(GatewayException ex) {
        logger.error("GatewayException: {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.errorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), "Se presentó un error al conectar con el microservicio desde gateway");
        ex.printStackTrace();
        return apiResponse;
    }


    @ExceptionHandler(value = {IOException.class})
    public ResponseEntity<ApiResponse<String>> handlDeserealizarException(IOException ex) {
        logger.error("DeserealizarException: {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Se presentó un problema al deserealizar la respuesta", null);

        return apiResponse;
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ApiResponse<String>> handleResourceNotFoundException(ResourceNotFoundException ex) {
        logger.error("ResourceNotFoundException {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse(HttpStatus.NOT_FOUND.value(), "Se presentó un error con el recurso", null);
        ex.printStackTrace();
        return apiResponse;
    }

    @ExceptionHandler(value = {ServiceException.class})
    public ResponseEntity<ApiResponse<String>> handleServicioException(ServiceException ex) {
        logger.error("ServiceException {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), "Se presentó un error en el servicio", null);
        ex.printStackTrace();
        return apiResponse;
    }

    @ExceptionHandler(value = {PersistenciaException.class})
    public ResponseEntity<ApiResponse<String>> handlerSQLSyntaxisError(PersistenciaException ex) {
        logger.error("PersistenciaException {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), "Se presentó un error en la base de datos", null);
        ex.printStackTrace();
        return apiResponse;
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<ApiResponse<String>> handlerNumberFormatException(NumberFormatException ex) {
        logger.error("NumberFormatException {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse(HttpStatus.BAD_REQUEST.value(), "Error en la conversión de dato númerico", null);
        ex.printStackTrace();
        return apiResponse;
    }


    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse<String>> handleException(Exception ex) {
        logger.error("Exception: {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.errorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Se presentó un error de excepción");
        ex.printStackTrace();
        return apiResponse;
    }


}
