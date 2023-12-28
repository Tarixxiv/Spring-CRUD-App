package com.example.auistar.function;

import com.example.auistar.dto.PatchStarRequest;
import com.example.auistar.entity.Star;
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
                .build();
    }

}
