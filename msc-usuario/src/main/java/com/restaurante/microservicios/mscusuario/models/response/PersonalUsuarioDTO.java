package com.restaurante.microservicios.mscusuario.models.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonalUsuarioDTO {

    @JsonProperty("persona")
    @JsonSetter("PERSONA")
    private String persona;

    @JsonProperty("nombres")
    @JsonSetter("NOMBRES")
    private String nombres;

    @JsonProperty("entidad")
    @JsonSetter("ENTIDAD_SELECCIONADA")
    private int entidadSeleccionada;

    @JsonProperty("almacen")
    @JsonSetter("ALMACEN_SELECCIONADA")
    private int almacenSeleccionada;

    @JsonProperty("puntoAtencion")
    @JsonSetter("PATENCION_SELECCIONADA")
    private int pAtencionSeleccionada;

    @JsonProperty("local")
    @JsonSetter("LOCAL")
    private int local;

    @JsonProperty("personal")
    @JsonSetter("PERSONAL")
    private String personal;

    @JsonProperty("nombreLocal")
    @JsonSetter("DESLOCAL")
    private String desLocal;

}
