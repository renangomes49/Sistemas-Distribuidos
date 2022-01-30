package com.renan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.domain.model.SocioTorcedor;

@Repository
public interface SocioTorcedorRepository extends JpaRepository<SocioTorcedor, Long>{

}