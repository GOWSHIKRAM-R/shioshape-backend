package com.example.demo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.VoyageRequestDto;
import com.example.demo.model.Voyage;
import com.example.demo.service.VoyageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/voyages")
public class VoyageController {

    private final VoyageService voyageService;

    public VoyageController(VoyageService voyageService) {
        this.voyageService = voyageService;
    }

    @GetMapping
    public ResponseEntity<List<Voyage>> getAllVoyages() {
        return ResponseEntity.ok(voyageService.getAllVoyages());
    }

    @PostMapping("/initiate")
    public ResponseEntity<Voyage> create(@Valid @RequestBody VoyageRequestDto request) {
        Voyage voyage = voyageService.initiateVoyage(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(voyage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voyage> getVoyageById(@PathVariable Long id) {
        return ResponseEntity.ok(voyageService.getVoyageById(id));
    }
}
