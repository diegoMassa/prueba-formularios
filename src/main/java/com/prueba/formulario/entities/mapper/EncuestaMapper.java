package com.prueba.formulario.entities.mapper;

import java.util.Date;

import com.prueba.formulario.dto.EncuestaRequestDTO;
import com.prueba.formulario.dto.EncuestaResponseDTO;
import com.prueba.formulario.entities.Encuesta;
import com.prueba.formulario.entities.MarcaComputador;

public class EncuestaMapper {

	/**
	 * 
	 * @param encuestaDTO
	 * @return
	 */
	public static Encuesta convertDTOToEntity(EncuestaRequestDTO encuestaDTO, MarcaComputador marcaComputador) {
		return Encuesta.builder()
				.numeroDocumento(encuestaDTO.getNumeroDocumento())
				.email(encuestaDTO.getEmail())
				.comentarios(encuestaDTO.getComentarios())
				.marcaComputador(marcaComputador)
				.fechaRespuesta(new Date())
				.build();
	}

	/**
	 * 
	 * @param encuestaEntity
	 * @return
	 */
	public static EncuestaResponseDTO convertEntityToResponseDTO(Encuesta encuestaEntity) {
		return EncuestaResponseDTO.builder()
				.idEncuestaCreada(encuestaEntity.getId())
				.numeroDocumento(encuestaEntity.getNumeroDocumento())
				.email(encuestaEntity.getEmail())
				.comentarios(encuestaEntity.getComentarios())
				.marcaPCSeleccionada(MarcaComputadorMapper.convertEntityToDTO(encuestaEntity.getMarcaComputador()))
				.fechaRespuesta(encuestaEntity.getFechaRespuesta())
				.build();
	}
}