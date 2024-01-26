package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Avis;

import java.util.List;

public interface AvisDAO {
    void create(Avis avis, long idFilm);
    List<Avis> findByFilm(long idFilm);
}
