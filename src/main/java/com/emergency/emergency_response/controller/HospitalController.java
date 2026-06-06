package com.emergency.emergency_response.controller;

import com.emergency.emergency_response.model.Hospital;
import com.emergency.emergency_response.service.HospitalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    // Sabhi hospitals
    @GetMapping
    public ResponseEntity<List<Hospital>> getAllHospitals() {
        return ResponseEntity.ok(hospitalService.getAllHospitals());
    }

    // Hospital add karo
    @PostMapping
    public ResponseEntity<Hospital> addHospital(@RequestBody Hospital hospital) {
        return ResponseEntity.ok(hospitalService.addHospital(hospital));
    }

    // ID se hospital dhundo
    @GetMapping("/{id}")
    public ResponseEntity<Hospital> getHospitalById(@PathVariable Long id) {
        return ResponseEntity.ok(hospitalService.getHospitalById(id));
    }

    // Hospital delete karo
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHospital(@PathVariable Long id) {
        hospitalService.deleteHospital(id);
        return ResponseEntity.ok("Hospital deleted!");
    }

    // Nearest hospital dhundo
    @GetMapping("/nearest")
    public ResponseEntity<Hospital> getNearestHospital(
            @RequestParam double lat,
            @RequestParam double lon) {
        return ResponseEntity.ok(hospitalService.findNearestHospital(lat, lon));
    }
}