package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Movie;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DAOMock implements IDAOMovie {



        @Override
        public List<Movie> selectMovie() {
            //Initialiser une fausse liste d'aliments
            List<Movie> movies = new ArrayList<Movie>();
            movies.add(new Movie(25, "Chauve-Souris", 1995, 120, "mieux que batman" ));
            movies.add(new Movie(25, "Chauve Man", 2023, 102, "le chauve fort" ));

            //aliments.add(new Aliment("Beurre Salé"));
            return movies;
        }

    }
