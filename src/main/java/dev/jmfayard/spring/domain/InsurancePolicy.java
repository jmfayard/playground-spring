package dev.jmfayard.spring.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

@Entity
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false)
    private long id;


    @NotNull @NotBlank
    private String name;
    @NotNull
    private Status status;
    @NotNull
    private Instant startDate;
    @NotNull
    private Instant endDate;

    /** FIXME: those 2 fields are editable for now **/
    @NotNull
    @Column(updatable = false)
    private Instant createdAt;
    @Column(updatable = false)
    @NotNull
    private Instant updatedAt;


    public enum Status {ACTIVE, INACTIVE}

    public InsurancePolicy() {
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }
    private void updateAutomaticFields() {
        this.updatedAt = Instant.now();
    }

    /**
     * Setters
     ***/
    public void setName(String name) {
        updateAutomaticFields();
        this.name = name;
    }

    public void setStatus(Status status) {
        updateAutomaticFields();
        this.status = status;
    }

    public void setStartDate(Instant startDate) {
        updateAutomaticFields();
        this.startDate = startDate;
    }

    public void setEndDate(Instant endDate) {
        updateAutomaticFields();
        this.endDate = endDate;
    }

    /**
     * Getters
     ***/
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public Instant getEndDate() {
        return endDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}