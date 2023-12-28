package com.example.auistar.function;

import com.example.auistar.dto.GetStarResponse;
import com.example.auistar.entity.Star;
import org.springframework.stereotype.Component;

import java.util.function.Function;
@Component
public class StarToResponseFunction implements Function<Star, GetStarResponse> {
    @Override
    public GetStarResponse apply(Star entity) {
        return GetStarResponse.builder()
                .id(entity.getUuid())
                .name(entity.getName())
                .age(entity.getAge())
                .build();
    }


}
