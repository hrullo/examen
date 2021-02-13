package com.hrullo.examen.configuracion;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hrullo.examen.util.UtilsCsv;
import com.opencsv.CSVReader;

@Configuration
public class Configuracion {
	
	@Bean
	public UtilsCsv utilCsv() {
		
		return new UtilsCsv();
	}
	

}
