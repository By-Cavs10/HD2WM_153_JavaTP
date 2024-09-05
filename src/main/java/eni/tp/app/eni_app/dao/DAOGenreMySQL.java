package eni.tp.app.eni_app.dao;

import eni.tp.app.eni_app.bo.Genre;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOGenreMySQL implements IDAOGenre {

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DAOGenreMySQL(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public List<Genre> findAll() {
        String sql = "select id, titre from genre";

        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Genre.class));


    }

    @Override
    public Genre findById(int id) {
        String sql = "SELECT id, titre FROM genre WHERE id = :idgen";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("idgen", id);

        return namedParameterJdbcTemplate.queryForObject(sql,map, new BeanPropertyRowMapper<>(Genre.class));

    }
}
