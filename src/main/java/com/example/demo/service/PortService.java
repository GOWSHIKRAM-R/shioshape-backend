package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Port;

public interface PortService {

    List<Port> getAllPorts();

    Port createPort(Port port);
}
