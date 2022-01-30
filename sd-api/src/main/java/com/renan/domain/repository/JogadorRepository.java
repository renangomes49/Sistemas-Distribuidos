package com.renan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.domain.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long>{

}