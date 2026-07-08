package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cargo;
import com.example.demo.service.CargoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cargo create(@Valid @RequestBody Cargo cargo) {
        return cargoService.createCargo(cargo);
    }

    @GetMapping("/voyage/{id}")
    public ResponseEntity<List<Cargo>> getCargoByVoyage(@PathVariable Long id) {
        return ResponseEntity.ok(cargoService.getCargoByVoyage(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        cargoService.deleteCargo(id);
        return ResponseEntity.ok("Cargo deleted successfully.");
    }
}
