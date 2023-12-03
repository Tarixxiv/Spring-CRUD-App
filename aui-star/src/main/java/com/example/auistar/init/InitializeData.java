package com.example.auistar.init;

import com.example.auistar.entity.Star;
import com.example.auistar.service.StarService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class InitializeData implements InitializingBean {
    StarService starService;
    List<String> starUUIDStrings = new ArrayList<>(List.of("f5875513-bf7b-4ae1-b8a5-5b70a1b90e76","f5875513-bf7b-4ae1-b8a5-5b70a1b90e77","f5875513-bf7b-4ae1-b8a5-5b70a1b90e78","f5875513-bf8b-4ae1-b8a5-5b70a1b90e78"));
    List<String> starNames = new ArrayList<>(List.of("Barlon","Seriff","Durfar","Empty"));
    List<Integer> ages = new ArrayList<>(List.of(4,6,7,1));
    @Autowired
    InitializeData(StarService starService){
        this.starService = starService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        for (int i = 0; i < starNames.size(); i++) {
            starService.create(Star.builder().uuid(UUID.fromString(starUUIDStrings.get(i)))
                    .name(starNames.get(i))
                    .age(ages.get(i))
                    .build());
        }
    }
}
