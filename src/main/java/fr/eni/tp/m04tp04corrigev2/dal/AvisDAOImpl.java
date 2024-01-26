package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Avis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class AvisDAOImpl implements AvisDAO{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public AvisDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(Avis avis, long idFilm) {
        var sql = "INSERT INTO [AVIS] VALUES (:id,:note,:commentaire,:id_membre,:idFilm";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", avis.getId());
        namedParameters.addValue("note", avis.getNote());
        namedParameters.addValue("commentaire", avis.getCommentaire());
        namedParameters.addValue("id_membre", avis.getMembre().getId());
        namedParameters.addValue("id_Film", idFilm);
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Avis> findByFilm(long idFilm) {
        var sql = "SELECT * from [AVIS] where id_film = :idFilm";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("idFilm", idFilm);
        List<Avis> avis = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Avis.class));
        return avis;
    }
}
