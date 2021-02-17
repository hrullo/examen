package com.hrullo.examen.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hrullo.examen.configuracion.dominio.PathCsv;
import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.dto.ResumenFilms;
import com.hrullo.examen.dto.ResumenPeopleFilms;
import com.hrullo.examen.service.CsvService;
import com.hrullo.examen.service.StartWarsService;
import com.hrullo.examen.util.Constantes;




@RestController
@RequestMapping("/api/v1")
public class Controller {

	@Autowired
	private CsvService csvService;
	
	@Autowired
	private StartWarsService startService;
	
	
	
	 @PostMapping("/cargar")
	   private ResponseEntity<Resumen>  cargar   (@RequestBody PathCsv path) {
		 
		Resumen resumen = 	csvService.ordenarYguardar(path.getPath());

		 return new ResponseEntity<Resumen>(resumen,HttpStatus.OK); 
	  }
	 
	 @GetMapping("/guardar")
	 private ResponseEntity<ResumenFilms> guardarEntidades(){
		 
		 startService.guardarFilms();
		 ResumenFilms resumen= startService.mostrarPersonas(startService.guardarPeople());
		 startService.guardarStarShips();
		
		 return new ResponseEntity<>(resumen,HttpStatus.OK);
	 }}
