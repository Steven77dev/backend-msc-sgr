package com.restaurante.microservicios.msccatalogo.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TarjetaPK implements Serializable {
    private int entidad;
    private int tarjeta;

    @Column(name = "ENTIDAD", nullable = false)
    @Id
    public int getEntidad() {
        return entidad;
    }

    public void setEntidad(int entidad) {
        this.entidad = entidad;
    }

    @Column(name = "TARJETA", nullable = false)
    @Id
    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TarjetaPK tarjetaPK = (TarjetaPK) o;
        return entidad == tarjetaPK.entidad && tarjeta == tarjetaPK.tarjeta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(entidad, tarjeta);
    }
}
