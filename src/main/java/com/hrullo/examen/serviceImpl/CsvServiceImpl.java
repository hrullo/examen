package com.hrullo.examen.serviceImpl;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.hrullo.examen.dto.CountryDto;
import com.hrullo.examen.dto.ItemTypeDto;
import com.hrullo.examen.dto.OrderPriorityDto;
import com.hrullo.examen.dto.RegionDto;
import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.dto.SalesChannelsDto;
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
	public Resumen ordenarYguardar(String path) {

		Resumen resumen = new Resumen();
		
		List<BeanCsv> lista = utilCsv.leerFichero(path);

		// Se ordena la lista por orderId

		Collections.sort(lista);

		// Se guarda datos

		lista.forEach((final BeanCsv bean) -> repo.save(bean));

		// Se crea el fichero
		utilCsv.crearCsv(lista, pathSalida);
		
		//Se crea la respuesta
		resumen.setRegiones(agrupaRegion(lista));
		resumen.setItemsTyle(agrupaItem(lista));
		resumen.setOrders(agrupaOrderPriority(lista));
		resumen.setSalesChannels(agrupaSales(lista));
		resumen.setCountry(agrupaCountry(lista));

		return resumen;
		
	}

	@Override
	public List<RegionDto> agrupaRegion(List<BeanCsv> lista) {

		List<RegionDto> listaR = new ArrayList<>();
		Map<String, List<BeanCsv>> regiones = lista.stream().collect(Collectors.groupingBy(BeanCsv::getRegion));

		for (String key : regiones.keySet()) {
			RegionDto region = new RegionDto();
			region.setCantidad(regiones.get(key).size());
			region.setRegion(key);
			listaR.add(region);
		}

		return listaR;
	}

	@Override
	public List<CountryDto> agrupaCountry(List<BeanCsv> lista) {

		List<CountryDto> listaC = new ArrayList<>();
		Map<String, List<BeanCsv>> countries = lista.stream().collect(Collectors.groupingBy(BeanCsv::getCountry));

		for (String key : countries.keySet()) {
			CountryDto country = new CountryDto();
			country.setCantidad(countries.get(key).size());
			country.setCountry(key);

			listaC.add(country);
		}

		return listaC;
	}

	@Override
	public List<ItemTypeDto> agrupaItem(List<BeanCsv> lista) {
	
		List<ItemTypeDto> listaI = new ArrayList<>();
		
		Map<String, List<BeanCsv>> items = lista.stream().collect(Collectors.groupingBy(BeanCsv::getItemType));

		for (String key : items.keySet()) {
			ItemTypeDto item = new ItemTypeDto();
			item.setCantidad(items.get(key).size());
			item.setItemType(key);

			listaI.add(item);
		}

		return listaI;
	}

	@Override
	public List<SalesChannelsDto> agrupaSales(List<BeanCsv> lista) {

		List<SalesChannelsDto> listaS = new ArrayList<>();
		
		Map<String, List<BeanCsv>> salesChan = lista.stream().collect(Collectors.groupingBy(BeanCsv::getSalesChannel));

		for (String key : salesChan.keySet()) {
			SalesChannelsDto sales = new SalesChannelsDto();
			sales.setCantidad(salesChan.get(key).size());
			sales.setSalesChannels(key);

			listaS.add(sales);
		}

		return listaS;
	}
	

	@Override
	public List<OrderPriorityDto> agrupaOrderPriority(List<BeanCsv> lista) {
		
		List<OrderPriorityDto> listaO = new ArrayList<>();
		
		Map<String, List<BeanCsv>> orders = lista.stream().collect(Collectors.groupingBy(BeanCsv::getOrderPriority));

		for (String key : orders.keySet()) {
			OrderPriorityDto order = new OrderPriorityDto();
			order.setCantidad(orders.get(key).size());
			order.setOrderPriority(key);

			listaO.add(order);
		}

		return listaO;
			
		
	}

}
