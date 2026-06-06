package com.emergency.emergency_response.util;

import org.springframework.stereotype.Component;

@Component
public class SeverityCalculator {

    public double calculate(int symptomWeight, int age,
                            double distanceKm, String trafficLevel) {

        // Age factor
        double ageFactor = (age < 5 || age > 60) ? 10.0 : 5.0;

        // Distance normalize 0-10 (max 50km)
        double distancePenalty = Math.min((distanceKm / 50.0) * 10, 10);

        // Traffic penalty
        double trafficPenalty = switch (trafficLevel.toUpperCase()) {
            case "HIGH"   -> 10.0;
            case "MEDIUM" -> 6.5;
            default       -> 3.0;
        };

        return (symptomWeight * 0.40)
             + (ageFactor     * 0.20)
             + (distancePenalty * 0.25)
             + (trafficPenalty  * 0.15);
    }
}