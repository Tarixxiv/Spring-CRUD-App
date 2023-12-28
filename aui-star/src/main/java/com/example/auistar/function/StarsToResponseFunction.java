package com.example.auistar.function;

import com.example.auistar.dto.GetStarsResponse;
import com.example.auistar.entity.Star;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;


@Component
public class StarsToResponseFunction implements Function<List<Star>, GetStarsResponse> {
    @Override
    public GetStarsResponse apply(List<Star> entities) {
        return GetStarsResponse.builder()
                .stars(entities.stream()
                        .map(Star -> GetStarsResponse.Star.builder()
                                .id(Star.getUuid())
                                .name(Star.getName())
                                .build())
                        .toList())
                .build();
    }

}
