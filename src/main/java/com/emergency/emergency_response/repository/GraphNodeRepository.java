package com.emergency.emergency_response.repository;

import com.emergency.emergency_response.model.GraphNode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraphNodeRepository extends JpaRepository<GraphNode, Long> {
}
