package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Genre;

import java.util.List;

public interface GenreDAO {
    Genre read(Long id);
    List<Genre> findAll();
}
