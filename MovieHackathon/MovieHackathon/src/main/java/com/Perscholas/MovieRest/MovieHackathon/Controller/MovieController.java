package com.Perscholas.MovieRest.MovieHackathon.Controller;

import com.Perscholas.MovieRest.MovieHackathon.Model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/search")
    public ResponseEntity<Movie> searchMovie(@RequestParam String title) {
        String url = "http://www.omdbapi.com/?apikey=" + apiKey + "&t=" + title;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Movie> responseEntity = restTemplate.getForEntity(url, Movie.class);
        return responseEntity;
    }
}
