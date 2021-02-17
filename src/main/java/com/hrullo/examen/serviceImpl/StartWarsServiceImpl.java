package com.hrullo.examen.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrullo.examen.dto.ListaFilms;
import com.hrullo.examen.dto.ListaPeople;
import com.hrullo.examen.dto.ListaStarShip;
import com.hrullo.examen.dto.ResumenFilms;
import com.hrullo.examen.dto.ResumenPeopleFilms;
import com.hrullo.examen.persistencia.entidades.Films;
import com.hrullo.examen.persistencia.entidades.People;
import com.hrullo.examen.persistencia.entidades.Starships;
import com.hrullo.examen.persistencia.repositorio.FilmsRepositorio;
import com.hrullo.examen.persistencia.repositorio.PeopleRepositorio;
import com.hrullo.examen.persistencia.repositorio.StarshipRepositorio;
import com.hrullo.examen.service.StartWarsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StartWarsServiceImpl implements StartWarsService {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${startwars.films.endpoint}")
	private String endpintFilms;

	@Value("${startwars.people.endpoint}")
	private String endpointPeople;

	@Value("${startwars.starship.endpoint}")
	private String endpointShip;

	@Autowired
	private ObjectMapper mapper;

	@Autowired
	private FilmsRepositorio filmsRepo;

	@Autowired
	private PeopleRepositorio peopleRepo;

	@Autowired
	private StarshipRepositorio shipRepo;

	/**
	 * Metodo encargado de recuperar la entidad y guardarla
	 * 
	 * @return booleano
	 * */
	
	@Override
	public boolean guardarFilms() {

		// Se realiza la llamada al servicio
		String result = restTemplate.getForObject(endpintFilms, String.class);
		ListaFilms lista = null;
		try {
			lista = mapper.readValue(result, ListaFilms.class);
		} catch (JsonMappingException e) {
			log.error("Se ha producido un error al realizar el mapeo " + e.getMessage());
		} catch (JsonProcessingException e) {
			log.error("Se ha producido un error  " + e.getMessage());
		}

		List<Films> listaFilms = lista.getResults();

		// Se guada los films
		listaFilms.forEach((final Films films) -> filmsRepo.save(films));

		return true;
	}

	/**
	 * Metodo encargado de recuperar la entidad y guardarla
	 * 
	 * @return booleano
	 * */
	
	
	@Override
	public List<People> guardarPeople() {

		// Se realiza la llamada al servicio
		String result = restTemplate.getForObject(endpointPeople, String.class);
		ListaPeople lista = null;
		try {
			lista = mapper.readValue(result, ListaPeople.class);
		} catch (JsonMappingException e) {
			log.error("Se ha producido un error al realizar el mapeo " + e.getMessage());
		} catch (JsonProcessingException e) {
			log.error("Se ha producido un error  " + e.getMessage());
		}

		List<People> listaPeople = lista.getResults();

		// Se guada los films
		listaPeople.forEach((final People people) -> peopleRepo.save(people));

		return listaPeople;
	}
	
	/**
	 * Metodo encargado de recuperar la entidad y guardarla
	 * 
	 * @return booleano
	 * */

	@Override
	public boolean guardarStarShips() {

		// Se realiza la llamada al servicio
		String result = restTemplate.getForObject(endpointShip, String.class);
		ListaStarShip lista = null;
		try {
			lista = mapper.readValue(result, ListaStarShip.class);
		} catch (JsonMappingException e) {
			log.error("Se ha producido un error al realizar el mapeo " + e.getMessage());
		} catch (JsonProcessingException e) {
			log.error("Se ha producido un error  " + e.getMessage());
		}

		List<Starships> listaShip = lista.getResults();

		// Se guada los films
		listaShip.forEach((final Starships ship) -> shipRepo.save(ship));

		return true;
	}
	/**
	 * Metodo encargado de mostrar la realcion de Personas y Films
	 * 
	 * @return ResumenFilms retorna Objecto a mostar
	 * */
	
	@Override
	public ResumenFilms mostrarPersonas(List<People> listaP){

		ResumenFilms resumen = new ResumenFilms();	
		List<ResumenPeopleFilms> listaResumen = new ArrayList<ResumenPeopleFilms>();
		
		for (People p : listaP) {
			log.debug("Se recupera datos de la persona::");
			ResumenPeopleFilms resumenP = new ResumenPeopleFilms();
			resumenP.setPersona(p.getName());
			resumenP.setCantidad(p.getFilms().size());
			List<String> titulos = new ArrayList<String>();
		
			for (String url : p.getFilms()) {
			
				String resultF = restTemplate.getForObject(url, String.class);

				Films film;
				try {
					
					log.info("Recuperando Films de las personas");
					film = mapper.readValue(resultF, Films.class);
					
					titulos.add(film.getTitle());

				} catch (JsonProcessingException e) {
					
					log.error("Ha ocurrido un error::");
				}
	
			}

			resumenP.setTitulos(titulos);

			listaResumen.add(resumenP);
			
		}
		resumen.setResumen(listaResumen);
		return resumen;

	}

}
