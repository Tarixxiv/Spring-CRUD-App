package com.example.auistar.service;

import com.example.auistar.entity.Star;
import com.example.auistar.event.StarEventRestRepository;
import com.example.auistar.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StarService {
    private final StarRepository repository;
    private final StarEventRestRepository eventRepository;

    @Autowired
    public StarService(StarRepository repository, StarEventRestRepository eventRepository) {
        this.repository = repository;
        this.eventRepository = eventRepository;
    }

    public Optional<Star> find(UUID uuid){
        return repository.findById(uuid);
    }

    public List<Star> findAll() {
        return repository.findAll();
    }

    public List<Star> findAllByAge(int age){
        return repository.findAllByAge(age);
    }

    public Optional<Star> findByName(String name){
        return repository.findByName(name);
    }

    public void create(Star star){
        repository.save(star);
        eventRepository.put(star,star.getUuid());
    }

    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
        eventRepository.delete(id);
    }

}
