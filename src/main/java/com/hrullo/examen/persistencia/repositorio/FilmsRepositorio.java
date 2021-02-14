package com.hrullo.examen.persistencia.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrullo.examen.persistencia.entidades.Films;

public interface FilmsRepositorio extends JpaRepository<Films, String> {

}
