package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Port;

public interface PortRepository extends JpaRepository<Port, Long> {

    List<Port> findByCountry(String country);

    boolean existsByPortCode(String portCode);
}
