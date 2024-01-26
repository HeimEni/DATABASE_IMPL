package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class MembreDAOimpl implements MembreDAO {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MembreDAOimpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Membre read(long id) {
        var sql = "SELECT * from [MEMBRE] where id = : id";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Membre.class));
    }

    @Override
    public Membre read(String email) {
        var sql = "SELECT * from [MEMBRE] where email = :eamil";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("email", email);
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Membre.class));
    }
}
