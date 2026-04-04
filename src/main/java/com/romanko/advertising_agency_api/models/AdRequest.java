package com.romanko.advertising_agency_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity // клас як таблиця в БД
@Table(name = "ad_requests")
public class AdRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Автоматична генерація ID
    private Long id;

    @NotBlank(message = "Назва компанії не може бути порожньою")
    private String clientName;

    @Min(value = 1, message = "Бюджет має бути більше нуля")
    private double budget;

    private String description;

    public AdRequest() {}
    public AdRequest(String clientName, double budget, String description) {
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
