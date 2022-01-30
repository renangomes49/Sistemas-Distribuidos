package com.renan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.domain.model.Partida;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long>{

}
