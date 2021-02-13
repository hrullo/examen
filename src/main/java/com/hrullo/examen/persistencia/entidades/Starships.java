package com.hrullo.examen.persistencia.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Entity
//@Table(name="STARSHIPS")
public class Starships {


	private String name;
	private String model;
	private String manufacturer;
	private int length;
	private int max_atmosphering_speed;
	private String crew;
	private int passengers;
	private int cargo_capacity;
	private String consumables;
	private String hyperdrive_rating;
	private int mgl;
	private String starship_class;
	private List<String> pilots;
	private List<String> films;
	private Date created;
	private Date edited;
	private String utl;


}
