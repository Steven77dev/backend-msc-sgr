package com.restaurante.microservicios.mscpersonal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name="entidad", catalog = "syst")
public class Entidad {
    @Id
    @Column(name = "ENTIDAD", nullable = false)
    private long entidad;
    private String descripcion;
    private String abreviatura;


}
