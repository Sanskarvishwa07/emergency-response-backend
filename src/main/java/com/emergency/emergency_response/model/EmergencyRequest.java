package com.emergency.emergency_response.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "emergency_requests")
public class EmergencyRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double patientLat;
    private Double patientLon;
    private Integer age;
    private String symptoms;
    private Integer symptomWeight;
    private String trafficLevel;

    private Double severityScore;
    private Long assignedHospitalId;
    private Double distanceKm;
    private String status;

    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Double getPatientLat() { return patientLat; }
    public void setPatientLat(Double patientLat) { this.patientLat = patientLat; }
    public Double getPatientLon() { return patientLon; }
    public void setPatientLon(Double patientLon) { this.patientLon = patientLon; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public String getSymptoms() { return symptoms; }
    public void setSymptoms(String symptoms) { this.symptoms = symptoms; }
    public Integer getSymptomWeight() { return symptomWeight; }
    public void setSymptomWeight(Integer symptomWeight) { this.symptomWeight = symptomWeight; }
    public String getTrafficLevel() { return trafficLevel; }
    public void setTrafficLevel(String trafficLevel) { this.trafficLevel = trafficLevel; }
    public Double getSeverityScore() { return severityScore; }
    public void setSeverityScore(Double severityScore) { this.severityScore = severityScore; }
    public Long getAssignedHospitalId() { return assignedHospitalId; }
    public void setAssignedHospitalId(Long assignedHospitalId) { this.assignedHospitalId = assignedHospitalId; }
    public Double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(Double distanceKm) { this.distanceKm = distanceKm; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}