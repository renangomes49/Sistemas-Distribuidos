package com.renan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.domain.model.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{

}