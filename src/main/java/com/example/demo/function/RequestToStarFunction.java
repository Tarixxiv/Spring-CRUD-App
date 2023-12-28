package com.example.demo.function;

import com.example.demo.dto.GetStarsResponse;
import com.example.demo.dto.PutStarRequest;
import com.example.demo.entity.Star;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
                .planets(new ArrayList<>())
                .build();
    }
}
