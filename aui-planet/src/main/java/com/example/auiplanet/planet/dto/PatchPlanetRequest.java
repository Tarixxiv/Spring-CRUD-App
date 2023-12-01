package com.example.auiplanet.planet.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PatchPlanetRequest {
    private String name;
    private int population;
}
