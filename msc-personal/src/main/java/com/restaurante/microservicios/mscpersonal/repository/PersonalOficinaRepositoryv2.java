package com.restaurante.microservicios.mscpersonal.repository;

import com.restaurante.microservicios.mscpersonal.entity.PersonalOficina;
import com.restaurante.microservicios.mscpersonal.entity.PersonalOficinav2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalOficinaRepositoryv2 extends JpaRepository<PersonalOficinav2, String> {
    Page<PersonalOficinav2> findPersonalOficinaBy( Pageable pageable);
    List<PersonalOficinav2> findByCodigoPersonal(String personal);
}
