package com.hrullo.examen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrullo.examen.dto.CountryDto;
import com.hrullo.examen.dto.ItemTypeDto;
import com.hrullo.examen.dto.OrderPriorityDto;
import com.hrullo.examen.dto.RegionDto;
import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.dto.SalesChannelsDto;
import com.hrullo.examen.persistencia.entidades.BeanCsv;


public interface CsvService {

	Resumen  ordenarYguardar(String path);
	
	List<RegionDto> agrupaRegion(List<BeanCsv>lista);
	
	List<CountryDto> agrupaCountry(List<BeanCsv>lista);
	List<ItemTypeDto> agrupaItem(List<BeanCsv>lista);
	List<SalesChannelsDto> agrupaSales(List<BeanCsv>lista);
	List<OrderPriorityDto> agrupaOrderPriority(List<BeanCsv>lista);
	
	
}
