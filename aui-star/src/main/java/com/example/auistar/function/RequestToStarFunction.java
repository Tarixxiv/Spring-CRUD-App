package com.example.auistar.function;


import com.example.auistar.dto.PutStarRequest;
import com.example.auistar.entity.Star;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.function.BiFunction;
@Component
public class RequestToStarFunction implements BiFunction<UUID, PutStarRequest, Star> {

    @Override
    public Star apply(UUID id, PutStarRequest request) {
        return Star.builder()
                .uuid(id)
                .name(request.getName())
                .age(request.getAge())
                .build();
    }
}
