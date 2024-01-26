package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Participant;

import java.util.List;

public interface ParticipantDAO {
    Participant read(long id);
    List<Participant> findALl();
    List<Participant> findActeurs(long idFilm);
    void createActeur(long idParticipant, long idFilm);
}
