package com.emergency.emergency_response.util;

import com.emergency.emergency_response.model.GraphEdge;
import com.emergency.emergency_response.repository.GraphEdgeRepository;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DijkstraAlgorithm {

    private final GraphEdgeRepository edgeRepository;

    public DijkstraAlgorithm(GraphEdgeRepository edgeRepository) {
        this.edgeRepository = edgeRepository;
    }

    public Map<Long, Double> findShortestPaths(Long sourceNodeId) {

        // Distance map — har node ka shortest distance
        Map<Long, Double> distances = new HashMap<>();

        // Priority queue — sabse kam distance wala pehle
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparingDouble(a -> a[1])
        );

        // Source node ka distance 0
        distances.put(sourceNodeId, 0.0);
        pq.offer(new long[]{sourceNodeId, 0});

        while (!pq.isEmpty()) {
            long[] current = pq.poll();
            Long currentNode = current[0];
            double currentDist = current[1];

            // Agar already better path mila hai toh skip karo
            if (currentDist > distances.getOrDefault(currentNode, Double.MAX_VALUE)) {
                continue;
            }

            // Current node ke saare edges dekho
            List<GraphEdge> edges = edgeRepository.findBySourceNodeId(currentNode);

            for (GraphEdge edge : edges) {
                Long neighbor = edge.getTargetNodeId();
                double newDist = currentDist + edge.getWeightedDistance();

                // Agar better path mila
                if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    pq.offer(new long[]{neighbor, (long) newDist});
                }
            }
        }

        return distances;
    }

    public double getShortestPath(Long sourceNodeId, Long targetNodeId) {
        Map<Long, Double> distances = findShortestPaths(sourceNodeId);
        return distances.getOrDefault(targetNodeId, Double.MAX_VALUE);
    }
}
