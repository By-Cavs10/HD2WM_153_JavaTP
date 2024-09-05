package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Movie;
import eni.tp.app.eni_app.dao.movies.IDAOMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleManager {


    @Autowired
    IDAOMovie daoMovie;

    /**
     * Le manager qui récupère la liste des Aliments
     *
     * @return
     */


    public List<Movie> getMovies() {

        //Récupère la couche DAO
        // IDAOAliment daoAliment = FactoryDAO.getDAOAliment();

        //récupérer les aliments de la DAO
        List<Movie> movies = daoMovie.selectMovie();

        return movies;
    }

    public Movie getById(long id) {

        Movie movie = daoMovie.selectMovieById(id);

        return movie;
    }

    //Appelera la DAO pour sauvegarder un Aliment
    //@param aliment
    public void saveMovie(Movie movie) {
        daoMovie.saveMovie(movie);
    }

}
