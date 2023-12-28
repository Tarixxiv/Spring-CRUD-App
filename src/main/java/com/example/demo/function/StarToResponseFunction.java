package com.example.demo.function;

import com.example.demo.dto.GetStarResponse;
import com.example.demo.entity.Star;
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
