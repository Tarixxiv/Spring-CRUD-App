package com.example.auiplanet.star.controller;


import com.example.auiplanet.star.entity.Star;
import com.example.auiplanet.star.service.StarService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@Log

public class StarController {
    private final StarService service;

    @Autowired
    public StarController(StarService service) {
        this.service = service;

    }

    @PutMapping("/api/stars/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putStar(@PathVariable UUID id, @RequestBody Star star) throws Exception{
        try{
            service.create(star);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/stars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStar(@PathVariable("id") UUID id){
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );

    }
}
