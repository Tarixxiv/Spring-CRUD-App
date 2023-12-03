package com.example.auistar.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class StarEventRestRepository {
    private final RestTemplate restTemplate;
    @Autowired
    public StarEventRestRepository(RestTemplate template){
        this.restTemplate = template;
    }

    public void delete(UUID id){
        restTemplate.delete("/api/stars/{id}",id);
    }

}
