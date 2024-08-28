package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Profile("mock")
@Component
public class DAOMock implements IDAOMovie {



            List<Movie> movies = Arrays.asList(
                new Movie(1, "Chauve-Souris", 1995, 120, "mieux que batman", "/chauve-qui-peut.png" ),
                new Movie(2 , "Chauve Man", 2023, 102, "le chauve fort","/chauve-qui-peut-v2.png" ));

    @Override
    public List<Movie> selectMovie() {
        return movies;


    }


    @Override
    public Movie selectMovieById(long id) {
        Movie movieToFound = movies.stream().filter(movie -> movie.id == id).findFirst().orElse(null);

        return movieToFound;
    }

    @Override
    public void saveMovie(Movie movie) {

    }

}
