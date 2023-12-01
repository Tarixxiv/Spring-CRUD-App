package com.example.auiplanet.planet.function;


import com.example.auiplanet.planet.dto.PutPlanetRequest;
import com.example.auiplanet.planet.entity.Planet;
import com.example.auiplanet.star.entity.Star;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToPlanetFunction implements BiFunction<UUID, PutPlanetRequest, Planet> {
    public Planet apply(UUID id, PutPlanetRequest request){
        return Planet.builder()
                .uuid(id)
                .name(request.getName())
                .population(request.getPopulation())
                .star(Star.builder()
                        .uuid(request.getStar())
                        .build())
                .build();
    }
}
