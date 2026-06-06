package com.emergency.emergency_response.controller;

import com.emergency.emergency_response.model.EmergencyRequest;
import com.emergency.emergency_response.service.EmergencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergency")
public class EmergencyController {

    private final EmergencyService emergencyService;

    public EmergencyController(EmergencyService emergencyService) {
        this.emergencyService = emergencyService;
    }

    // Emergency request banao
    @PostMapping
    public ResponseEntity<EmergencyRequest> createEmergency(
            @RequestBody EmergencyRequest request) {
        return ResponseEntity.ok(emergencyService.createEmergency(request));
    }

    // Sabhi emergencies dekho
    @GetMapping
    public ResponseEntity<List<EmergencyRequest>> getAllEmergencies() {
        return ResponseEntity.ok(emergencyService.getAllEmergencies());
    }

    // ID se emergency dekho
    @GetMapping("/{id}")
    public ResponseEntity<EmergencyRequest> getEmergencyById(
            @PathVariable Long id) {
        return ResponseEntity.ok(emergencyService.getEmergencyById(id));
    }
}
