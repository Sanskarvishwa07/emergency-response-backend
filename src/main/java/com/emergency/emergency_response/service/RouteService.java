package com.emergency.emergency_response.service;

import com.emergency.emergency_response.model.GraphNode;
import com.emergency.emergency_response.repository.GraphNodeRepository;
import com.emergency.emergency_response.util.DijkstraAlgorithm;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RouteService {

    private final GraphNodeRepository nodeRepository;
    private final DijkstraAlgorithm dijkstra;

    public RouteService(GraphNodeRepository nodeRepository,
                        DijkstraAlgorithm dijkstra) {
        this.nodeRepository = nodeRepository;
        this.dijkstra = dijkstra;
    }

    // Node add karo
    public GraphNode addNode(GraphNode node) {
        return nodeRepository.save(node);
    }

    // Sabhi nodes dekho
    public List<GraphNode> getAllNodes() {
        return nodeRepository.findAll();
    }

    // Shortest path find karo
    public double getShortestPath(Long sourceId, Long targetId) {
        return dijkstra.getShortestPath(sourceId, targetId);
    }

    // Sabse nearest hospital node find karo
    public Map<Long, Double> getAllPathsFrom(Long sourceId) {
        return dijkstra.findShortestPaths(sourceId);
    }

    // ETA calculate karo (average speed 40 km/h)
    public double calculateETA(double distanceKm) {
        double averageSpeedKmh = 40.0;
        double timeHours = distanceKm / averageSpeedKmh;
        return timeHours * 60; // minutes mein
    }
}