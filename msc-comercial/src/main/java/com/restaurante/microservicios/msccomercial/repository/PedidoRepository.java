package com.restaurante.microservicios.msccomercial.repository;

import com.restaurante.microservicios.msccomercial.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {

    @Query(value = "{call ATEN.CON_MESAS_ATENCION(?,?,?,?,?)}", nativeQuery = true)
    List<Map<String, Object>> listadoMesas(@Param("LITIPSQL") int tipoSQL,
                                           @Param("LIENTIDA") int entidad, @Param("LILOCALE") int local,
                                           @Param("LSPARAM1") String param1, @Param("LSPARAM2") String param2);
}
