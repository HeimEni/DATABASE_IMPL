package fr.eni.tp.m04tp04corrigev2.bll.contexte;

import fr.eni.tp.m04tp04corrigev2.bo.Membre;

public interface ContexteService {
	Membre charger(String email);
}
