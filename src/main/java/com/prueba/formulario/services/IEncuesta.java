package com.prueba.formulario.services;

import java.util.List;

import com.prueba.formulario.dto.EncuestaRequestDTO;
import com.prueba.formulario.dto.EncuestaResponseDTO;

public interface IEncuesta {

	public EncuestaResponseDTO save(EncuestaRequestDTO encuestaDTO);
	
	public List<EncuestaResponseDTO> findAll();
	
	public void delete(Long encuestaId);
	
}