package com.hrullo.examen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrullo.examen.persistencia.entidades.BeanCsv;


public interface CsvService {

	boolean  ordenarYguardar(String path);
	
}
