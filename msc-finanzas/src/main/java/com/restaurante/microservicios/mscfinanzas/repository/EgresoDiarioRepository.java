package com.restaurante.microservicios.mscfinanzas.repository;

import com.restaurante.microservicios.mscfinanzas.entity.EgresoDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EgresoDiarioRepository extends JpaRepository<EgresoDiario,String> {

    @Query(value = "{call FINA.CON_EGRESO_DIARIO(?,?,?,?,?,?,?,?)}", nativeQuery = true)
    List<Map<String, Object>> resumenEgresoPersonal(@Param("LITIPSQL") int tipoSQL,
                                                @Param("LSSERIDI") String serieId, @Param("LSNROIDI") String nroSerie,
                                                @Param("LSPARAM1") String param1, @Param("LSPARAM2") String param2,
                                                @Param("LSPARAM3") String param3, @Param("LSPARAM4") String param4,
                                                @Param("LSPARAM5") String param5);

    @Query(value = "{call FINA.CON_EGRESO_DIARIO(?,?,?,?,?,?,?,?)}", nativeQuery = true)
    Map<String, Object> cierreCajaDiaAnterior(@Param("LITIPSQL") int tipoSQL,
                                                    @Param("LSSERIDI") String serieId, @Param("LSNROIDI") String nroSerie,
                                                    @Param("LSPARAM1") String param1, @Param("LSPARAM2") String param2,
                                                    @Param("LSPARAM3") String param3, @Param("LSPARAM4") String param4,
                                                    @Param("LSPARAM5") String param5);
}
