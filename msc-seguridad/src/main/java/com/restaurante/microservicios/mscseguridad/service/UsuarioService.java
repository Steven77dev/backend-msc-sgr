package com.restaurante.microservicios.mscseguridad.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.mscseguridad.models.request.UsuarioRequest;
import com.restaurante.microservicios.mscseguridad.models.response.SesionDTO;
import com.restaurante.microservicios.mscseguridad.repository.UsuarioRepository;
import com.restaurante.microservicios.mscseguridad.utils.UtilDate;
import com.restaurante.microservicios.mscseguridad.utils.UtilRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Service
@Transactional
public class UsuarioService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final ApiResponseBuilder<Object> responseBuilder;
    private UsuarioRepository usuarioRepository;
    ObjectMapper objectMapper;
    public UsuarioService(UsuarioRepository usuarioRepository, ApiResponseBuilder responseBuilder){
        this.usuarioRepository = usuarioRepository;
        this.responseBuilder = responseBuilder;
        this.objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        objectMapper.configure(JsonParser.Feature.IGNORE_UNDEFINED, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        objectMapper.configure(JsonParser.Feature.STRICT_DUPLICATE_DETECTION, true);
    }

    public ResponseEntity<Response<Object>> iniciarSesion(UsuarioRequest usuarioRequest, HttpServletRequest request) {
        logger.info("Validando sesión de usuario " + usuarioRequest.getUsuario());
        Map<String, Object> respuesta =  usuarioRepository.validarUsuario(1,usuarioRequest.getUsuario(),usuarioRequest.getPassword(),"",
                UtilRequest.getClientIpAddress(request),"", UtilDate.fechaActual());
        SesionDTO sesionDTO =objectMapper.convertValue(respuesta, SesionDTO.class);
        return responseBuilder.respuestaConExito(sesionDTO);
    }


}
