package com.restaurante.microservicios.msccomercial.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "PEDIDO_RESERVA")
@IdClass(PedidoReservaPK.class)
public class PedidoReserva {
    private String seriePedido;
    private String nroPedido;
    private Short tipoReserva;
    private Short medioReserva;
    private String personalReserva;
    private Short entidad;
    private String cliente;
    private Short itmEntrega;
    private Timestamp fechaDesde;
    private Timestamp fechaHasta;
    private Short localReserva;
    private Short cantidadPersonas;
    private String observacion;
    private short estadoRegistro;
    private String creacionSesion;
    private Timestamp creacionFecha;
    private String controlSesion;
    private Timestamp controlFecha;
    private Short turnoReserva;

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

    @Basic
    @Column(name = "TIPO_RESERVA", nullable = true)
    public Short getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(Short tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    @Basic
    @Column(name = "MEDIO_RESERVA", nullable = true)
    public Short getMedioReserva() {
        return medioReserva;
    }

    public void setMedioReserva(Short medioReserva) {
        this.medioReserva = medioReserva;
    }

    @Basic
    @Column(name = "PERSONAL_RESERVA", nullable = true, length = 10)
    public String getPersonalReserva() {
        return personalReserva;
    }

    public void setPersonalReserva(String personalReserva) {
        this.personalReserva = personalReserva;
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
    @Column(name = "CLIENTE", nullable = true, length = 10)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Basic
    @Column(name = "ITM_ENTREGA", nullable = true)
    public Short getItmEntrega() {
        return itmEntrega;
    }

    public void setItmEntrega(Short itmEntrega) {
        this.itmEntrega = itmEntrega;
    }

    @Basic
    @Column(name = "FECHA_DESDE", nullable = true)
    public Timestamp getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Timestamp fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    @Basic
    @Column(name = "FECHA_HASTA", nullable = true)
    public Timestamp getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Timestamp fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Basic
    @Column(name = "LOCAL_RESERVA", nullable = true)
    public Short getLocalReserva() {
        return localReserva;
    }

    public void setLocalReserva(Short localReserva) {
        this.localReserva = localReserva;
    }

    @Basic
    @Column(name = "CANTIDAD_PERSONAS", nullable = true)
    public Short getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(Short cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    @Basic
    @Column(name = "OBSERVACION", nullable = true, length = 300)
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
    @Column(name = "TURNO_RESERVA", nullable = true)
    public Short getTurnoReserva() {
        return turnoReserva;
    }

    public void setTurnoReserva(Short turnoReserva) {
        this.turnoReserva = turnoReserva;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoReserva that = (PedidoReserva) o;
        return estadoRegistro == that.estadoRegistro && Objects.equals(seriePedido, that.seriePedido) && Objects.equals(nroPedido, that.nroPedido) && Objects.equals(tipoReserva, that.tipoReserva) && Objects.equals(medioReserva, that.medioReserva) && Objects.equals(personalReserva, that.personalReserva) && Objects.equals(entidad, that.entidad) && Objects.equals(cliente, that.cliente) && Objects.equals(itmEntrega, that.itmEntrega) && Objects.equals(fechaDesde, that.fechaDesde) && Objects.equals(fechaHasta, that.fechaHasta) && Objects.equals(localReserva, that.localReserva) && Objects.equals(cantidadPersonas, that.cantidadPersonas) && Objects.equals(observacion, that.observacion) && Objects.equals(creacionSesion, that.creacionSesion) && Objects.equals(creacionFecha, that.creacionFecha) && Objects.equals(controlSesion, that.controlSesion) && Objects.equals(controlFecha, that.controlFecha) && Objects.equals(turnoReserva, that.turnoReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, tipoReserva, medioReserva, personalReserva, entidad, cliente, itmEntrega, fechaDesde, fechaHasta, localReserva, cantidadPersonas, observacion, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha, turnoReserva);
    }
}
