package com.example.auiplanet.star.service;

import com.example.auiplanet.star.entity.Star;
import com.example.auiplanet.star.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.UUID;

@Service
public class StarService {
    private final StarRepository repository;

    @Autowired
    public StarService(StarRepository repository) {
        this.repository = repository;
    }

    public Optional<Star> find(UUID uuid){
        return repository.findById(uuid);
    }


    public void delete(UUID id){
        repository.findById(id).ifPresent(repository::delete);
    }

}
