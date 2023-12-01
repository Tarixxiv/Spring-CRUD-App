package com.example.auiplanet.planet.service;

import com.example.auiplanet.planet.entity.Planet;
import com.example.auiplanet.planet.repository.PlanetRepository;
import com.example.auiplanet.star.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlanetService{
    private final PlanetRepository repository;
    private final StarRepository starRepository;
    @Autowired
    public PlanetService(PlanetRepository repository, StarRepository starRepository) {
        this.repository = repository;
        this.starRepository = starRepository;
    }
    public Optional<Planet> find(UUID id) {return repository.findById(id);}
    public Optional<Planet> findByName(String name){
        return repository.findByName(name);
    }
    public Optional<List<Planet>> findAllByStar(UUID starId){
        return starRepository.findById(starId).map(repository::findAllByStar);

    }

    public List<Planet> findAll(){
        return repository.findAll();
    }

    public void create(Planet planet){
        repository.save(planet);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }
}
