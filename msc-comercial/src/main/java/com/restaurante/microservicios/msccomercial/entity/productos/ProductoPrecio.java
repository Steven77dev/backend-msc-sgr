package com.restaurante.microservicios.msccomercial.entity.productos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PRODUCTO_PRECIO")
@IdClass(ProductoPrecioPK.class)
public class ProductoPrecio {
    private short entidad;
    private String producto;
    private short local;
    private BigDecimal precio;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;

    @Id
    @Column(name = "ENTIDAD", nullable = false)
    public short getEntidad() {
        return entidad;
    }

    public void setEntidad(short entidad) {
        this.entidad = entidad;
    }

    @Id
    @Column(name = "PRODUCTO", nullable = false, length = 10)
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Id
    @Column(name = "LOCAL", nullable = false)
    public short getLocal() {
        return local;
    }

    public void setLocal(short local) {
        this.local = local;
    }

    @Basic
    @Column(name = "PRECIO", nullable = false, precision = 4)
    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "ESTADO_REGISTRO", nullable = false)
    public short getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(short estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    @Basic
    @Column(name = "CREACION_SESION", nullable = false, length = 30)
    public String getCreacionSesion() {
        return creacionSesion;
    }

    public void setCreacionSesion(String creacionSesion) {
        this.creacionSesion = creacionSesion;
    }

    @Basic
    @Column(name = "CREACION_FECHA", nullable = false)
    public Timestamp getCreacionFecha() {
        return creacionFecha;
    }

    public void setCreacionFecha(Timestamp creacionFecha) {
        this.creacionFecha = creacionFecha;
    }

    @Basic
    @Column(name = "CONTROL_SESION", nullable = false, length = 30)
    public String getControlSesion() {
        return controlSesion;
    }

    public void setControlSesion(String controlSesion) {
        this.controlSesion = controlSesion;
    }

    @Basic
    @Column(name = "CONTROL_FECHA", nullable = false)
    public Timestamp getControlFecha() {
        return controlFecha;
    }

    public void setControlFecha(Timestamp controlFecha) {
        this.controlFecha = controlFecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoPrecio that = (ProductoPrecio) o;
        return entidad == that.entidad && local == that.local && estadoRegistro == that.estadoRegistro && Objects.equals(producto, that.producto) && Objects.equals(precio, that.precio) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entidad, producto, local, precio, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
