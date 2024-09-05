package eni.tp.app.eni_app.dao.movies;

import eni.tp.app.eni_app.bo.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Profile("mysql")
@Component
public class DAOMySQL implements IDAOMovie {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /*
    Le code qui permet de savoir comment convertir/mapper un résultat en SQL en

    Comment mppaer un résultat SQL en Aliment
     */

    static final RowMapper<Movie> MOVIE_ROW_MAPPER = new RowMapper<Movie>() {

        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();

            movie.id = rs.getLong("id");
            movie.title = rs.getString("title");
            movie.note = rs.getInt("note");
            movie.year = rs.getInt("year");
            movie.duration = rs.getInt("duration");
            movie.synopsis = rs.getString("synopsis");
            movie.photo = rs.getString("photo");

            return movie;
        }
    };

    @Override
    public List<Movie> selectMovie() {

        return jdbcTemplate.query("SELECT * FROM movie", MOVIE_ROW_MAPPER);

    }

    @Override
    public Movie selectMovieById(long id) {
        List<Movie> movies = jdbcTemplate.query("SELECT * FROM movie WHERE id = ?", MOVIE_ROW_MAPPER, id);

        //Si on trouve aucun élément on retourne null
        if (movies.size() == 0) {
            return null;
        }

        //Retourner le premier élément
        return movies.get(0);
    }

    @Override
    public void saveMovie(Movie movie) {

        //Tester si il existe en base, SI OUI => Update SINON => Insert
        if (movie.getId() != null && selectMovieById(movie.getId()) != null) {
            jdbcTemplate.update("UPDATE movie SET title = ?, note = ?, year = ?, duration = ?, synopsis = ?,photo = ? WHERE id = ?"
                    , movie.title, movie.note, movie.year, movie.duration, movie.synopsis, movie.photo, movie.id);

            //PS : Return = Arreter la fonction
            return;
//
        }

//        //Insérer en base un aliment
//        jdbcTemplate.update("INSERT INTO movie(id, title, note, year, duration, synopsis, photo ) VALUES (?,?," +
//                        "?,?,?,?,?)", movie.id, movie.title, movie.note, movie.year, movie.duration,
//                movie.synopsis, movie.photo);

        String sql = "INSERT INTO movie (id,title,note,year,duration,synopsis,photo,id_genre) VALUES (:idMovie,:titleMovie,:noteMovie," +
                ":yearMovie, :durationMovie, :synopsisMovie, :photoMovie, :idgen)";

        //On renseigne les paramètres attendus dans la requête
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("idMovie", movie.getId());
        mapSqlParameterSource.addValue("titleMovie", movie.getTitle());
        mapSqlParameterSource.addValue("noteMovie", movie.getNote());
        mapSqlParameterSource.addValue("yearMovie", movie.getYear());
        mapSqlParameterSource.addValue("durationMovie", movie.getDuration());
        mapSqlParameterSource.addValue("synopsisMovie", movie.getSynopsis());
        mapSqlParameterSource.addValue("photoMovie", movie.getPhoto());
        mapSqlParameterSource.addValue("idgen",movie.getGenre().getId()) ;


        //Insérer en base un aliment
//        jdbcTemplate.update("INSERT INTO aliment(id, name, id_category ) VALUES (:idAliment, :nameAliment, :idCategory)", aliment.id, aliment.name);

        //Insérer en base un aliment
        namedParameterJdbcTemplate.update(sql, mapSqlParameterSource);

    }
}




