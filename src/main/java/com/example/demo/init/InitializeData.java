package com.example.demo.init;

import com.example.demo.entity.Planet;
import com.example.demo.entity.Star;
import com.example.demo.service.PlanetService;
import com.example.demo.service.StarService;
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
    List<String> starUUIDStrings = new ArrayList<>(List.of("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76","f5875513-bf7b-4ae1-b8a5-5b70a1b90e77","f5875513-bf7b-4ae1-b8a5-5b70a1b90e78"));
    List<String> starNames = new ArrayList<>(List.of("Barlon","Seriff","Durfar"));
    List<Integer> ages = new ArrayList<>(List.of(4,6,7));

    @Autowired
    InitializeData(PlanetService planetService, StarService starService){
        this.planetService = planetService;
        this.starService = starService;
    }

    @Override
    public void afterPropertiesSet() {
            for (int i = 0; i < starNames.size(); i++) {
                starService.create(Star.builder().uuid(UUID.fromString(starUUIDStrings.get(i)))
                        .name(starNames.get(i))
                        .age(ages.get(i))
                        .build());
            }
            for (int i = 0; i < names.size(); i++) {
                List<Star> stars = starService.findAll();
                planetService.create(Planet.builder()
                        .uuid(UUID.randomUUID())
                        .name(names.get(i))
                        .population(population.get(i))
                        .star(stars.get(i%stars.size()))
                        .build());
            }

    }
}
