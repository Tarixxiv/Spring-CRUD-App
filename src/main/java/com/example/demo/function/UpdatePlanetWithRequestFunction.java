package com.example.demo.function;

import com.example.demo.dto.PatchPlanetRequest;
import com.example.demo.entity.Planet;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
@Component
public class UpdatePlanetWithRequestFunction implements BiFunction<Planet, PatchPlanetRequest, Planet> {

    @Override
    public Planet apply(Planet entity, PatchPlanetRequest request) {
        return Planet.builder()
                .uuid(entity.getUuid())
                .name(request.getName())
                .population(request.getPopulation())
                .star(entity.getStar())
                .build();
    }
}
