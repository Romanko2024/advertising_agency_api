package com.romanko.advertising_agency_api.presentation;

import com.romanko.advertising_agency_api.application.AdRequestService;
import com.romanko.advertising_agency_api.models.AdRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class AdRequestController {

    private final AdRequestService service;

    public AdRequestController(AdRequestService service) {
        this.service = service;
    }

    @PostMapping
    public AdRequest createRequest(@Valid @RequestBody AdRequest request) {
        return service.saveRequest(request);
    }

    @GetMapping
    public List<AdRequest> getAll() {
        return service.getAllRequests();
    }
}
