package com.hrullo.examen.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrullo.examen.configuracion.dominio.PathCsv;
import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.persistencia.entidades.BeanCsv;
import com.hrullo.examen.service.CsvService;




@RestController
@RequestMapping("/api/v1")
public class Controller {

	@Autowired
	private CsvService csvService;
	
	
	
	 @PostMapping("/cargar")
	   private ResponseEntity<Resumen>  cargar   (@RequestBody PathCsv path) {
		 
		Resumen resumen = 	csvService.ordenarYguardar(path.getPath());

		 return new ResponseEntity<Resumen>(resumen,HttpStatus.OK); 
	  }


}
