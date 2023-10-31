package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@Builder
@AllArgsConstructor
public class PlanetDto{
    String name;
    int population;
    String star;



}
