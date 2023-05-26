package com.restaurante.microservicios.msccomercial.entity.pedidos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PEDIDO_DET")
@IdClass(PedidoDetPK.class)
public class PedidoDet {
    private String seriePedido;
    private String nroPedido;
    private short itmPedido;
    private short entidad;
    private String producto;
    private BigDecimal precio;
    private int cantidad;
    private BigDecimal subTotal;
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

    @Basic
    @Column(name = "ENTIDAD", nullable = false)
    public short getEntidad() {
        return entidad;
    }

    public void setEntidad(short entidad) {
        this.entidad = entidad;
    }

    @Basic
    @Column(name = "PRODUCTO", nullable = false, length = 10)
    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
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
    @Column(name = "CANTIDAD", nullable = false)
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Basic
    @Column(name = "SUB_TOTAL", nullable = false, precision = 4)
    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
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
        PedidoDet pedidoDet = (PedidoDet) o;
        return itmPedido == pedidoDet.itmPedido && entidad == pedidoDet.entidad && cantidad == pedidoDet.cantidad && estadoRegistro == pedidoDet.estadoRegistro && Objects.equals(seriePedido, pedidoDet.seriePedido) && Objects.equals(nroPedido, pedidoDet.nroPedido) && Objects.equals(producto, pedidoDet.producto) && Objects.equals(precio, pedidoDet.precio) && Objects.equals(subTotal, pedidoDet.subTotal) && Objects.equals(creacionSesion, pedidoDet.creacionSesion) && Objects.equals(creacionFecha, pedidoDet.creacionFecha) && Objects.equals(controlSesion, pedidoDet.controlSesion) && Objects.equals(controlFecha, pedidoDet.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, itmPedido, entidad, producto, precio, cantidad, subTotal, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
