package com.romanko.advertising_agency_api.data;
import com.romanko.advertising_agency_api.models.AdRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRequestRepository extends JpaRepository<AdRequest, Long> {
    
}
