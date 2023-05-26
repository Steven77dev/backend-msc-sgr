package com.restaurante.microservicios.msccomercial.entity.productos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PROD.PRODUCTO_DETALLE")
@IdClass(ProductoDetallePK.class)
public class ProductoDetalle {
    private short entidad;
    private String producto;
    private BigDecimal pesoCapacidad;
    private BigDecimal pesoBruto;
    private int equivalencia;
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

    @Basic
    @Column(name = "PESO_CAPACIDAD", nullable = false, precision = 4)
    public BigDecimal getPesoCapacidad() {
        return pesoCapacidad;
    }

    public void setPesoCapacidad(BigDecimal pesoCapacidad) {
        this.pesoCapacidad = pesoCapacidad;
    }

    @Basic
    @Column(name = "PESO_BRUTO", nullable = false, precision = 4)
    public BigDecimal getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(BigDecimal pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

    @Basic
    @Column(name = "EQUIVALENCIA", nullable = false)
    public int getEquivalencia() {
        return equivalencia;
    }

    public void setEquivalencia(int equivalencia) {
        this.equivalencia = equivalencia;
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
        ProductoDetalle that = (ProductoDetalle) o;
        return entidad == that.entidad && equivalencia == that.equivalencia && estadoRegistro == that.estadoRegistro && Objects.equals(producto, that.producto) && Objects.equals(pesoCapacidad, that.pesoCapacidad) && Objects.equals(pesoBruto, that.pesoBruto) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entidad, producto, pesoCapacidad, pesoBruto, equivalencia, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
