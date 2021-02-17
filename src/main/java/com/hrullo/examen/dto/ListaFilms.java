package com.hrullo.examen.dto;

import java.util.List;

import com.hrullo.examen.persistencia.entidades.Films;

import lombok.Data;

@Data
public class ListaFilms {

	private int count;
	private String next;
	private String previous;
	private List<Films> results;
	
	
	
}
