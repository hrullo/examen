package com.hrullo.examen.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ListaPersonasPeliculas {
	@JsonProperty("Nombre de persona")
	private String nombre;
	@JsonProperty("Lista de films")
	private List<String> Films;
	@JsonProperty("Cantidad de films")
	private int cantidad;
	
	
}
