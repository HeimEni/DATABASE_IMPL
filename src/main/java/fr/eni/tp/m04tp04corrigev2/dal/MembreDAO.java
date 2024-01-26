package fr.eni.tp.m04tp04corrigev2.dal;

import fr.eni.tp.m04tp04corrigev2.bo.Membre;

public interface MembreDAO {
    Membre read(long id);
    Membre read(String email);
}
