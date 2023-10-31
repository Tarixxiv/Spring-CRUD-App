package com.example.demo.service;

import com.example.demo.entity.Planet;
import com.example.demo.entity.Star;
import com.example.demo.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetService{
    private final PlanetRepository repository;

    public PlanetService(PlanetRepository repository) {
        this.repository = repository;
    }
    public Optional<Planet> findByName(String name){
        return repository.findByName(name);
    }
    public List<Planet> findAllByStar(Star star){
        return repository.findAllByStar(star);
    }
    public List<Planet> findAllByPopulation(int population){
        return repository.findAllByPopulation(population);
    }

    public List<Planet> findAll(){
        return repository.findAll();
    }

    public void create(Planet planet){
        repository.save(planet);
    }

    public void delete(Planet planet){
        repository.delete(planet);
    }
}
