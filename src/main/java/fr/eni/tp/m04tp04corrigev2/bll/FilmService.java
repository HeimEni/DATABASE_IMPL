package fr.eni.tp.m04tp04corrigev2.bll;

import java.util.List;

import fr.eni.tp.m04tp04corrigev2.bo.Avis;
import fr.eni.tp.m04tp04corrigev2.bo.Film;
import fr.eni.tp.m04tp04corrigev2.bo.Genre;
import fr.eni.tp.m04tp04corrigev2.bo.Participant;

public interface FilmService {
	List<Film> consulterFilms();

	Film consulterFilmParId(long id);

	List<Genre> consulterGenres();

	List<Participant> consulterParticipants();

	Genre consulterGenreParId(long id);

	Participant consulterParticipantParId(long id);

	void creerFilm(Film film);
	
	String consulterTitreFilm(long id);
	
	void publierAvis(Avis avis, long idFilm);
	
	List<Avis> consulterAvis(long idFilm);
}
