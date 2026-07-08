package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Voyage;
import com.example.demo.model.VoyageStatus;

public interface VoyageRepository extends JpaRepository<Voyage, Long> {

    List<Voyage> findByStatus(VoyageStatus status);
}
