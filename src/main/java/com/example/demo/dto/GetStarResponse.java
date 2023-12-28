package com.example.demo.dto;

import lombok.*;


import java.util.UUID;
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class GetStarResponse {
    private UUID id;
    private String name;
    private int age;
}
