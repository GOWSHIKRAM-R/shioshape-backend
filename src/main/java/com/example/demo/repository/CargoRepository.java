package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findByVoyageId(Long voyageId);
}
