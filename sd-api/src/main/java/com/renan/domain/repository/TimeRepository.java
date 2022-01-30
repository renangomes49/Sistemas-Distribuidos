package com.renan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renan.domain.model.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long>{

}