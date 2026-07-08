package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.VoyageRequestDto;
import com.example.demo.model.Voyage;

public interface VoyageService {

    Voyage initiateVoyage(VoyageRequestDto request);

    List<Voyage> getAllVoyages();

    Voyage getVoyageById(Long id);
}
