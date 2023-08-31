package com.interconectados.restaurante.model.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class TarjetaPK implements Serializable {
    private short entidad;
    private short tarjeta;

    @Column(name = "ENTIDAD", nullable = false)
    @Id
    public short getEntidad() {
        return entidad;
    }

    public void setEntidad(short entidad) {
        this.entidad = entidad;
    }

    @Column(name = "TARJETA", nullable = false)
    @Id
    public short getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(short tarjeta) {
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
