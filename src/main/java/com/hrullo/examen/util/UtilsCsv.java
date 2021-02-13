package com.hrullo.examen.util;

import java.io.FileReader;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import com.hrullo.examen.dto.Resumen;
import com.hrullo.examen.persistencia.entidades.BeanCsv;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UtilsCsv {

	/*
	 * Metodo para la lectura del CSV
	 * 
	 * @param String Path del fichero
	 * 
	 * @return Lit de Objetos
	 * 
	 */

	public List<BeanCsv> leerFichero(String path) {

		String campos[] = null;
		List<BeanCsv> lista = new ArrayList<>();
		CSVReader csvReader = null;
		try {

			log.debug("Inicia la lectura del fichero :: " + path);

			csvReader = new CSVReader(new FileReader(path));

			// Compruebo que hay lineas en el fichero

			if (csvReader.readNext() != null) {

				// Me salto la linea de la cabecera

				csvReader.peek();

				while ((campos = csvReader.readNext()) != null) {

					int cont = 0;
					BeanCsv bean = new BeanCsv();
					bean.setRegion(campos[cont++]);
					bean.setCountry(campos[cont++]);
					bean.setItemType(campos[cont++]);
					bean.setSalesChannel(campos[cont++]);
					bean.setOrderPriority(campos[cont++]);
					bean.setOrderDate(campos[cont++]);
					bean.setOrderId(Integer.parseInt(campos[cont++]));
					bean.setShipDate(campos[cont++]);
					bean.setUnitsSold(Float.parseFloat(campos[cont++]));
					bean.setUnitPrice(Float.parseFloat(campos[cont++]));
					bean.setUnitCost(Float.parseFloat(campos[cont++]));
					bean.setTotalRevenue(Float.parseFloat(campos[cont++]));
					bean.setTotalCost(Float.parseFloat(campos[cont++]));
					bean.setTotalProfit(Float.parseFloat(campos[cont++]));

					lista.add(bean);

				}

			}

			log.debug("Ha terminado la lectura del fichero correctamente ::");
			csvReader.close();

		} catch (IOException | CsvValidationException | NumberFormatException e) {

			log.error("Se ha producido un error  al leer el fichero :: " + e.getMessage());

		}

		return lista;
	}

	/*
	 * Metodo que crea un nuevo CSV
	 * 
	 * @param Lista de Objetos y String del path
	 * 
	 */

	public boolean crearCsv(List<BeanCsv> lista, String path) {

		try {

			log.debug("Comienza la escritura del fichero :: " + path);
			Writer writer = new FileWriter(path);
			StatefulBeanToCsv<BeanCsv> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();

			beanToCsv.write(lista);
			log.debug("Fichero creado correctamente ::");

			writer.close();
		} catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			log.error("Se ha producido un error al intentar escribir el fichero :: " + e.getMessage());

		}

		return true;
	}
	
	


}
