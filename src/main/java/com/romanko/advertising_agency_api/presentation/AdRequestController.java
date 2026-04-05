package com.romanko.advertising_agency_api.presentation;

import com.romanko.advertising_agency_api.application.AdRequestService;
import com.romanko.advertising_agency_api.dto.AdRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class AdRequestController {

    private final AdRequestService service;

    public AdRequestController(AdRequestService service) {
        this.service = service;
    }

    @GetMapping
    public List<AdRequestDTO> getAll() {
        return service.getAllRequests();
    }

    @PostMapping
    public ResponseEntity<AdRequestDTO> create(@Valid @RequestBody AdRequestDTO dto) {
        return ResponseEntity.ok(service.createRequest(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdRequestDTO> update(@PathVariable Long id, @Valid @RequestBody AdRequestDTO dto) {
        return ResponseEntity.ok(service.updateRequest(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteRequest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdRequestDTO> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
