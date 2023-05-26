package com.restaurante.microservicios.msccomercial.entity.pedidos;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PEDIDO_DET_CONTENIDO")
@IdClass(PedidoDetContenidoPK.class)
public class PedidoDetContenido {
    private String seriePedido;
    private String nroPedido;
    private short itmPedido;
    private short itmContenido;
    private Short entidad;
    private String producto;
    private String serieBono;
    private String nroBono;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;

    @Id
    @Column(name = "SERIE_PEDIDO", nullable = false, length = 10)
    public String getSeriePedido() {
        return seriePedido;
    }

    public void setSeriePedido(String seriePedido) {
        this.seriePedido = seriePedido;
    }

    @Id
    @Column(name = "NRO_PEDIDO", nullable = false, length = 20)
    public String getNroPedido() {
        return nroPedido;
    }

    public void setNroPedido(String nroPedido) {
        this.nroPedido = nroPedido;
    }

    @Id
    @Column(name = "ITM_PEDIDO", nullable = false)
    public short getItmPedido() {
        return itmPedido;
    }

    public void setItmPedido(short itmPedido) {
        this.itmPedido = itmPedido;
    }

    @Id
    @Column(name = "ITM_CONTENIDO", nullable = false)
    public short getItmContenido() {
        return itmContenido;
    }

    public void setItmContenido(short itmContenido) {
        this.itmContenido = itmContenido;
    }

    @Basic
    @Column(name = "ENTIDAD", nullable = true)
    public Short getEntidad() {
        return entidad;
    }

    public void setEntidad(Short entidad) {
        this.entidad = entidad;
    }

    @Basic
    @Column(name = "PRODUCTO", nullable = true, length = 10)
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    @Basic
    @Column(name = "SERIE_BONO", nullable = true, length = 10)
    public String getSerieBono() {
        return serieBono;
    }

    public void setSerieBono(String serieBono) {
        this.serieBono = serieBono;
    }

    @Basic
    @Column(name = "NRO_BONO", nullable = true, length = 20)
    public String getNroBono() {
        return nroBono;
    }

    public void setNroBono(String nroBono) {
        this.nroBono = nroBono;
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
        PedidoDetContenido that = (PedidoDetContenido) o;
        return itmPedido == that.itmPedido && itmContenido == that.itmContenido && estadoRegistro == that.estadoRegistro && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido) && Objects.equals(entidad, that.entidad) && Objects.equals(producto, that.producto) && Objects.equals(serieBono, that.serieBono) && Objects.equals(nroBono, that.nroBono) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, itmPedido, itmContenido, entidad, producto, serieBono, nroBono, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
