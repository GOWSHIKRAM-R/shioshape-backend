package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.BusinessValidationException;
import com.example.demo.model.Port;
import com.example.demo.repository.PortRepository;
import com.example.demo.service.PortService;

@Service
public class PortServiceImpl implements PortService {

    private final PortRepository portRepository;

    public PortServiceImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public List<Port> getAllPorts() {
        return portRepository.findAll();
    }

    @Override
    public Port createPort(Port port) {
        if (portRepository.existsByPortCode(port.getPortCode())) {
            throw new BusinessValidationException("A port with code " + port.getPortCode() + " already exists.");
        }
        return portRepository.save(port);
    }
}
