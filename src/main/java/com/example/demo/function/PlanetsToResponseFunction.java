package com.example.demo.function;

import com.example.demo.dto.GetPlanetsResponse;
import com.example.demo.entity.Planet;
import com.example.demo.entity.Star;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class PlanetsToResponseFunction implements Function<List<Planet>,GetPlanetsResponse>{
    @Override
    public GetPlanetsResponse apply(List<Planet> entities) {
        //entities = List.of(Planet.builder().name("Arkab").population(30).star(Star.builder().name("test").age(5).build()).build());
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
