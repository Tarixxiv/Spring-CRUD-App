package com.example.demo.dto;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetPlanetResponse {
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    public static class Star {
        private UUID id;
        private String name;
        private int age;
    }

    private UUID id;
    private String name;
    private int population;
    private Star star;
}
