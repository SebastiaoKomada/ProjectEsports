package com.POO.esports.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.POO.esports.model.Sumula;

@Repository
public interface SumulaRepository extends JpaRepository<Sumula, Long> {

}