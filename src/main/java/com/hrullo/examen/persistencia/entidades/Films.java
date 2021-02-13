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
//@Table(name="FILMS")
public class Films {


private String title;
private String opening_crawl;
private String director;
private String producer;
private Date release_date; 
private List<String> characters;	
private List<String> planets;
private List<String> starships;
private List<String> vehicles;
private List<String> species;
private Date created; 
private Date edited;
private String url;
}
