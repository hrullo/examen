package com.hrullo.examen.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.hrullo.examen.dto.ResumenFilms;
import com.hrullo.examen.persistencia.entidades.People;

public interface StartWarsService {

	boolean guardarFilms();
	List<People> guardarPeople();
	boolean guardarStarShips();
	ResumenFilms mostrarPersonas(List<People> listaP);
	
}
