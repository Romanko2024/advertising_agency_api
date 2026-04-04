package com.romanko.advertising_agency_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class AdRequestDTO {
    private Long id;

    @NotBlank(message = "Назва клієнта обов'язкова")
    private String clientName;

    @Min(value = 1, message = "Бюджет має бути позитивним")
    private double budget;
    private String description;

    public AdRequestDTO() {}

    public AdRequestDTO(Long id, String clientName, double budget, String description) {
        this.id = id;
        this.clientName = clientName;
        this.budget = budget;
        this.description = description;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
