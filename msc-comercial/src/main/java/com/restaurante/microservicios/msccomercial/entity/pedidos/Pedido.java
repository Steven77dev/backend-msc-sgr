package com.restaurante.microservicios.msccomercial.entity.pedidos;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(PedidoPK.class)
@NamedStoredProcedureQuery(
        name = "agregarProductoPedido",
        procedureName = "ATEN.SQL_PEDIDO_DET",
        parameters = {
                @StoredProcedureParameter(name = "LITIPSQL", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSSERPED", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSNROPED", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIITMPED", type = Integer.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LIENTIDA", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSPRODUC", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LNPRECIO", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LICANTID", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LNSUBTOT", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIESTADO", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINUMRES", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LSSESION", type = String.class, mode = ParameterMode.IN)
        }
)

@NamedStoredProcedureQuery(
        name = "crearPedido",
        procedureName = "ATEN.SQL_PEDIDO",
        parameters = {
                @StoredProcedureParameter(name = "LITIPSQL", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSSERPED", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LSNROPED", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LSNOMCLI", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSPERATE", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSFECING", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LNMONTOT", type = BigDecimal.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSOBSERV", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LICANPER", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LILOCALE", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIPUNATE", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIESTADO", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINUMRES", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LSSESION", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSPEDIDO", type = String.class, mode = ParameterMode.OUT),
        }
)

@NamedStoredProcedureQuery(
        name = "asignarMesaPedido",
        procedureName = "ATEN.SQL_PEDIDO_MESA",
        parameters = {
                @StoredProcedureParameter(name = "LITIPSQL", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSSERPED", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LSNROPED", type = String.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIENTIDA", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LILOCALE", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINUMESA", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LIESTADO", type = Integer.class, mode = ParameterMode.IN),
                @StoredProcedureParameter(name = "LINUMRES", type = String.class, mode = ParameterMode.OUT),
                @StoredProcedureParameter(name = "LSSESION", type = String.class, mode = ParameterMode.IN),
        }
)
public class Pedido {
    private String seriePedido;
    private String nroPedido;
    private String cliente;
    private String personalAtencion;
    private Timestamp fechaIngreso;
    private BigDecimal montoTotal;
    private String observacion;
    private String personalAnulado;
    private Short motivoAnulado;
    private Short cantidadPersonas;
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

    @Basic
    @Column(name = "CLIENTE", nullable = true, length = 250)
    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Basic
    @Column(name = "PERSONAL_ATENCION", nullable = true, length = 10)
    public String getPersonalAtencion() {
        return personalAtencion;
    }

    public void setPersonalAtencion(String personalAtencion) {
        this.personalAtencion = personalAtencion;
    }

    @Basic
    @Column(name = "FECHA_INGRESO", nullable = false)
    public Timestamp getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Timestamp fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Basic
    @Column(name = "MONTO_TOTAL", nullable = false, precision = 4)
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
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
    @Column(name = "PERSONAL_ANULADO", nullable = true, length = 10)
    public String getPersonalAnulado() {
        return personalAnulado;
    }

    public void setPersonalAnulado(String personalAnulado) {
        this.personalAnulado = personalAnulado;
    }

    @Basic
    @Column(name = "MOTIVO_ANULADO", nullable = true)
    public Short getMotivoAnulado() {
        return motivoAnulado;
    }

    public void setMotivoAnulado(Short motivoAnulado) {
        this.motivoAnulado = motivoAnulado;
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
        Pedido pedido = (Pedido) o;
        return estadoRegistro == pedido.estadoRegistro && Objects.equals(seriePedido, pedido.seriePedido) && Objects.equals(nroPedido, pedido.nroPedido) && Objects.equals(cliente, pedido.cliente) && Objects.equals(personalAtencion, pedido.personalAtencion) && Objects.equals(fechaIngreso, pedido.fechaIngreso) && Objects.equals(montoTotal, pedido.montoTotal) && Objects.equals(observacion, pedido.observacion) && Objects.equals(personalAnulado, pedido.personalAnulado) && Objects.equals(motivoAnulado, pedido.motivoAnulado) && Objects.equals(cantidadPersonas, pedido.cantidadPersonas) && Objects.equals(creacionSesion, pedido.creacionSesion) && Objects.equals(creacionFecha, pedido.creacionFecha) && Objects.equals(controlSesion, pedido.controlSesion) && Objects.equals(controlFecha, pedido.controlFecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seriePedido, nroPedido, cliente, personalAtencion, fechaIngreso, montoTotal, observacion, personalAnulado, motivoAnulado, cantidadPersonas, estadoRegistro, creacionSesion, creacionFecha, controlSesion, controlFecha);
    }
}
