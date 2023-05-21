package com.restaurante.microservicios.mscfinanzas.repository;

import com.restaurante.microservicios.mscfinanzas.entity.IngresoDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IngresoDiarioRepository extends JpaRepository<IngresoDiario,String> {
    @Query(value = "{call FINA.CON_INGRESO_DIARIO(?,?,?,?,?,?,?,?)}", nativeQuery = true)
    List<Map<String, Object>> ingresosVsEgresos(@Param("LITIPSQL") int tipoSQL,
                                                @Param("LSSERIDI") String serieId, @Param("LSNROIDI") String nroSerie,
                                                @Param("LSPARAM1") String param1, @Param("LSPARAM2") String param2,
                                                @Param("LSPARAM3") String param3, @Param("LSPARAM4") String param4,
                                                @Param("LSPARAM5") String param5);

    @Query(value = "{call FINA.CON_INGRESO_DIARIO(?,?,?,?,?,?,?,?)}", nativeQuery = true)
    Map<String, Object> datosAperturaCierre(@Param("LITIPSQL") int tipoSQL,
                                            @Param("LSSERIDI") String serieId, @Param("LSNROIDI") String nroSerie,
                                            @Param("LSPARAM1") String param1, @Param("LSPARAM2") String param2,
                                            @Param("LSPARAM3") String param3, @Param("LSPARAM4") String param4,
                                            @Param("LSPARAM5") String param5);

    @Query(value = "{call FINA.CON_INGRESO_DIARIO(?,?,?,?,?,?,?,?)}", nativeQuery = true)
    List<Map<String, Object>> resumenIngresoPersonal(@Param("LITIPSQL") int tipoSQL,
                                                     @Param("LSSERIDI") String serieId, @Param("LSNROIDI") String nroSerie,
                                                     @Param("LSPARAM1") String param1, @Param("LSPARAM2") String param2,
                                                     @Param("LSPARAM3") String param3, @Param("LSPARAM4") String param4,
                                                     @Param("LSPARAM5") String param5);

    @Procedure(name = "CuadrarCaja", outputParameterName = "LINUMRES")
    String cuadrarCaja(@Param("LITIPSQL") int tipoSQL, @Param("LILOCALE") int local,
                       @Param("LSFECEMI") String fechaEmision, @Param("LIENTIDA") int entidad,
                       @Param("LSEMISOR") String emisor,  @Param("LSFECAPE") String fechaAper,
                       @Param("LSFECCIE") String fechaCierre,  @Param("LINROCAJ") int caja,
                       @Param("LSSESION") String sesion);

    @Procedure(name = "CerrarCaja", outputParameterName = "LINUMRES")
    String cerrarCaja(@Param("LITIPSQL") int tipoSQL, @Param("LILOCALE") int local,
                       @Param("LSFECEMI") String fechaEmision, @Param("LIENTIDA") int entidad,
                       @Param("LSEMISOR") String emisor, @Param("LSFECAPE") String fechaAper,
                       @Param("LSFECCIE") String fechaCierre, @Param("LSOBSERV") String observacion,
                       @Param("LINROCAJ") int caja, @Param("LSSESION") String sesion);
}
