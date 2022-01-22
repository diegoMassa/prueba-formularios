package com.prueba.formulario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.formulario.entities.Encuesta;

public interface EncuestaRepository extends JpaRepository<Encuesta, Long> {

}
