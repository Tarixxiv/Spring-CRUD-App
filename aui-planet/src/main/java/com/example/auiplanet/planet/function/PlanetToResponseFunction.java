package com.example.auiplanet.planet.function;

import com.example.auiplanet.planet.dto.GetPlanetResponse;
import com.example.auiplanet.planet.entity.Planet;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PlanetToResponseFunction implements Function<Planet, GetPlanetResponse> {
    public GetPlanetResponse apply(Planet entity){
        return GetPlanetResponse.builder()
                .id(entity.getUuid())
                .name(entity.getName())
                .population(entity.getPopulation())
                .star(GetPlanetResponse.Star.builder()
                        .id(entity.getStar().getUuid())
                        .build())
                .build();
    }
}
