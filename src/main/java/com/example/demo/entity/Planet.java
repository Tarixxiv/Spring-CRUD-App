package com.example.demo.entity;

import com.example.demo.PlanetDto;
import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="planets")
@Data
public class Planet implements Serializable, Comparable {
    @Id
    private UUID uuid;
    @Column(unique = true)
    String name;
    @Column
    int population;
    @ManyToOne
    @JoinColumn(name = "star")
    Star star;

    public PlanetDto toDto(){
        return new PlanetDto(this.name,this.population,this.star.getName());
    }

    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }

}
