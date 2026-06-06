package com.emergency.emergency_response.service;

import com.emergency.emergency_response.model.Hospital;
import com.emergency.emergency_response.repository.HospitalRepository;
import com.emergency.emergency_response.util.HaversineUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final HaversineUtil haversineUtil;

    public HospitalService(HospitalRepository hospitalRepository,
                           HaversineUtil haversineUtil) {
        this.hospitalRepository = hospitalRepository;
        this.haversineUtil = haversineUtil;
    }

    // Sabhi hospitals lao
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    // Hospital add karo
    public Hospital addHospital(Hospital hospital) {
        return hospitalRepository.save(hospital);
    }

    // Hospital ID se dhundo
    public Hospital getHospitalById(Long id) {
        return hospitalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hospital not found!"));
    }

    // Hospital delete karo
    public void deleteHospital(Long id) {
        hospitalRepository.deleteById(id);
    }

    // Sabse nearest hospital dhundo
    public Hospital findNearestHospital(double patientLat, double patientLon) {
        List<Hospital> hospitals = hospitalRepository
                .findByAvailableBedsGreaterThan(0);

        Hospital nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Hospital hospital : hospitals) {
            double distance = haversineUtil.calculateDistance(
                    patientLat, patientLon,
                    hospital.getLatitude(), hospital.getLongitude());

            if (distance < minDistance) {
                minDistance = distance;
                nearest = hospital;
            }
        }

        return nearest;
    }
}