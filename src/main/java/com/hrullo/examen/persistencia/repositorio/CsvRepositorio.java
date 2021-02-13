package com.hrullo.examen.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrullo.examen.persistencia.entidades.BeanCsv;

@Repository
public interface CsvRepositorio extends JpaRepository<BeanCsv,Integer> {

}
