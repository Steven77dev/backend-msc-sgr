package com.restaurante.microservicios.mscpersonal.repository;

import com.restaurante.microservicios.mscpersonal.entity.PersonalOficina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalOficinaRepository extends JpaRepository<PersonalOficina, String> {
    Page<PersonalOficina> findPersonalOficinaBy( Pageable pageable);
    List<PersonalOficina> findByCodigoPersonal(String personal);
}
