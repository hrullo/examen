package com.hrullo.examen;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.persistencia.entidades.BeanCsv;
import com.hrullo.examen.service.CsvService;
import com.hrullo.examen.service.StartWarsService;
import com.hrullo.examen.util.UtilsCsv;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
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

	@Test
	public void leerFicheroTest() {

		UtilsCsv read = new UtilsCsv();
		List<BeanCsv> lista = read.leerFichero(classLoader.getResource(pathEntrada).getFile());

		boolean isOk = (lista.size() > 0) ? true : false;
		assertTrue(isOk);
		assertNotNull(lista);

	}

	// @Test
	public void crearFicheroTest() throws IOException {

		UtilsCsv read = new UtilsCsv();
		List<BeanCsv> lista = read.leerFichero(classLoader.getResource(pathEntrada).getFile());
		assertTrue(read.crearCsv(lista, pathSalida));

	}

//	@Test
	public void agruparObjetosTest() {

		UtilsCsv read = new UtilsCsv();
		List<BeanCsv> lista = read.leerFichero(classLoader.getResource(pathEntrada).getFile());
		assertNotNull(csvService.agrupaCountry(lista));
		assertNotNull(csvService.agrupaItem(lista));
		assertNotNull(csvService.agrupaOrderPriority(lista));
		assertNotNull(csvService.agrupaSales(lista));
		assertNotNull(csvService.agrupaRegion(lista));

	}

//	@Test
	public void ordenarYguardarTest() {

		Resumen resumen = csvService.ordenarYguardar(classLoader.getResource(pathEntrada).getFile());

		assertNotNull(resumen);

	}

	@Test
	public void guardarEntidadesStarWarsTest(){

		assertTrue(starWarService.guardarFilms());
		assertTrue(starWarService.guardarPeople());
		assertTrue(starWarService.guardarStarShips());
		
	}

}
