package com.example.auiplanet.planet.init;

import com.example.auiplanet.planet.entity.Planet;
import com.example.auiplanet.planet.service.PlanetService;
import com.example.auiplanet.star.entity.Star;
import com.example.auiplanet.star.service.StarService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    PlanetService planetService;
    StarService starService;
    List<String> names = new ArrayList<>(List.of("Primaris","Secundus","Tertius", "Quartus", "Seriff", "Tannira", "Ishran", "Mersonar","Navalia","Castespes","Becalux","Vistodiet"));
    List<Integer> population = new ArrayList<>(List.of(885355,672654,589504182,5026,765654,672654,589504182,5026,871494,0,950573,885355));
    List<String> starUUIDStrings = new ArrayList<>(List.of("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76","f5875513-bf7b-4ae1-b8a5-5b70a1b90e77","f5875513-bf7b-4ae1-b8a5-5b70a1b90e78","f5875513-bf8b-4ae1-b8a5-5b70a1b90e78"));
    @Autowired
    InitializeData(PlanetService planetService, StarService starService){
        this.planetService = planetService;
        this.starService = starService;
    }
    @Override
    public void afterPropertiesSet() {
        ArrayList<Star> stars = new ArrayList<>();
        for (int i = 0; i < starUUIDStrings.size(); i++) {
            Star star = Star.builder().uuid(UUID.fromString(starUUIDStrings.get(i))).build();
            starService.create(star);
            stars.add(star);
        }
        for (int i = 0; i < names.size(); i++) {
            planetService.create(Planet.builder()
                    .uuid(UUID.randomUUID())
                    .name(names.get(i))
                    .population(population.get(i))
                    .star(stars.get(i%3))
                    .build());
        }

    }
}
