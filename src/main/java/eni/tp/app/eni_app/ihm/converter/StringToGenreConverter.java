package eni.tp.app.eni_app.ihm.converter;


import eni.tp.app.eni_app.bll.IGenreManager;
import eni.tp.app.eni_app.bo.Genre;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {

    private IGenreManager genreManager;

    public StringToGenreConverter(IGenreManager genreManager) {
        this.genreManager = genreManager;
    }

    @Override
    public Genre convert(String idGenre) {
        System.out.println("Converting of idGenre " + idGenre);
        return genreManager.getGenre(Integer.parseInt(idGenre));
    }
}
