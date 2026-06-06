package com.emergency.emergency_response.repository;

import com.emergency.emergency_response.model.EmergencyRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmergencyRequestRepository 
        extends JpaRepository<EmergencyRequest, Long> {
    List<EmergencyRequest> findByStatus(String status);
}