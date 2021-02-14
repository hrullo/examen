package com.hrullo.examen.dto;

import java.util.List;


import com.hrullo.examen.persistencia.entidades.Starships;

import lombok.Data;

@Data
public class ListaStarShip {


	private int count;
	private String next;
	private String previous;
	private List<Starships> results;
	
}
