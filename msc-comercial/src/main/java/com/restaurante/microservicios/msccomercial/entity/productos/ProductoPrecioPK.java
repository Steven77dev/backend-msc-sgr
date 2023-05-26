package com.restaurante.microservicios.msccomercial.entity.productos;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductoPrecioPK implements Serializable {
    private short entidad;
    private String producto;
    private short local;

    @Column(name = "ENTIDAD", nullable = false)
    @Id
    public short getEntidad() {
        return entidad;
    }

    public void setEntidad(short entidad) {
        this.entidad = entidad;
    }

    @Column(name = "PRODUCTO", nullable = false, length = 10)
    @Id
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Column(name = "LOCAL", nullable = false)
    @Id
    public short getLocal() {
        return local;
    }

    public void setLocal(short local) {
        this.local = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoPrecioPK that = (ProductoPrecioPK) o;
        return entidad == that.entidad && local == that.local && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entidad, producto, local);
    }
}
