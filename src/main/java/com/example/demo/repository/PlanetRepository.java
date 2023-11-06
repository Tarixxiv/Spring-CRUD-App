package com.example.demo.repository;
import com.example.demo.entity.Planet;
import com.example.demo.entity.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PlanetRepository extends JpaRepository<Planet, UUID> {


    Optional<Planet> findByName(String name);
    List<Planet> findAllByStar(Star star);
    List<Planet> findAllByPopulation(int population);

}
