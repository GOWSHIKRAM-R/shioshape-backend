package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Cargo;

public interface CargoService {

    Cargo createCargo(Cargo cargo);

    List<Cargo> getCargoByVoyage(Long voyageId);

    void deleteCargo(Long id);
}
