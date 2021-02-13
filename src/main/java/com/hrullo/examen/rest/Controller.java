package com.hrullo.examen.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.persistencia.entidades.BeanCsv;
import com.hrullo.examen.service.CsvService;




@RestController
@RequestMapping("/api/v1")
public class Controller {

	@Autowired
	private CsvService csvService;
	
	 @PostMapping("/cargar")
	   private ResponseEntity<Resumen>  cargar   (@RequestBody String path) {
	    
		csvService.ordenarYguardar(path);
		 
		 return new ResponseEntity<Resumen>(new Resumen(),HttpStatus.OK); 
	  }


}
