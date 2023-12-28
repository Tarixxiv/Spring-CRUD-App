package com.example.auiplanet.planet.entity;

import com.example.auiplanet.star.entity.Star;
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
    @Column
    String name;
    @Column
    int population;
    @ManyToOne
    @JoinColumn(name = "star")
    Star star;


    @Override
    public int compareTo(Object o) {
        return this.hashCode() - o.hashCode();
    }

}
