package com.example.demo.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public class VoyageRequestDto {

    @NotNull
    private Long vesselId;

    @NotNull
    private Long originPortId;

    @NotNull
    private Long destinationPortId;

    @NotNull
    private LocalDateTime departureDate;

    public VoyageRequestDto() {
    }

    public VoyageRequestDto(Long vesselId, Long originPortId, Long destinationPortId, LocalDateTime departureDate) {
        this.vesselId = vesselId;
        this.originPortId = originPortId;
        this.destinationPortId = destinationPortId;
        this.departureDate = departureDate;
    }

    public Long getVesselId() {
        return vesselId;
    }

    public void setVesselId(Long vesselId) {
        this.vesselId = vesselId;
    }

    public Long getOriginPortId() {
        return originPortId;
    }

    public void setOriginPortId(Long originPortId) {
        this.originPortId = originPortId;
    }

    public Long getDestinationPortId() {
        return destinationPortId;
    }

    public void setDestinationPortId(Long destinationPortId) {
        this.destinationPortId = destinationPortId;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }
}
