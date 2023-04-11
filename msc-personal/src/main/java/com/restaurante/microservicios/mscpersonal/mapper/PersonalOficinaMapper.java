package com.restaurante.microservicios.mscpersonal.mapper;

import com.restaurante.microservicios.mscpersonal.dto.PersonalAsignadoDTO;
import com.restaurante.microservicios.mscpersonal.dto.RegistrarPersonalOficinaDTO;
import com.restaurante.microservicios.mscpersonal.entity.PersonalOficina;
import com.restaurante.microservicios.mscpersonal.entity.PersonalOficinav2;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PersonalOficinaMapper {

    @Mappings({
            @Mapping(source = "personal.personal", target = "codigoPersonal"),
            @Mapping(source = "entidad.entidad", target = "codigoEntidad"),
            @Mapping(source = "personal.persona.persona", target = "codigoPersona"),
            @Mapping ( target = "nombres", expression = "java(personalOficina.getPersonal().getPersona().getNombres() + \" \" + personalOficina.getPersonal().getPersona().getApellidoPaterno()+ \" \" + personalOficina.getPersonal().getPersona().getApellidoMaterno())"),
            @Mapping(source = "entidad.descripcion", target = "desEntidad"),
            @Mapping(source = "oficina.descripcion", target = "desOficina"),
            @Mapping(source = "cargo.descripcion", target = "desCargo"),
            @Mapping(source = "estado.descripcion", target = "desEstado"),
            @Mapping(source = "oficina.oficina", target = "codigoOficina"),
            @Mapping(source = "cargo.cargo", target = "codigoCargo"),
            @Mapping(source = "estado.estadoRegistro", target = "codigoEstado"),

    })
    PersonalAsignadoDTO toDto(PersonalOficina personalOficina);

    @Mappings({
            @Mapping(source = "codigoPersonal", target = "personal.personal"),
            @Mapping(source = "codigoOficina", target = "oficina.oficina"),
            @Mapping(source = "codigoCargo", target = "cargo.cargo"),
            @Mapping(source = "codigoEntidad", target = "entidad.entidad"),
            @Mapping(source = "codigoEstado", target = "estado.estadoRegistro"),
            @Mapping(source = "creacionSesion", target = "creacionSesion"),
            @Mapping(source = "creacionFecha", target = "creacionFecha"),

    })
    PersonalOficina toEntity(RegistrarPersonalOficinaDTO customerDto);

    @Mappings({
            @Mapping(source = "personal.personal", target = "codigoPersonal"),
            @Mapping(source = "entidad.entidad", target = "codigoEntidad"),
           @Mapping(source = "personal.persona", target = "codigoPersona"),
            @Mapping(source = "entidad.descripcion", target = "desEntidad"),
            @Mapping(source = "oficina.descripcion", target = "desOficina"),
            @Mapping(source = "cargo.descripcion", target = "desCargo"),
            @Mapping(source = "estado.descripcion", target = "desEstado"),
            @Mapping(source = "oficina.oficina", target = "codigoOficina"),
            @Mapping(source = "cargo.cargo", target = "codigoCargo"),
            @Mapping(source = "estado.estadoRegistro", target = "codigoEstado"),

    })
    PersonalAsignadoDTO toDto(PersonalOficinav2 personalOficina);



}