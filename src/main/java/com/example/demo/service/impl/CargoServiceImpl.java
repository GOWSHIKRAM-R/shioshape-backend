package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Cargo;
import com.example.demo.model.Voyage;
import com.example.demo.repository.CargoRepository;
import com.example.demo.repository.VoyageRepository;
import com.example.demo.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService {

    private final CargoRepository cargoRepository;
    private final VoyageRepository voyageRepository;

    public CargoServiceImpl(CargoRepository cargoRepository, VoyageRepository voyageRepository) {
        this.cargoRepository = cargoRepository;
        this.voyageRepository = voyageRepository;
    }

    @Override
    public Cargo createCargo(Cargo cargo) {
        if (cargo.getVoyage() == null || cargo.getVoyage().getId() == null) {
            throw new ResourceNotFoundException("A valid voyage must be specified for the cargo entry.");
        }

        Voyage voyage = voyageRepository.findById(cargo.getVoyage().getId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Voyage not found with id: " + cargo.getVoyage().getId()));

        cargo.setVoyage(voyage);
        return cargoRepository.save(cargo);
    }

    @Override
    public List<Cargo> getCargoByVoyage(Long voyageId) {
        return cargoRepository.findByVoyageId(voyageId);
    }

    @Override
    public void deleteCargo(Long id) {
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cargo not found with id: " + id));
        cargoRepository.delete(cargo);
    }
}
