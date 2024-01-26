package fr.eni.tp.m04tp04corrigev2.bll;

import fr.eni.tp.m04tp04corrigev2.bo.Avis;
import fr.eni.tp.m04tp04corrigev2.bo.Film;
import fr.eni.tp.m04tp04corrigev2.bo.Genre;
import fr.eni.tp.m04tp04corrigev2.bo.Participant;
import fr.eni.tp.m04tp04corrigev2.dal.FilmDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FilmServiceImpl implements FilmService{
    private FilmDAOImpl filmDAO;
    @Autowired
    public FilmServiceImpl(FilmDAOImpl filmDAO) {
        this.filmDAO = filmDAO;
    }

    @Override
    public List<Film> consulterFilms() {
        return filmDAO.findAll();
    }

    @Override
    public Film consulterFilmParId(long id) {
        return null;
    }

    @Override
    public List<Genre> consulterGenres() {
        return null;
    }

    @Override
    public List<Participant> consulterParticipants() {
        return null;
    }

    @Override
    public Genre consulterGenreParId(long id) {
        return null;
    }

    @Override
    public Participant consulterParticipantParId(long id) {
        return null;
    }

    @Override
    public void creerFilm(Film film) {

    }

    @Override
    public String consulterTitreFilm(long id) {
        return null;
    }

    @Override
    public void publierAvis(Avis avis, long idFilm) {

    }

    @Override
    public List<Avis> consulterAvis(long idFilm) {
        return null;
    }
}
