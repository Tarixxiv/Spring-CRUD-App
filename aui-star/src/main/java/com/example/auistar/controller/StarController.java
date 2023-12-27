package com.example.auistar.controller;


import com.example.auistar.dto.GetStarResponse;
import com.example.auistar.dto.GetStarsResponse;
import com.example.auistar.dto.PatchStarRequest;
import com.example.auistar.dto.PutStarRequest;
import com.example.auistar.function.RequestToStarFunction;
import com.example.auistar.function.StarToResponseFunction;
import com.example.auistar.function.StarsToResponseFunction;
import com.example.auistar.function.UpdateStarWithRequestFunction;
import com.example.auistar.service.StarService;
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
    private final StarToResponseFunction starToResponse;
    private final StarsToResponseFunction starsToResponse;
    private final RequestToStarFunction requestToStar;
    private final UpdateStarWithRequestFunction updateToStar;
    @Autowired
    public StarController(StarService service, StarToResponseFunction starToResponse, StarsToResponseFunction starsToResponse, RequestToStarFunction requestToStar, UpdateStarWithRequestFunction updateToStar) {
        this.service = service;
        this.starToResponse = starToResponse;
        this.starsToResponse = starsToResponse;
        this.requestToStar = requestToStar;
        this.updateToStar = updateToStar;
    }

    @GetMapping("api/stars")
    @ResponseStatus(HttpStatus.OK)
    public GetStarsResponse getStarsResponse(){
        return starsToResponse.apply(service.findAll());
    }
    @GetMapping("/api/stars/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetStarResponse getStarResponse(@PathVariable("id") UUID id){
        return service.find(id)
                .map(starToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/api/stars")
    public void putNewPlanet(@RequestBody PutStarRequest request){
        putPlanet(UUID.randomUUID(), request);
    }

    @PutMapping("/api/stars/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putPlanet(@PathVariable("id") UUID id,
                          @RequestBody PutStarRequest request){
        service.create(requestToStar.apply(id,request));
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

    @PatchMapping("/api/stars/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void patchStar(@PathVariable UUID id, @RequestBody PatchStarRequest request){
        service.find(id).ifPresentOrElse(
                star -> service.create(updateToStar.apply(star, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

}
