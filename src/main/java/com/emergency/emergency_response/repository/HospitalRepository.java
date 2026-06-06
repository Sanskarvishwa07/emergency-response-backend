package com.emergency.emergency_response.repository;

import com.emergency.emergency_response.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    List<Hospital> findByAvailableBedsGreaterThan(Integer beds);
}