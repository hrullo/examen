package com.hrullo.examen.persistencia.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hrullo.examen.dto.RegionDto;
import com.hrullo.examen.persistencia.entidades.BeanCsv;

@Repository
public interface CsvRepositorio extends JpaRepository<BeanCsv,Integer> {
	

}
