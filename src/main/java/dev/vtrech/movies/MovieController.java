package dev.vtrech.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.allMovies();
        System.out.println("Dữ liệu từ service: " + movies);
        if (movies.isEmpty()) {
            System.out.println("Danh sách rỗng!");
        }
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable ObjectId id){
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(id), HttpStatus.OK);
    }
}
