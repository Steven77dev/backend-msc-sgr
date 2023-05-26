package com.restaurante.microservicios.msccomercial.repository;

import com.restaurante.microservicios.msccomercial.entity.productos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Short> {

    @Query(value = "{call PROD.CON_PRODUCTO(?,?,?,?,?,?,?)}", nativeQuery = true)
    List<Map<String, Object>> buscarProductosPorAlmacenFamilia(@Param("LITIPSQL") int tipoSQL,
                                           @Param("LIENTIDA") int entidad, @Param("LSPARAM1") String param1,
                                           @Param("LSPARAM2") String param2, @Param("LSPARAM3") String param3,
                                           @Param("LSPARAM4") String param4, @Param("LSPARAM5") String param5);
}
