package com.hrullo.examen.persistencia.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

//@Entity
//@Table(name = "PEOPLE")
public class People {

	private String name;

	private String height;
	private String mass;
	private String hair_color;
	private String skin_color;
	private String eye_color;
	private String birth_year;
	private String gender;
	private String homeworld;
	private List<String> films;
	private List<String> species;
	private List<String> vehicles;
	private List<String> starships;
	private Date created;
	private Date edited;
	private String url;
}
