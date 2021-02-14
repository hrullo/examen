package com.hrullo.examen.dto;

import java.util.List;


import com.hrullo.examen.persistencia.entidades.People;

import lombok.Data;

@Data
public class ListaPeople {


	private int count;
	private String next;
	private String previous;
	private List<People> results;
	
}
