package com.hrullo.examen.serviceImpl;

import java.beans.Beans;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hrullo.examen.persistencia.entidades.BeanCsv;
import com.hrullo.examen.persistencia.repositorio.CsvRepositorio;
import com.hrullo.examen.service.CsvService;
import com.hrullo.examen.util.UtilsCsv;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CsvServiceImpl implements CsvService {

	@Autowired
	private CsvRepositorio repo;
	
	@Autowired
	private UtilsCsv utilCsv;
	
	@Value("${fichero.salida.path}")
	private String pathSalida;
	
	@Override
	public boolean ordenarYguardar(String path) {
		
	List<BeanCsv> lista = utilCsv.leerFichero(path);
	
	//Se ordena la lista por orderId
	
	Collections.sort(lista);
	
	
	//Se guarda datos
	
	lista.forEach((final  BeanCsv bean) ->  repo.save(bean));
	
	//Se crea el fichero
	
	List<BeanCsv> listaB =repo.findAll();
	
	listaB.forEach((final BeanCsv beans)-> log.info(beans.getRegion()));
	
	return utilCsv.crearCsv(lista, pathSalida);
	
	}

}
