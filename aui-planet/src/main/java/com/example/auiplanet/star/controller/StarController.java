package com.example.auiplanet.star.controller;


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
