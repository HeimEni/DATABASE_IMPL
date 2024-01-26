package fr.eni.tp.m04tp04corrigev2.controller.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import fr.eni.tp.m04tp04corrigev2.bll.FilmService;
import fr.eni.tp.m04tp04corrigev2.bo.Genre;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {
	// Injection des services
	private FilmService service;
	
	public StringToGenreConverter(FilmService service) {
		this.service = service;
	}
	@Override
	public Genre convert(String id) {
		Long theId = Long.parseLong(id);
		return service.consulterGenreParId(theId);
	}
}
