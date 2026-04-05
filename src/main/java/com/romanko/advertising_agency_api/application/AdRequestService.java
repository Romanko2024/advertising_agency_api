package com.romanko.advertising_agency_api.application;

import com.romanko.advertising_agency_api.data.AdRequestRepository;
import com.romanko.advertising_agency_api.dto.AdRequestDTO;
import com.romanko.advertising_agency_api.models.AdRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdRequestService {
    private final AdRequestRepository repository;

    public AdRequestService(AdRequestRepository repository) {
        this.repository = repository;
    }

    public List<AdRequestDTO> getAllRequests() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public AdRequestDTO createRequest(AdRequestDTO dto) {
        AdRequest entity = convertToEntity(dto);
        AdRequest saved = repository.save(entity);
        return convertToDTO(saved);
    }

    public AdRequestDTO updateRequest(Long id, AdRequestDTO dto) {
        return repository.findById(id).map(existing -> {
            existing.setClientName(dto.getClientName());
            existing.setBudget(dto.getBudget());
            existing.setDescription(dto.getDescription());
            return convertToDTO(repository.save(existing));
        }).orElseThrow(() -> new RuntimeException("Заявку з ID " + id + " не знайдено"));
    }

    public void deleteRequest(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Заявку з ID " + id + " не знайдено");
        }
        repository.deleteById(id);
    }

    public AdRequestDTO getById(Long id) {
        return repository.findById(id)
            .map(this::convertToDTO)
            .orElseThrow(() -> new RuntimeException("Заявку з ID " + id + " не знайдено"));
    }
    
    private AdRequestDTO convertToDTO(AdRequest entity) {
        return new AdRequestDTO(entity.getId(), entity.getClientName(), entity.getBudget(), entity.getDescription());
    }

    private AdRequest convertToEntity(AdRequestDTO dto) {
        AdRequest entity = new AdRequest();
        entity.setClientName(dto.getClientName());
        entity.setBudget(dto.getBudget());
        entity.setDescription(dto.getDescription());
        return entity;
    }
}
