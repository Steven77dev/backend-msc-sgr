package com.restaurante.microservicios.msccomercial.entity.productos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PROD.PRODUCTO_CONTENIDO")
@IdClass(ProductoContenidoPK.class)
public class ProductoContenido {
    private short entidad;
    private String producto;
    private short itmProducto;
    private BigDecimal cantidad;
    private String detProducto;
    private boolean esObsequio;
    private String descuento;
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
    @Column(name = "ITM_PRODUCTO", nullable = false)
    public short getItmProducto() {
        return itmProducto;
    }

    public void setItmProducto(short itmProducto) {
        this.itmProducto = itmProducto;
    }

    @Basic
    @Column(name = "CANTIDAD", nullable = false, precision = 4)
    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "DET_PRODUCTO", nullable = false, length = 10)
    public String getDetProducto() {
        return detProducto;
    }

    public void setDetProducto(String detProducto) {
        this.detProducto = detProducto;
    }

    @Basic
    @Column(name = "ES_OBSEQUIO", nullable = false)
    public boolean isEsObsequio() {
        return esObsequio;
    }

    public void setEsObsequio(boolean esObsequio) {
        this.esObsequio = esObsequio;
    }

    @Basic
    @Column(name = "DESCUENTO", nullable = false, length = 4)
    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
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
        ProductoContenido that = (ProductoContenido) o;
        return entidad == that.entidad && itmProducto == that.itmProducto && esObsequio == that.esObsequio && estadoRegistro == that.estadoRegistro && Objects.equals(producto, that.producto) && Objects.equals(cantidad, that.cantidad) && Objects.equals(detProducto, that.detProducto) && Objects.equals(descuento, that.descuento) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entidad, producto, itmProducto, cantidad, detProducto, esObsequio, descuento, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
