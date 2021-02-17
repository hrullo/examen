package com.hrullo.examen.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hrullo.examen.persistencia.entidades.People;

@Repository
public interface PeopleRepositorio extends JpaRepository<People, String>{

}
