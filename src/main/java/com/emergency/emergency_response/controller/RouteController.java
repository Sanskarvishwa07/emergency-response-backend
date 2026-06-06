package com.emergency.emergency_response.controller;

import com.emergency.emergency_response.model.GraphEdge;
import com.emergency.emergency_response.model.GraphNode;
import com.emergency.emergency_response.repository.GraphEdgeRepository;
import com.emergency.emergency_response.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/route")
public class RouteController {

    private final RouteService routeService;
    private final GraphEdgeRepository edgeRepository;

    public RouteController(RouteService routeService,
                           GraphEdgeRepository edgeRepository) {
        this.routeService = routeService;
        this.edgeRepository = edgeRepository;
    }

    // Node add karo
    @PostMapping("/node")
    public ResponseEntity<GraphNode> addNode(@RequestBody GraphNode node) {
        return ResponseEntity.ok(routeService.addNode(node));
    }

    // Sabhi nodes dekho
    @GetMapping("/nodes")
    public ResponseEntity<List<GraphNode>> getAllNodes() {
        return ResponseEntity.ok(routeService.getAllNodes());
    }

    // Edge add karo
    @PostMapping("/edge")
    public ResponseEntity<GraphEdge> addEdge(@RequestBody GraphEdge edge) {
        return ResponseEntity.ok(edgeRepository.save(edge));
    }

    // Shortest path find karo
    @GetMapping("/shortest")
    public ResponseEntity<Map<String, Object>> getShortestPath(
            @RequestParam Long source,
            @RequestParam Long target) {

        double distance = routeService.getShortestPath(source, target);
        double eta = routeService.calculateETA(distance);

        Map<String, Object> result = new HashMap<>();
        result.put("sourceNodeId", source);
        result.put("targetNodeId", target);
        result.put("shortestDistanceKm", distance);
        result.put("etaMinutes", eta);

        return ResponseEntity.ok(result);
    }
}
