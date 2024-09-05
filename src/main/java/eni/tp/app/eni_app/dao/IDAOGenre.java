package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Genre;

import java.util.List;

public interface IDAOGenre {

    List<Genre> findAll();

    Genre findById(int id);
}
