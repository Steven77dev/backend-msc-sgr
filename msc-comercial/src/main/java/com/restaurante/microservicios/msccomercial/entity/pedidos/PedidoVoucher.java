package com.restaurante.microservicios.msccomercial.entity.pedidos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PEDIDO_VOUCHER")
@IdClass(PedidoVoucherPK.class)
public class PedidoVoucher {
    private String seriePedido;
    private String nroPedido;
    private short itmVoucher;
    private String nroOperacion;
    private Timestamp fechaOperacion;
    private short banco;
    private BigDecimal importe;
    private String referencia;
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
    @Column(name = "ITM_VOUCHER", nullable = false)
    public short getItmVoucher() {
        return itmVoucher;
    }

    public void setItmVoucher(short itmVoucher) {
        this.itmVoucher = itmVoucher;
    }

    @Basic
    @Column(name = "NRO_OPERACION", nullable = false, length = 100)
    public String getNroOperacion() {
        return nroOperacion;
    }

    public void setNroOperacion(String nroOperacion) {
        this.nroOperacion = nroOperacion;
    }

    @Basic
    @Column(name = "FECHA_OPERACION", nullable = false)
    public Timestamp getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Timestamp fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    @Basic
    @Column(name = "BANCO", nullable = false)
    public short getBanco() {
        return banco;
    }

    public void setBanco(short banco) {
        this.banco = banco;
    }

    @Basic
    @Column(name = "IMPORTE", nullable = false, precision = 4)
    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    @Basic
    @Column(name = "REFERENCIA", nullable = true, length = 100)
    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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
        PedidoVoucher that = (PedidoVoucher) o;
        return itmVoucher == that.itmVoucher && banco == that.banco && estadoRegistro == that.estadoRegistro && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido) && Objects.equals(nroOperacion, that.nroOperacion) && Objects.equals(fechaOperacion, that.fechaOperacion) && Objects.equals(importe, that.importe) && Objects.equals(referencia, that.referencia) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, itmVoucher, nroOperacion, fechaOperacion, banco, importe, referencia, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
