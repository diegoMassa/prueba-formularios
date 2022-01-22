package com.prueba.formulario.entities.mapper;

import com.prueba.formulario.dto.MarcaComputadorDTO;
import com.prueba.formulario.entities.MarcaComputador;

public class MarcaComputadorMapper {

	/**
	 * 
	 * @param marcaComputador
	 * @return
	 */
	public static MarcaComputadorDTO convertEntityToDTO(MarcaComputador marcaComputador) {
		return MarcaComputadorDTO.builder()
				.id(marcaComputador.getId())
				.descripcion(marcaComputador.getDescripcion())
				.estado(marcaComputador.getEstado())
				.build();
	}
}