package com.example.demo.function;

import com.example.demo.dto.GetStarResponse;
import com.example.demo.entity.Star;

import java.util.function.Function;

public class StarToResponseFunction implements Function<Star, GetStarResponse> {
    @Override
    public GetStarResponse apply(Star entity) {
        return GetStarResponse.builder()
                .id(entity.getUuid())
                .name(entity.getName())
                .build();
    }


}
