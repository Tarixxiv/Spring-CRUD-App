package com.example.demo.entity;

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
    @Column(unique = true)
    String name;
    @Column
    int age; //counted in billion years
    @OneToMany(mappedBy = "star", cascade = CascadeType.REMOVE)
    @Singular
    @ToString.Exclude
    List<Planet> planets = new ArrayList<>();
}
