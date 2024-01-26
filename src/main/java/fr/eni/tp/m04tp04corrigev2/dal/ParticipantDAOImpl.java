package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Film;
import fr.eni.tp.m04tp04corrigev2.bo.Participant;
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
public class ParticipantDAOImpl implements ParticipantDAO{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public ParticipantDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Participant read(long id) {
        var sql ="SELECT * from [PARTICIPANT] where id = ?";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);
        Participant participant = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Participant.class));
        return participant;
    }

    @Override
    public List<Participant> findALl() {
        var sql ="SELECT * from [PARTICIPANT]";
        List<Participant> participants = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participant.class));
        return participants;
    }

    @Override
    public List<Participant> findActeurs(long idFilm) {
        var sql ="SELECT * from [PARTICIPANT] INNER JOIN [ACTEURS] on id_film = ?";
        List<Participant> participants = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Participant.class));
        return participants;
    }

    @Override
    public void createActeur(long idParticipant, long idFilm) {
        var sql = "INSERT INTO [ACTEURS] VALUES (:idParticipant,:idFilm)";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idParticipant", idParticipant);
        namedParameters.addValue("idFilm", idFilm);
        jdbcTemplate.update(sql, namedParameters);
    }
}
