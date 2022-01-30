package com.renan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.domain.model.ConfederacaoBrasileiraDeFutebol;

@Repository
public interface CbfRepository extends JpaRepository<ConfederacaoBrasileiraDeFutebol, Long>{

}