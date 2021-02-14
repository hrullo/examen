package com.hrullo.examen.persistencia.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@Entity
@Table(name = "PEOPLE")
public class People {

	@Id
	@Column(name="NAME")
	private String name;
	@Column(name="HEIGHT")
	private String height;
	@Column(name="MASS")
	private String mass;
	@Column(name="HAIRCOLOR")
	@JsonProperty("hair_color")
	private String haircolor;
	@Column(name="SKINCOLOR")
	@JsonProperty("skin_color")
	private String skincolor;
	@Column(name="EYECOLOR")
	@JsonProperty("eye_color")
	private String eyecolor;
	@Column(name="BIRTHYEAR")
	@JsonProperty("birth_year")
	private String birthyear;
	@Column(name="GENDER")
	private String gender;
	@Column(name="HOMEWORLD")
	private String homeworld;
	@Column(name="FILMS")
	@ElementCollection(targetClass=String.class)
	private List<String> films;
	@Column(name="SPECIES")
	@ElementCollection(targetClass=String.class)
	private List<String> species;
	@Column(name="VEHICLES")
	@ElementCollection(targetClass=String.class)
	private List<String> vehicles;
	@Column(name="STARSHIPS")
	@ElementCollection(targetClass=String.class)
	private List<String> starships;
	@Column(name="CREATED")
	private Date created;
	@Column(name="EDITED")
	private Date edited;
	@Column(name="URL")
	private String url;
}
