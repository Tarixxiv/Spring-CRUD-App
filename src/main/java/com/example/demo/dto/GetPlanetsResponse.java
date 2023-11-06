package com.example.demo.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetPlanetsResponse {

    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    public static class Planet{
        UUID id;
        String name;
    }

    @Singular
    private List<Planet> planets;

}
