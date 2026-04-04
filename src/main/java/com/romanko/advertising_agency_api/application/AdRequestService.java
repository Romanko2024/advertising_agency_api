package com.romanko.advertising_agency_api.application;

import com.romanko.advertising_agency_api.data.AdRequestRepository;
import com.romanko.advertising_agency_api.models.AdRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdRequestService {
    private final AdRequestRepository repository;

    public AdRequestService(AdRequestRepository repository) {
        this.repository = repository;
    }

    public AdRequest saveRequest(AdRequest request) {
        // Тут можна додати додаткову логіку перед збереженням
        return repository.save(request);
    }

    public List<AdRequest> getAllRequests() {
        return repository.findAll();
    }
}
