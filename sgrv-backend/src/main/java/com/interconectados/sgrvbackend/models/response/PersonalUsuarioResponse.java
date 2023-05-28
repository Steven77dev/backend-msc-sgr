package com.interconectados.sgrvbackend.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
@EqualsAndHashCode
public class PersonalUsuarioResponse {

    private String persona;
    private String nombres;
    private int entidad;
    private int almacen;
    private int puntoAtencion;
    private int local;
    private String personal;
    private String nombreLocal;

}
