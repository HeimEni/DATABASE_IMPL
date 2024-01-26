package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Film;

import java.util.List;

public interface FilmDAO {
    Integer create(Film film);
    Film read(Long id);
    List<Film> findAll();
    String findTitre(long id);
}
