package com.restaurante.microservicios.msccomercial.repository;

import com.restaurante.microservicios.msccomercial.entity.pedidos.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {

    @Query(value = "{call ATEN.CON_MESAS_ATENCION(?,?,?,?,?)}", nativeQuery = true)
    List<Map<String, Object>> listadoMesas(@Param("LITIPSQL") int tipoSQL,
                                           @Param("LIENTIDA") int entidad, @Param("LILOCALE") int local,
                                           @Param("LSPARAM1") String param1, @Param("LSPARAM2") String param2);

    @Query(value = "{call ATEN.CON_PEDIDO_DET(?,?,?,?,?,?,?,?,?)}", nativeQuery = true)
    List<Map<String, Object>> listarPedidosPorMesa(@Param("LITIPSQL") int tipoSQL,
                                                   @Param("LSSERPED") String seriePedido, @Param("LSNROPED") String nroPedido,
                                                   @Param("LIITMPED") int itemPedido, @Param("LSPARAM1") String param1,
                                                   @Param("LSPARAM2") String param2, @Param("LSPARAM3") String param3,
                                                   @Param("LSPARAM4") String param4, @Param("LSPARAM5") String param5);

    @Procedure(name = "crearPedido")
    Map<String, Object> crearPedido(@Param("LITIPSQL") int tipoSQL, @Param("LSNOMCLI") String nombreCliente,
                                    @Param("LSPERATE") String personal, @Param("LSFECING") String fechaIngreso,
                                    @Param("LNMONTOT") BigDecimal montoTotal, @Param("LSOBSERV") String observacion,
                                    @Param("LICANPER") int cantPersonas, @Param("LILOCALE") int local,
                                    @Param("LIPUNATE") int puntoAtencion, @Param("LIESTADO") int estado,
                                    @Param("LSSESION") String sesion);

    @Procedure(name = "asignarMesaPedido", outputParameterName = "LINUMRES")
    String asignarMesaPedido(@Param("LITIPSQL") int tipoSQL,
                                          @Param("LSSERPED") String seriePedido, @Param("LSNROPED") String nroPedido,
                                          @Param("LIENTIDA") int entidad, @Param("LILOCALE") int local,
                                          @Param("LINUMESA") int mesa, @Param("LIESTADO") int estado,
                                          @Param("LSSESION") String sesion);

    @Procedure(name = "agregarProductoPedido")
    Map<String, Object> agregarProductoPedido(@Param("LITIPSQL") int tipoSQL,
                                              @Param("LSSERPED") String seriePedido, @Param("LSNROPED") String nroPedido,
                                              @Param("LIENTIDA") int entidad,
                                              @Param("LSPRODUC") String producto, @Param("LNPRECIO") BigDecimal precio,
                                              @Param("LICANTID") int cantidad, @Param("LNSUBTOT") BigDecimal subtotal,
                                              @Param("LIESTADO") int estado,
                                              @Param("LSSESION") String sesion);
}
