package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Genre;
import eni.tp.app.eni_app.dao.IDAOGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreManager implements IGenreManager {


    private IDAOGenre genreDAO;

    public GenreManager(IDAOGenre genreDAO) {
        this.genreDAO = genreDAO;
    }



    @Override
    public List<Genre> getGenres() {
        return genreDAO.findAll();
    }

    @Override
    public Genre getGenre(int id) {
        return genreDAO.findById(id);
    }




}
