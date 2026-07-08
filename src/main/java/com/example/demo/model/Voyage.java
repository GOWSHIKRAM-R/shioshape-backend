package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "voyages")
public class Voyage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vessel_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "voyages"})
    private Vessel vessel;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_port_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Port originPort;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_port_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Port destinationPort;

    @NotNull
    @Column(name = "departure_date", nullable = false)
    private LocalDateTime departureDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VoyageStatus status;

    public Voyage() {
    }

    public Voyage(Long id, Vessel vessel, Port originPort, Port destinationPort, LocalDateTime departureDate,
            VoyageStatus status) {
        this.id = id;
        this.vessel = vessel;
        this.originPort = originPort;
        this.destinationPort = destinationPort;
        this.departureDate = departureDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Port getOriginPort() {
        return originPort;
    }

    public void setOriginPort(Port originPort) {
        this.originPort = originPort;
    }

    public Port getDestinationPort() {
        return destinationPort;
    }

    public void setDestinationPort(Port destinationPort) {
        this.destinationPort = destinationPort;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDateTime departureDate) {
        this.departureDate = departureDate;
    }

    public VoyageStatus getStatus() {
        return status;
    }

    public void setStatus(VoyageStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Voyage)) {
            return false;
        }
        Voyage voyage = (Voyage) o;
        return Objects.equals(id, voyage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Voyage{" +
                "id=" + id +
                ", departureDate=" + departureDate +
                ", status=" + status +
                '}';
    }
}
