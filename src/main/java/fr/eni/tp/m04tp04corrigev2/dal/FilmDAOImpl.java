package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class FilmDAOImpl implements FilmDAO{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public FilmDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Integer create(Film film) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        var sql = "INSERT INTO Film VALUES (:titre,:annee,:duree,:synopsis)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("titre", film.getTitre());
        namedParameters.addValue("annee", film.getAnnee());
        namedParameters.addValue("duree", film.getDuree());
        namedParameters.addValue("titre", film.getSynopsis());
        int nbEnregistrement = jdbcTemplate.update(sql, namedParameters, keyHolder);

        if (keyHolder != null && keyHolder.getKey() != null) {
            // Mise à jour de l'identifiant du film auto-généré par la base
            film.setId(keyHolder.getKey().longValue());
        }
        return keyHolder.getKey().intValue();
    }

    @Override
    public Film read(Long id) {
        var sql = "SELECT * from [FILM] where id = ?";
        Film film = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Film.class));
        return film;
    }

    @Override
    public List<Film> findAll() {
        var sql = "SELECT * from [FILM]";
        List<Film> films = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Film.class));
        return films;
    }

    @Override
    public String findTitre(long id) {
        var sql = "SELECT [titre] from [FILM] where id = ?";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        Film film = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Film.class));
        return film.getTitre();
    }
}
