package com.prueba.formulario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.formulario.entities.MarcaComputador;

public interface MarcaComputadorRepository extends JpaRepository<MarcaComputador, Long> {

}