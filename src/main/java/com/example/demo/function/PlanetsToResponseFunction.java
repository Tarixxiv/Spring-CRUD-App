package com.example.demo.function;

import com.example.demo.dto.GetPlanetsResponse;
import com.example.demo.entity.Planet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PlanetsToResponseFunction implements Function<List<Planet>,GetPlanetsResponse>{
    public GetPlanetsResponse apply(List<Planet> entities) {
        return GetPlanetsResponse.builder()
                .planets(entities.stream()
                        .map(planet -> GetPlanetsResponse.Planet.builder()
                                .id(planet.getUuid())
                                .name(planet.getName())
                                .build())
                        .toList())
                .build();

    }

}
