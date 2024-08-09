package dev.jmfayard.spring;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Instant;

/**
 * Hibernate: create table insurance_policy (status tinyint not null check (status between 0 and 1), created_at timestamp(6) with time zone not null, end_date timestamp(6) with time zone not null, id bigint not null, start_date timestamp(6) with time zone not null, updated_at timestamp(6) with time zone not null, name varchar(255) not null, primary key (id))
 */
@Entity
public class InsurancePolicy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private Instant createdAt;
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