package com.restaurante.microservicios.mscpersonal.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurante.microservicios.common.response.ApiResponse;
import com.restaurante.microservicios.common.response.ApiResponseBuilder;
import com.restaurante.microservicios.mscpersonal.dto.PersonalAsignadoDTO;
import com.restaurante.microservicios.mscpersonal.dto.RegistrarPersonalOficinaDTO;
import com.restaurante.microservicios.mscpersonal.entity.Persona;
import com.restaurante.microservicios.mscpersonal.entity.Personal;
import com.restaurante.microservicios.mscpersonal.entity.PersonalOficina;
import com.restaurante.microservicios.mscpersonal.entity.PersonalOficinav2;
import com.restaurante.microservicios.mscpersonal.feignclients.PersonaFeignClient;
import com.restaurante.microservicios.mscpersonal.mapper.PersonalMapper;
import com.restaurante.microservicios.mscpersonal.mapper.PersonalOficinaMapper;
import com.restaurante.microservicios.mscpersonal.repository.PersonalOficinaRepository;
import com.restaurante.microservicios.mscpersonal.repository.PersonalOficinaRepositoryv2;
import com.restaurante.microservicios.mscpersonal.repository.PersonalRepository;
import com.restaurante.microservicios.mscpersonal.service.models.PersonaModel;
import com.restaurante.microservicios.mscpersonal.utils.Constante;
import com.restaurante.microservicios.mscpersonal.utils.UtilRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonalOficinaService {
    private PersonalOficinaRepository personalOficinaRepository;
    @Autowired
    private PersonalOficinaRepositoryv2 personalOficinaRepositoryv2;
    private PersonalRepository personalRepository;
    private final ApiResponseBuilder<Object> responseBuilder;

    @Autowired
    private RestTemplate restTemplate;

    private final PersonalOficinaMapper personalOficinaMapper;
    @Autowired
    private final PersonalMapper personalMapper;

    @Autowired
    private PersonaFeignClient personaFeignClient;

    public PersonalOficinaService(PersonalOficinaRepository personalOficinaRepository, ApiResponseBuilder<Object> responseBuilder, PersonalOficinaMapper personalOficinaMapper,
                                  PersonalMapper personalMapper, PersonalRepository personalRepository) {
        this.personalOficinaRepository = personalOficinaRepository;
        this.personalRepository = personalRepository;
        this.responseBuilder = responseBuilder;
        this.personalOficinaMapper = personalOficinaMapper;
        this.personalMapper = personalMapper;
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<Object>> listado(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PersonalOficina> paginado = personalOficinaRepository.findPersonalOficinaBy(pageable);
        List<PersonalAsignadoDTO> personalDto = paginado.map(personalOficinaMapper::toDto).getContent();
        return personalDto.isEmpty() ? responseBuilder.respuestaSinResultado(null) : responseBuilder.exito(personalDto, paginado);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<Object>> listadoSinPaginado() {
        List<PersonalOficina> listado = personalOficinaRepository.findAll();

        List<PersonalAsignadoDTO> personalDto = listado.stream().map(personalOficinaMapper::toDto).collect(Collectors.toList());
        return personalDto.isEmpty() ? responseBuilder.respuestaSinResultado(null) : responseBuilder.respuestaConExito(personalDto);
    }


    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<Object>> listadoV2(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PersonalOficinav2> paginado = personalOficinaRepositoryv2.findPersonalOficinaBy(pageable);
        List<PersonalAsignadoDTO> personalDto = paginado.map(personalOficinaMapper::toDto).getContent();
        for (PersonalAsignadoDTO dto : personalDto) {
            if (dto.getCodigoEstado() == 1) {
                //System.out.println(obtenerDatosPersonaRestTemplate(personalOfina.getPersonal().getPersona()).toString());
                PersonaModel persona = obtenerDatosPersonaFeign(dto.getCodigoPersona());
                if (persona != null) {
                    dto.setNombres(persona.getNombres());
                    dto.setApellidoPaterno(persona.getApellidoPaterno());
                    dto.setApellidoMaterno(persona.getApellidoMaterno());
                }

            }
        }
        return personalDto.isEmpty() ? responseBuilder.respuestaSinResultado(null) : responseBuilder.exito(personalDto, paginado);
    }

    private Persona obtenerDatosPersonaRestTemplate(String idPersona) {
        return restTemplate.getForObject("http://localhost:8091/persona/" + idPersona, Persona.class);
    }

    private PersonaModel obtenerDatosPersonaFeign(String idPersona) {
        ApiResponse<Object> apiResponse = personaFeignClient.obtenerPorId(idPersona).getBody();
        if (!apiResponse.hayError())
            return deserealizarRespuesta(apiResponse.getRespuesta(), new PersonaModel());
        return new PersonaModel();
    }


    private PersonaModel deserealizarRespuesta(Object respuestaApiResponse, PersonaModel p) {
        // Crear un objeto ObjectMapper para deserializar la respuesta
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(respuestaApiResponse, p.getClass());
    }


    public ResponseEntity<ApiResponse<Object>> guardar(RegistrarPersonalOficinaDTO dto, HttpServletRequest request) {
        Personal personal = personalMapper.toEntity(dto.getRegistrarPersonalDTO());
        personal = personalRepository.save(personal);
        if (personal.getPersonal() == null) {
            return responseBuilder.respuestaConError(Constante.ESTADO_ERROR);
        } else {
            PersonalOficina personalOficina = personalOficinaMapper.toEntity(dto);
            personal.setCreacionSesion(UtilRequest.getClientIpAddress(request));
            PersonalOficina nuevo = personalOficinaRepository.save(personalOficina);
            if (nuevo.getPersonal() != null)
                return responseBuilder.respuestaConExito("0");
            else
                return responseBuilder.respuestaConError(Constante.ESTADO_ERROR);
        }

    }

    @Transactional(readOnly = true)
    public ResponseEntity<ApiResponse<Object>> listarPersonalAsignadoPorId(String codigo) {
        List<PersonalOficina> personalOficinas = personalOficinaRepository.findByCodigoPersonal(codigo);
        List<PersonalAsignadoDTO> listado = personalOficinas.stream().map(personalOficinaMapper::toDto).collect(Collectors.toList());
        if (personalOficinas.isEmpty()) return responseBuilder.respuestaSinResultado(null);
        return responseBuilder.respuestaConExito(listado);
    }
}
