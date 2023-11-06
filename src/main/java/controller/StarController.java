package controller;

import com.example.demo.dto.GetStarResponse;
import com.example.demo.dto.GetStarsResponse;
import com.example.demo.function.StarToResponseFunction;
import com.example.demo.function.StarsToResponseFunction;
import com.example.demo.service.StarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
@AllArgsConstructor
public class StarController {
    private final StarService service;
    private final StarToResponseFunction starToResponse;
    private final StarsToResponseFunction starsToResponse;


    public GetStarsResponse getStarsResponse(){
        return starsToResponse.apply(service.findAll());
    }

    public GetStarResponse getStarResponse(UUID id){
        return service.find(id)
                .map(starToResponse)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteStar(UUID id){
        service.find(id)
                .ifPresentOrElse(
                        profession -> service.delete(id),
                        () -> {
                            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
                        }
                );

    }

}
