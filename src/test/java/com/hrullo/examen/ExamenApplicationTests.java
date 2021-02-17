package com.hrullo.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.dto.ResumenFilms;
import com.hrullo.examen.persistencia.entidades.BeanCsv;
import com.hrullo.examen.persistencia.entidades.People;
import com.hrullo.examen.service.CsvService;
import com.hrullo.examen.service.StartWarsService;
import com.hrullo.examen.simulator.Constantes;
import com.hrullo.examen.util.UtilsCsv;


@WebAppConfiguration
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
class ExamenApplicationTests {

	@Value("${fichero.entrada.path}")
	private String pathEntrada;

	@Value("${fichero.salida.path}")
	private String pathSalida;

	@Autowired
	private CsvService csvService;
	

	@Autowired
	private StartWarsService starWarService;;

	private ClassLoader classLoader = getClass().getClassLoader();

	@Autowired
	protected WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper mapper;



	@BeforeEach
	void setUp() {
		
		mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	
	}

	@Test
	void leerFicheroTest() {

		UtilsCsv read = new UtilsCsv();
		List<BeanCsv> lista = read.leerFichero(classLoader.getResource(pathEntrada).getFile());

		assertThat((lista == null));
		assertThat(!lista.isEmpty());

	}

	@Test
	void crearFicheroTest() throws IOException {

		UtilsCsv read = new UtilsCsv();
		List<BeanCsv> lista = read.leerFichero(classLoader.getResource(pathEntrada).getFile());
		assertThat(read.crearCsv(lista, pathEntrada));

	}

	@Test
	void agruparObjetosTest() {

		UtilsCsv read = new UtilsCsv();
		List<BeanCsv> lista = read.leerFichero(classLoader.getResource(pathEntrada).getFile());
		assertThat(!csvService.agrupaCountry(lista).isEmpty());
		assertThat(!csvService.agrupaItem(lista).isEmpty());
		assertThat(!csvService.agrupaOrderPriority(lista).isEmpty());
		assertThat(!csvService.agrupaRegion(lista).isEmpty());
		assertThat(!csvService.agrupaSales(lista).isEmpty());

	}

	@Test
	void ordenarYguardarTest() {

		Resumen resumen = csvService.ordenarYguardar(classLoader.getResource(pathEntrada).getFile());
		assertThat(resumen);

	}

	@Test
	void guardarEntidadesStarWarsTest() {
		assertThat(starWarService.guardarFilms());
		assertThat(starWarService.guardarPeople());
		assertThat(starWarService.guardarStarShips());

	}
	
	@Test
	void mostrarPersonasTest() throws JsonMappingException, JsonProcessingException {
		
		List<People> listaP = starWarService.guardarPeople();
	     ResumenFilms resumen =	starWarService.mostrarPersonas(listaP);	
	     
	     String resumenS = mapper.writeValueAsString(resumen.getResumen());
	     
	 assertThat(resumenS.equals(Constantes.RESUEMEN_FILMS));
	
	}
	

	@Test
	void cargarFicheroTest() throws Exception {
	
		MvcResult resultado = mockMvc.perform(post("/api/v1/cargar")
							.contentType(MediaType.APPLICATION_JSON)
							.content("{\"path\":\""+pathEntrada+"\"}"))
							.andExpect(status().isOk())
							.andReturn();
		String response = resultado.getResponse().getContentAsString();
		
		assertThat(response.equals(Constantes.RESPUESTA_CSV));
		
      
	}
	
	@Test
	void guardarTest() throws Exception {
		
		MvcResult resultado = mockMvc.perform(get("/api/v1/guardar"))
				.andExpect(status().isOk())
				.andReturn();
		
		String response = resultado.getResponse().getContentAsString();
		
		assertThat(response.equals(Constantes.RESUEMEN_FILMS));
		
		
	}

	
	
	
}
