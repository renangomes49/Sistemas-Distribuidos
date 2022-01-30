package com.renan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.domain.model.Campeonato;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long>{

}