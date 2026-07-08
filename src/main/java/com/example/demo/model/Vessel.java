package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "vessels", uniqueConstraints = {
        @jakarta.persistence.UniqueConstraint(columnNames = "imo_number")
})
public class Vessel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @NotBlank
    @Column(name = "imo_number", nullable = false, unique = true)
    private String imoNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "vessel_type", nullable = false)
    private VesselType vesselType;

    @NotNull
    @Positive
    @Column(name = "deadweight_tonnage", nullable = false)
    private Double deadweightTonnage;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VesselStatus status;

    public Vessel() {
    }

    public Vessel(Long id, String name, String imoNumber, VesselType vesselType, Double deadweightTonnage,
            VesselStatus status) {
        this.id = id;
        this.name = name;
        this.imoNumber = imoNumber;
        this.vesselType = vesselType;
        this.deadweightTonnage = deadweightTonnage;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImoNumber() {
        return imoNumber;
    }

    public void setImoNumber(String imoNumber) {
        this.imoNumber = imoNumber;
    }

    public VesselType getVesselType() {
        return vesselType;
    }

    public void setVesselType(VesselType vesselType) {
        this.vesselType = vesselType;
    }

    public Double getDeadweightTonnage() {
        return deadweightTonnage;
    }

    public void setDeadweightTonnage(Double deadweightTonnage) {
        this.deadweightTonnage = deadweightTonnage;
    }

    public VesselStatus getStatus() {
        return status;
    }

    public void setStatus(VesselStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vessel)) {
            return false;
        }
        Vessel vessel = (Vessel) o;
        return Objects.equals(id, vessel.id) && Objects.equals(imoNumber, vessel.imoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imoNumber);
    }

    @Override
    public String toString() {
        return "Vessel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imoNumber='" + imoNumber + '\'' +
                ", vesselType=" + vesselType +
                ", deadweightTonnage=" + deadweightTonnage +
                ", status=" + status +
                '}';
    }
}
