package controller;

import com.example.demo.dto.GetPlanetResponse;
import com.example.demo.dto.GetPlanetsResponse;
import com.example.demo.dto.PutPlanetRequest;
import com.example.demo.function.PlanetToResponseFunction;
import com.example.demo.function.PlanetsToResponseFunction;
import com.example.demo.function.RequestToPlanetFunction;
import com.example.demo.service.PlanetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class PlanetControlller {
    private final PlanetService service;
    private final PlanetToResponseFunction planetToResponse;
    private final PlanetsToResponseFunction planetsToResponse;
    private final RequestToPlanetFunction requestToPlanet;

    public GetPlanetsResponse getPlanets() {
        return planetsToResponse.apply(service.findAll());
    }

    public GetPlanetsResponse getStarPlanets(String starName) {
        return service.findAllByStar(starName)
                .map(planetsToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public GetPlanetResponse getPlanet(UUID id) {
        return service.find(id)
                .map(planetToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void putPlanet(UUID id, PutPlanetRequest request){
        service.create(requestToPlanet.apply(id,request));
    }

    public void deletePlanet(UUID id){
        service.find(id).ifPresentOrElse(
                planet -> service.delete(id),
                () -> {
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                }
        );
    }


}
