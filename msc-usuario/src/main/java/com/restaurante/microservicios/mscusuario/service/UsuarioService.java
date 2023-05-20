package com.restaurante.microservicios.mscusuario.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.common.response.Response;
import com.restaurante.microservicios.common.utils.Serializer;
import com.restaurante.microservicios.common.utils.UtilDate;
import com.restaurante.microservicios.common.utils.UtilRequest;
import com.restaurante.microservicios.mscusuario.models.request.UsuarioRequest;
import com.restaurante.microservicios.mscusuario.models.response.PersonalUsuarioDTO;
import com.restaurante.microservicios.mscusuario.models.response.SesionDTO;
import com.restaurante.microservicios.mscusuario.repository.UsuarioRepository;
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
    private static   ObjectMapper objectMapper = Serializer.objectMapper();
    public UsuarioService(UsuarioRepository usuarioRepository, ApiResponseBuilder<Object> responseBuilder){
        this.usuarioRepository = usuarioRepository;
        this.responseBuilder = responseBuilder;

    }

    public ResponseEntity<Response<Object>> iniciarSesion(UsuarioRequest usuarioRequest, HttpServletRequest request) {
        logger.info("Validando sesión de usuario {}", usuarioRequest.getUsuario());
        Map<String, Object> respuesta =  usuarioRepository.validarUsuario(1,usuarioRequest.getUsuario(),usuarioRequest.getPassword(),"",
                UtilRequest.getClientIpAddress(request),"", UtilDate.fechaActual());
        SesionDTO sesionDTO =objectMapper.convertValue(respuesta, SesionDTO.class);
        return responseBuilder.respuestaConExito(sesionDTO);
    }

    public ResponseEntity<Response<Object>> obtenerPersonalByUsuario(String usuario){
        logger.info("Obteniendo datos del personal de usuario {}", usuario );
        Map<String, Object> respuesta = usuarioRepository.obtenerPersonalUsuario(2, usuario,"","");
        PersonalUsuarioDTO personalUsuarioDTO = objectMapper.convertValue(respuesta, PersonalUsuarioDTO.class);
        return  responseBuilder.respuestaConExito(personalUsuarioDTO);
    }

}
