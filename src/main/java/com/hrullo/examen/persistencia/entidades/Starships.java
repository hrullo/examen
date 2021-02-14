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
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name="STARSHIPS")
public class Starships {

	@Id
	@Column(name = "NAME")
	private String name;
	@Column(name = "MODEL")
	private String model;
	@Column(name = "MANUFACTURER")
	private String manufacturer;
	@Column(name = "LENGTH")
	private String length;
	@Column(name = "COSTINCREDITS")
	@JsonProperty("cost_in_credits")
	private String costInCredits;
	@Column(name = "MAXATMOSPHERINGSPEED")
	@JsonProperty("max_atmosphering_speed")
	private String max_atmospheringspeed;
	@Column(name = "CREW")
	private String crew;
	@Column(name = "PASSENGERS")
	private String passengers;
	@Column(name = "CARGOCAPACITY")
	@JsonProperty("cargo_capacity")
	private String cargocapacity;
	@Column(name = "CONSUMABLES")
	private String consumables;
	@Column(name = "HYPERDRIVERATING")
	@JsonProperty("hyperdrive_rating")
	private String hyperdriverating;
	@Column(name = "MGLT")
	@JsonProperty("MGLT")
	private String mglt;
	@Column(name = "STARSHIPCLASS")
	@JsonProperty("starship_class")
	private String starshipclass;
	@Column(name = "PILOTS")
	@ElementCollection(targetClass=String.class)
	private List<String> pilots;
	@Column(name = "FILMS")
	@ElementCollection(targetClass=String.class)
	private List<String> films;
	@Column(name = "CREATED")
	private Date created;
	@Column(name = "EDITED")
	private Date edited;
	@Column(name = "URL")
	private String url;


}
