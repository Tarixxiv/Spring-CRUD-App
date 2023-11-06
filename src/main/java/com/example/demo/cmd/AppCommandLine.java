package com.example.demo.cmd;

import com.example.demo.entity.Planet;
import com.example.demo.entity.Star;
import com.example.demo.service.PlanetService;
import com.example.demo.service.StarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;

@Component
public class AppCommandLine implements CommandLineRunner {
    private final StarService starService;
    private final PlanetService planetService;


    public AppCommandLine(StarService starService, PlanetService planetService) {
        this.starService = starService;
        this.planetService = planetService;
    }


    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        main_loop:
        while(true){
            command = scanner.next();
            switch(command){
                case "help" ->
                    System.out.println("""
                            put_star [name] [age] : creates star
                            put_planet [name] [population] [starName] : creates planet
                            findall_planets : lists all planets
                            find_all_stars : lists all stars
                            find_all_planets_by_star [starName] : finds planet by star name
                            delete_planet [name] : deletes planet
                            quit : exits application""");



                case "put_star" ->{
                    try{
                    starService.create(Star.builder()
                            .uuid(UUID.randomUUID())
                            .name(scanner.next())
                            .age(Integer.parseInt(scanner.next()))
                            .build());
                        System.out.println("Star created");
                    } catch (IllegalArgumentException e){
                        System.out.println("Bad request");
                    }
                }

                case "put_planet" ->{
                    try {
                        String name = scanner.next();
                        int population = Integer.parseInt(scanner.next());
                        Optional<Star> star = starService.findByName(scanner.next());
                        if (star.isEmpty()){
                            throw new IllegalArgumentException();
                        }

                        planetService.create(Planet.builder()
                                .uuid(UUID.randomUUID())
                                .name(name)
                                .population(population)
                                .star(star.get())
                                .build());
                    } catch (IllegalArgumentException e){
                        System.out.println("Bad request");
                    }
                    System.out.println("Planet created");
                }

                case "find_all_planets" ->{
                    for (Planet planet:
                         planetService.findAll()) {
                        System.out.println(planet);
                    }
                }

                case "find_all_stars" ->{
                    for (Star star:
                         starService.findAll()) {
                        System.out.println(star);
                    }
                }

                case "find_all_planets_by_star" ->{
                    try{
                        String starName = scanner.next();
                        Optional<List<Planet>> results = planetService.findAllByStar(starName);
                        if (results.isEmpty()){
                            throw new IllegalArgumentException();
                        }
                        //noinspection OptionalGetWithoutIsPresent
                        for (Planet planet:
                                planetService.findAllByStar(starName).get()) {
                            System.out.println(planet);
                        }
                    }catch (IllegalArgumentException e){
                        System.out.println("Bad request");
                    }
                }

                case "delete_planet" -> {
                    try {
                        String name = scanner.next();
                        Optional<Planet> planet = planetService.findByName(name);
                        if (planet.isEmpty()) {
                            throw new IllegalArgumentException();
                        }
                        planet.ifPresent(value -> planetService.delete(value.getUuid()));
                        System.out.println("Planet deleted");
                    }catch (IllegalArgumentException e){
                    System.out.println("Bad request");
                    }
                }


                case "quit" ->{
                    break main_loop;
                }
            }
        }
    }
}
