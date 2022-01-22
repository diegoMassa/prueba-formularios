package com.prueba.formulario.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.formulario.dto.EncuestaRequestDTO;
import com.prueba.formulario.dto.EncuestaResponseDTO;
import com.prueba.formulario.entities.Encuesta;
import com.prueba.formulario.entities.MarcaComputador;
import com.prueba.formulario.entities.mapper.EncuestaMapper;
import com.prueba.formulario.repositories.EncuestaRepository;
import com.prueba.formulario.repositories.MarcaComputadorRepository;


/**
 * Para cada servicio -> Obtendre el Objeto Encuesta y lo convierto en un DTO y Viceversa,
 * esto con la finalidad de hacerlo mas escalable y manteniendo isoladas las capas de la
 * arquitectura del codigo
*/
@Service
public class EncuestaImpl implements IEncuesta{

	@Autowired
	private EncuestaRepository encuestaRepository;
	
	@Autowired 
	private MarcaComputadorRepository marcaComputadorRepository;
	
	/**
	 * 
	 */
	@Override
	public EncuestaResponseDTO save(EncuestaRequestDTO encuestaDTO) {
		
		// Get the Marca by Id selected
		Optional<MarcaComputador> marcaSeleccionada = marcaComputadorRepository
				.findById(encuestaDTO.getIdMarcaSeleccionada());
		
		Encuesta encuestaEntity = encuestaRepository.save(EncuestaMapper.convertDTOToEntity(encuestaDTO,
				marcaSeleccionada.isPresent() ? marcaSeleccionada.get() : null));
		
		return EncuestaMapper.convertEntityToResponseDTO(encuestaEntity);
	}

	/**
	 * 
	 */
	@Override
	public List<EncuestaResponseDTO> findAll() {
		return encuestaRepository.findAll().stream().map(EncuestaMapper::convertEntityToResponseDTO).collect(Collectors.toList());
	}

	/**
	 * 
	 */
	@Override
	public void delete(Long encuestaId) {
		encuestaRepository.delete(encuestaRepository.findById(encuestaId).get());
	}

}
