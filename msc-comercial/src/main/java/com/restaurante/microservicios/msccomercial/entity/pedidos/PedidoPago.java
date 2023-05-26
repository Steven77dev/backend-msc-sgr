package com.restaurante.microservicios.msccomercial.entity.pedidos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PEDIDO_PAGO")
@IdClass(PedidoPagoPK.class)
public class PedidoPago {
    private String seriePedido;
    private String nroPedido;
    private short itmPago;
    private BigDecimal montoImporte;
    private String serieComprobante;
    private String nroComprobante;
    private Short formaPago;
    private String operacion;
    private BigDecimal montoEfectivo;
    private BigDecimal montoVuelto;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;
    private BigDecimal montoPropina;

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
    @Column(name = "ITM_PAGO", nullable = false)
    public short getItmPago() {
        return itmPago;
    }

    public void setItmPago(short itmPago) {
        this.itmPago = itmPago;
    }

    @Basic
    @Column(name = "MONTO_IMPORTE", nullable = false, precision = 4)
    public BigDecimal getMontoImporte() {
        return montoImporte;
    }

    public void setMontoImporte(BigDecimal montoImporte) {
        this.montoImporte = montoImporte;
    }

    @Basic
    @Column(name = "SERIE_COMPROBANTE", nullable = true, length = 10)
    public String getSerieComprobante() {
        return serieComprobante;
    }

    public void setSerieComprobante(String serieComprobante) {
        this.serieComprobante = serieComprobante;
    }

    @Basic
    @Column(name = "NRO_COMPROBANTE", nullable = true, length = 20)
    public String getNroComprobante() {
        return nroComprobante;
    }

    public void setNroComprobante(String nroComprobante) {
        this.nroComprobante = nroComprobante;
    }

    @Basic
    @Column(name = "FORMA_PAGO", nullable = true)
    public Short getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(Short formaPago) {
        this.formaPago = formaPago;
    }

    @Basic
    @Column(name = "OPERACION", nullable = true, length = 20)
    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    @Basic
    @Column(name = "MONTO_EFECTIVO", nullable = true, precision = 4)
    public BigDecimal getMontoEfectivo() {
        return montoEfectivo;
    }

    public void setMontoEfectivo(BigDecimal montoEfectivo) {
        this.montoEfectivo = montoEfectivo;
    }

    @Basic
    @Column(name = "MONTO_VUELTO", nullable = true, precision = 4)
    public BigDecimal getMontoVuelto() {
        return montoVuelto;
    }

    public void setMontoVuelto(BigDecimal montoVuelto) {
        this.montoVuelto = montoVuelto;
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

    @Basic
    @Column(name = "MONTO_PROPINA", nullable = true, precision = 4)
    public BigDecimal getMontoPropina() {
        return montoPropina;
    }

    public void setMontoPropina(BigDecimal montoPropina) {
        this.montoPropina = montoPropina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoPago that = (PedidoPago) o;
        return itmPago == that.itmPago && estadoRegistro == that.estadoRegistro && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido) && Objects.equals(montoImporte, that.montoImporte) && Objects.equals(serieComprobante, that.serieComprobante) && Objects.equals(nroComprobante, that.nroComprobante) && Objects.equals(formaPago, that.formaPago) && Objects.equals(operacion, that.operacion) && Objects.equals(montoEfectivo, that.montoEfectivo) && Objects.equals(montoVuelto, that.montoVuelto) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha) && Objects.equals(montoPropina, that.montoPropina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, itmPago, montoImporte, serieComprobante, nroComprobante, formaPago, operacion, montoEfectivo, montoVuelto, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha, montoPropina);
    }
}
