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



@Entity
@Table(name="films")
@Data
public class Films {

@Id
@Column(name = "TITLE")
private String title;
@Column(name = "EPISODEID")
@JsonProperty("episode_id")
private int episodeId;
@Column(name = "OPENINGCRAWL", length = 600)
@JsonProperty("opening_crawl")
private String openingcrawl;
@Column(name = "DIRECTOR")
private String director;
@Column(name = "PRODUCER")
private String producer;
@Column(name = "RELEASEDATE")
@JsonProperty("release_date")
private Date releaseDate; 
@Column(name = "CHARACTERS")
@ElementCollection(targetClass=String.class)
private List<String> characters;
@Column(name = "PLANETS")
@ElementCollection(targetClass=String.class)
private List<String> planets;
@Column(name = "STARSHIPS")
@ElementCollection(targetClass=String.class)
private List<String> starships;
@Column(name = "VEHICLES")
@ElementCollection(targetClass=String.class)
private List<String> vehicles;
@Column(name = "SPECIES")
@ElementCollection(targetClass=String.class)
private List<String> species;
@Column(name = "CREATED")
private Date created; 
@Column(name = "EDITED")
private Date edited;
@Column(name = "URL")
private String url;
}
