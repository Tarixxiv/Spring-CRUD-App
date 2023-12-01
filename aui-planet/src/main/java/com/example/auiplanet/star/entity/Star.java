package com.example.auiplanet.star.entity;

import com.example.auiplanet.planet.entity.Planet;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Category("Star")
@Table(name="stars")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Star implements Serializable {
    @Id
    private UUID uuid;
    @OneToMany(mappedBy = "star", cascade = CascadeType.REMOVE)
    @Singular
    @ToString.Exclude
    List<Planet> planets = new ArrayList<>();
}
