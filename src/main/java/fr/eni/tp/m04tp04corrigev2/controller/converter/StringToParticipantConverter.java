package fr.eni.tp.m04tp04corrigev2.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import fr.eni.tp.m04tp04corrigev2.bll.FilmService;
import fr.eni.tp.m04tp04corrigev2.bo.Participant;

@Component
public class StringToParticipantConverter implements Converter<String, Participant> {
	// Injection des services
	private FilmService service;

	public StringToParticipantConverter(FilmService service) {
		this.service = service;
	}

	@Override
	public Participant convert(String id) {
		Long theId = Long.parseLong(id);
		return service.consulterParticipantParId(theId);
	}
}
