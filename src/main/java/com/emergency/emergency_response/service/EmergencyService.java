package com.emergency.emergency_response.service;

import com.emergency.emergency_response.model.EmergencyRequest;
import com.emergency.emergency_response.model.Hospital;
import com.emergency.emergency_response.repository.EmergencyRequestRepository;
import com.emergency.emergency_response.util.HaversineUtil;
import com.emergency.emergency_response.util.SeverityCalculator;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmergencyService {

    private final EmergencyRequestRepository emergencyRepository;
    private final HospitalService hospitalService;
    private final HaversineUtil haversineUtil;
    private final SeverityCalculator severityCalculator;

    public EmergencyService(EmergencyRequestRepository emergencyRepository,
                            HospitalService hospitalService,
                            HaversineUtil haversineUtil,
                            SeverityCalculator severityCalculator) {
        this.emergencyRepository = emergencyRepository;
        this.hospitalService = hospitalService;
        this.haversineUtil = haversineUtil;
        this.severityCalculator = severityCalculator;
    }

    public EmergencyRequest createEmergency(EmergencyRequest request) {

        // Nearest hospital dhundo
        Hospital nearest = hospitalService.findNearestHospital(
                request.getPatientLat(), request.getPatientLon());

        if (nearest == null) {
            throw new RuntimeException("No hospital available!");
        }

        // Distance calculate karo
        double distance = haversineUtil.calculateDistance(
                request.getPatientLat(), request.getPatientLon(),
                nearest.getLatitude(), nearest.getLongitude());

        // Severity score calculate karo
        double score = severityCalculator.calculate(
                request.getSymptomWeight(),
                request.getAge(),
                distance,
                request.getTrafficLevel());

        // Request set karo
        request.setAssignedHospitalId(nearest.getId());
        request.setDistanceKm(distance);
        request.setSeverityScore(score);
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDateTime.now());

        return emergencyRepository.save(request);
    }

    public List<EmergencyRequest> getAllEmergencies() {
        return emergencyRepository.findAll();
    }

    public EmergencyRequest getEmergencyById(Long id) {
        return emergencyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Emergency not found!"));
    }
}