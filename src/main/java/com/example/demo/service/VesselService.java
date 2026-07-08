package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Vessel;
import com.example.demo.model.VesselStatus;

public interface VesselService {

    Vessel createVessel(Vessel vessel);

    Page<Vessel> getAllVessels(Pageable pageable);

    Vessel getVesselById(Long id);

    Vessel updateVesselStatus(Long id, VesselStatus status);

    void deleteVessel(Long id);
}
