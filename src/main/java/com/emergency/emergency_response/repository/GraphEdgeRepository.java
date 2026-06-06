package com.emergency.emergency_response.repository;

import com.emergency.emergency_response.model.GraphEdge;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GraphEdgeRepository extends JpaRepository<GraphEdge, Long> {
    List<GraphEdge> findBySourceNodeId(Long sourceNodeId);
}