package com.example.auistar.entity;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.*;

import java.io.Serializable;
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
    @Column
    String name;
    @Column
    int age; //counted in billion years
}
