package com.example.auiplanet.planet.function;

import com.example.auiplanet.planet.dto.PatchPlanetRequest;
import com.example.auiplanet.planet.entity.Planet;
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
