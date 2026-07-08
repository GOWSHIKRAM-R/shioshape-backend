package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Vessel;
import com.example.demo.model.VesselStatus;
import com.example.demo.service.VesselService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vessels")
public class VesselController {

    private final VesselService vesselService;

    public VesselController(VesselService vesselService) {
        this.vesselService = vesselService;
    }

    @GetMapping
    public ResponseEntity<Page<Vessel>> getAllVessels(Pageable pageable) {
        return ResponseEntity.ok(vesselService.getAllVessels(pageable));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_SYSTEM_ADMIN')")
    public ResponseEntity<String> create(@Valid @RequestBody Vessel vessel) {
        vesselService.createVessel(vessel);
        return ResponseEntity.status(HttpStatus.CREATED).body("Vessel created successfully.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vessel> getVesselById(@PathVariable Long id) {
        return ResponseEntity.ok(vesselService.getVesselById(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<String> updateStatus(@PathVariable Long id, @RequestBody VesselStatus status) {
        vesselService.updateVesselStatus(id, status);
        return ResponseEntity.ok("Vessel updated successfully.");
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_SYSTEM_ADMIN')")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        vesselService.deleteVessel(id);
        return ResponseEntity.ok("Vessel deleted successfully.");
    }
}
