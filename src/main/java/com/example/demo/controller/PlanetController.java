package com.example.demo.controller;

import com.example.demo.dto.GetPlanetResponse;
import com.example.demo.dto.GetPlanetsResponse;
import com.example.demo.dto.PatchPlanetRequest;
import com.example.demo.dto.PutPlanetRequest;
import com.example.demo.function.PlanetToResponseFunction;
import com.example.demo.function.PlanetsToResponseFunction;
import com.example.demo.function.RequestToPlanetFunction;
import com.example.demo.function.UpdatePlanetWithRequestFunction;
import com.example.demo.service.PlanetService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.UUID;

@RestController
@Log
public class PlanetController {
    private final PlanetService service;
    private final PlanetToResponseFunction planetToResponse;
    private final PlanetsToResponseFunction planetsToResponse;
    private final RequestToPlanetFunction requestToPlanet;
    private final UpdatePlanetWithRequestFunction updateToPlanet;

    public PlanetController(PlanetService service, PlanetToResponseFunction planetToResponse, PlanetsToResponseFunction planetsToResponse, RequestToPlanetFunction requestToPlanet, UpdatePlanetWithRequestFunction updateToPlanet) {
        this.service = service;
        this.planetToResponse = planetToResponse;
        this.planetsToResponse = planetsToResponse;
        this.requestToPlanet = requestToPlanet;
        this.updateToPlanet = updateToPlanet;
    }

    @GetMapping("api/planets")
    public GetPlanetsResponse getPlanets() {
        return planetsToResponse.apply(service.findAll());
    }

    @GetMapping("api/planets/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public GetPlanetResponse getPlanet(@PathVariable("id") UUID id) {
        return service.find(id)
                .map(planetToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/api/stars/{id}/planets")
    @ResponseStatus(HttpStatus.OK)
    public GetPlanetsResponse getPlanetsByStar(@PathVariable UUID id){
        return service.findAllByStar(id)
                .map(planetsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/api/planets/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void putPlanet(@PathVariable("id") UUID id,
                          @RequestBody PutPlanetRequest request){
        service.create(requestToPlanet.apply(id,request));
    }

    @PatchMapping("/api/planets/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void patchPlanet(@PathVariable UUID id, @RequestBody PatchPlanetRequest request){
        service.find(id).ifPresentOrElse(
                planet -> service.create(updateToPlanet.apply(planet, request)),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }

    @DeleteMapping("/api/planets/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlanet(@PathVariable("id") UUID id){
        service.find(id).ifPresentOrElse(
                planet -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }


}
