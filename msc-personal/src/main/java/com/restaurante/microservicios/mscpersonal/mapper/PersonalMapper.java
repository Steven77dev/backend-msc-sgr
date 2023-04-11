package com.restaurante.microservicios.mscpersonal.mapper;

import com.restaurante.microservicios.mscpersonal.dto.RegistrarPersonalDTO;
import com.restaurante.microservicios.mscpersonal.entity.Personal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PersonalMapper {

    @Mappings({
            @Mapping(source = "codigoPersonal", target = "personal"),
            @Mapping(source = "codigoPersona", target = "persona.persona"),
            @Mapping(source = "codigoEstado", target = "estadoRegistro"),
            @Mapping(source = "creacionFecha", target = "creacionFecha"),
            @Mapping(source = "creacionSesion", target = "creacionSesion"),

    })
    Personal toEntity(RegistrarPersonalDTO dto);

}