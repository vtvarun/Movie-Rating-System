package Varun.moviecatalougservice;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping("/catalogue")
public class Controller {

    @GetMapping("/getCatalogue")
    public List<CatalougeItem> getCatalogue(@RequestParam String userId){


        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8081/ratings/get-rated-movies?userId=" + userId;

        ParameterizedTypeReference<List<Ratings>> responseType = new ParameterizedTypeReference<List<Ratings>>() {};

        ResponseEntity<List<Ratings>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, responseType);

        List<Ratings> allMovies = responseEntity.getBody();

        List<CatalougeItem> moviesWithRatings = new ArrayList<>();

        if (allMovies != null) {
            for(Ratings rating : allMovies){
                String tempURL = "http://localhost:8080/movies/get-movies?movieId="+rating.getMovieId();
                Movie movie = restTemplate.getForObject(tempURL,Movie.class);
                CatalougeItem catalougeItem = new CatalougeItem(rating.getRatings(),movie);
                moviesWithRatings.add(catalougeItem);
            }
        }

        return moviesWithRatings;
    }
}
