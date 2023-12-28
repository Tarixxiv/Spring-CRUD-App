package com.example.demo.function;

import com.example.demo.dto.PatchStarRequest;
import com.example.demo.entity.Star;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;

@Component
public class UpdateStarWithRequestFunction implements BiFunction<Star, PatchStarRequest, Star>{
    @Override
    public Star apply(Star entity, PatchStarRequest request)
    {
        return Star.builder()
                .uuid(entity.getUuid())
                .name(request.getName())
                .age(request.getAge())
                .planets(entity.getPlanets())
                .build();
    }

}
