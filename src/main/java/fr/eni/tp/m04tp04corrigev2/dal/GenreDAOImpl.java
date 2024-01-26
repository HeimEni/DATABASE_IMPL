package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GenreDAOImpl implements GenreDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GenreDAOImpl(JdbcTemplate jdbcTemplate, JdbcTemplateAutoConfiguration jdbcTemplateAutoConfiguration) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Genre read(Long id) {
        var sql ="SELECT * from [GENRE] where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Genre.class), id);
    }

    @Override
    public List<Genre> findAll() {
        var sql = "SELECT * from [GENRE]";
        List<Genre> genres = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genre.class));
        return genres;
    }
}
