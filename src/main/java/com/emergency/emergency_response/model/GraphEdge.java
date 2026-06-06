package com.emergency.emergency_response.model;

import jakarta.persistence.*;

@Entity
@Table(name = "graph_edges")
public class GraphEdge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sourceNodeId;
    private Long targetNodeId;
    private Double distanceKm;
    private String trafficLevel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getSourceNodeId() { return sourceNodeId; }
    public void setSourceNodeId(Long sourceNodeId) { this.sourceNodeId = sourceNodeId; }
    public Long getTargetNodeId() { return targetNodeId; }
    public void setTargetNodeId(Long targetNodeId) { this.targetNodeId = targetNodeId; }
    public Double getDistanceKm() { return distanceKm; }
    public void setDistanceKm(Double distanceKm) { this.distanceKm = distanceKm; }
    public String getTrafficLevel() { return trafficLevel; }
    public void setTrafficLevel(String trafficLevel) { this.trafficLevel = trafficLevel; }

    // Traffic weight calculate karo
    public double getWeightedDistance() {
        double multiplier = switch (trafficLevel.toUpperCase()) {
            case "HIGH"   -> 2.0;
            case "MEDIUM" -> 1.5;
            default       -> 1.0;
        };
        return distanceKm * multiplier;
    }
}