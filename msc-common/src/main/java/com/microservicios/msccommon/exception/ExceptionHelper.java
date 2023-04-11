package com.microservicios.msccommon.exception;

import com.microservicios.msccommon.response.ApiResponse;
import com.microservicios.msccommon.response.ResponseBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHelper {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHelper.class);

    private final ResponseBuilder responseBuilder;

    public ExceptionHelper(ResponseBuilder responseBuilder) {
        this.responseBuilder = responseBuilder;
    }

    @ExceptionHandler(value = {ResourceNotFoundException.class})
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        logger.error("ResourceNotFoundException {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse( HttpStatus.NOT_FOUND.value(),"Se presentó un error con el recurso",null);
        ex.printStackTrace();
        return apiResponse;
    }

    /*@ExceptionHandler(value = {ServiceException.class})
    public ResponseEntity<ApiResponse> handleServicioException(ServiceException ex) {
        logger.error("ServiceException {}", ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse( HttpStatus.BAD_REQUEST.value(),"Se presentó un error en el servicio",null);
        ex.printStackTrace();
        return apiResponse;
    }*/

    @ExceptionHandler(value = {PersistenciaException.class})
    public ResponseEntity<ApiResponse> handlerSQLSyntaxisError(PersistenciaException ex) {
        logger.error("PersistenciaException {}" , ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse( HttpStatus.BAD_REQUEST.value(),"Se presentó un error en la base de datos",null);
        ex.printStackTrace();
        return apiResponse;
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    public ResponseEntity<ApiResponse> handlerNumberFormatException(NumberFormatException ex) {
        logger.error("NumberFormatException {}" , ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse( HttpStatus.BAD_REQUEST.value(),"Error en la conversión de dato númerico",null);
        ex.printStackTrace();
        return apiResponse;
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResponse> handleException(Exception ex) {
        logger.error("Exception: {}" , ex.getMessage());
        ResponseEntity apiResponse = responseBuilder.buildResponse( HttpStatus.INTERNAL_SERVER_ERROR.value(),"Se presentó un error de excepción",null);
        //ex.printStackTrace();
        return apiResponse;
    }



}
