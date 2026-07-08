package com.example.demo.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BusinessValidationException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Vessel;
import com.example.demo.model.VesselStatus;
import com.example.demo.repository.VesselRepository;
import com.example.demo.service.VesselService;

@Service
public class VesselServiceImpl implements VesselService {

    private final VesselRepository vesselRepository;

    public VesselServiceImpl(VesselRepository vesselRepository) {
        this.vesselRepository = vesselRepository;
    }

    @Override
    public Vessel createVessel(Vessel vessel) {
        if (vesselRepository.existsByImoNumber(vessel.getImoNumber())) {
            throw new BusinessValidationException("A vessel with IMO number " + vessel.getImoNumber()
                    + " already exists.");
        }
        return vesselRepository.save(vessel);
    }

    @Override
    public Page<Vessel> getAllVessels(Pageable pageable) {
        return vesselRepository.findAll(pageable);
    }

    @Override
    public Vessel getVesselById(Long id) {
        return vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Vessel not found with id: " + id));
    }

    @Override
    public Vessel updateVesselStatus(Long id, VesselStatus status) {
        Vessel vessel = getVesselById(id);
        vessel.setStatus(status);
        return vesselRepository.save(vessel);
    }

    @Override
    public void deleteVessel(Long id) {
        Vessel vessel = getVesselById(id);
        vesselRepository.delete(vessel);
    }
}
