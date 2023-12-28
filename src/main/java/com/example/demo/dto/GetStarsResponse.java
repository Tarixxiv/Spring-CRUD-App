package com.example.demo.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;
@Data
@Builder
public class GetStarsResponse {
    @Data
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @Builder
    public static class Star{
        UUID id;
        String name;
    }

    @Singular
    private List<GetStarsResponse.Star> stars;
}
