package com.example.demo.function;

import com.example.demo.dto.GetPlanetResponse;
import com.example.demo.entity.Planet;
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
                        .name(entity.getStar().getName())
                        .age(entity.getStar().getAge())
                        .build())
                .build();
    }
}
