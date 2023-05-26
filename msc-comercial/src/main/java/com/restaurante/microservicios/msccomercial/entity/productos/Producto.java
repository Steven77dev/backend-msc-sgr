package com.restaurante.microservicios.msccomercial.entity.productos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PROD.PRODUCTO")
@IdClass(ProductoPK.class)
public class Producto {
    private short entidad;
    private String producto;
    private String descripcion;
    private String abreviatura;
    private short tipoProducto;
    private String linea;
    private String marca;
    private String familia;
    private short tipoPresentacion;
    private BigDecimal nroMedida;
    private short unidadMedida;
    private Long idImagen;
    private boolean esPaquete;
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
    @Column(name = "DESCRIPCION", nullable = false, length = 100)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ABREVIATURA", nullable = true, length = 20)
    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    @Basic
    @Column(name = "TIPO_PRODUCTO", nullable = false)
    public short getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(short tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Basic
    @Column(name = "LINEA", nullable = false, length = 2)
    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    @Basic
    @Column(name = "MARCA", nullable = false, length = 3)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "FAMILIA", nullable = false, length = 4)
    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    @Basic
    @Column(name = "TIPO_PRESENTACION", nullable = false)
    public short getTipoPresentacion() {
        return tipoPresentacion;
    }

    public void setTipoPresentacion(short tipoPresentacion) {
        this.tipoPresentacion = tipoPresentacion;
    }

    @Basic
    @Column(name = "NRO_MEDIDA", nullable = false, precision = 4)
    public BigDecimal getNroMedida() {
        return nroMedida;
    }

    public void setNroMedida(BigDecimal nroMedida) {
        this.nroMedida = nroMedida;
    }

    @Basic
    @Column(name = "UNIDAD_MEDIDA", nullable = false)
    public short getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(short unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    @Basic
    @Column(name = "ID_IMAGEN", nullable = true)
    public Long getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Long idImagen) {
        this.idImagen = idImagen;
    }

    @Basic
    @Column(name = "ES_PAQUETE", nullable = false)
    public boolean isEsPaquete() {
        return esPaquete;
    }

    public void setEsPaquete(boolean esPaquete) {
        this.esPaquete = esPaquete;
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
        Producto producto1 = (Producto) o;
        return entidad == producto1.entidad && tipoProducto == producto1.tipoProducto && tipoPresentacion == producto1.tipoPresentacion && unidadMedida == producto1.unidadMedida && esPaquete == producto1.esPaquete && estadoRegistro == producto1.estadoRegistro && Objects.equals(producto, producto1.producto) && Objects.equals(descripcion, producto1.descripcion) && Objects.equals(abreviatura, producto1.abreviatura) && Objects.equals(linea, producto1.linea) && Objects.equals(marca, producto1.marca) && Objects.equals(familia, producto1.familia) && Objects.equals(nroMedida, producto1.nroMedida) && Objects.equals(idImagen, producto1.idImagen) && Objects.equals(creacionSesion, producto1.creacionSesion) && Objects.equals(creacionFecha, producto1.creacionFecha) && Objects.equals(controlSesion, producto1.controlSesion) && Objects.equals(controlFecha, producto1.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entidad, producto, descripcion, abreviatura, tipoProducto, linea, marca, familia, tipoPresentacion, nroMedida, unidadMedida, idImagen, esPaquete, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
