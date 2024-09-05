package eni.tp.app.eni_app.bll;

import eni.tp.app.eni_app.bo.Genre;

import java.util.List;

public interface IGenreManager {

    List<Genre> getGenres();

    Genre getGenre(int id);
}
