package com.example.auiplanet.planet.function;

import com.example.auiplanet.planet.dto.GetPlanetsResponse;
import com.example.auiplanet.planet.entity.Planet;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PlanetsToResponseFunction implements Function<List<Planet>, GetPlanetsResponse>{
    @Override
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
