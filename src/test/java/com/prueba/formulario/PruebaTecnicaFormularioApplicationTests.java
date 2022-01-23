package com.prueba.formulario;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.prueba.formulario.dto.EncuestaRequestDTO;
import com.prueba.formulario.dto.EncuestaResponseDTO;
import com.prueba.formulario.services.IEncuesta;

@SpringBootTest
class PruebaTecnicaFormularioApplicationTests {

	@Autowired
	private IEncuesta encuestaService;
	
	@Test
	public void givenEncuestaRequest_whenSaveAndRetreiveEntity_thenOK() {
		EncuestaResponseDTO genericResponseDTO = encuestaService.save(EncuestaRequestDTO.builder()
				.numeroDocumento(1144040220L)
				.email("abc@xyz.com")
				.comentarios("N/A")
				.idMarcaSeleccionada(1L)
				.build());
		assertNotNull(genericResponseDTO);
	}
	
	
	@Test
	public void findAllForms_retreiveAllEntity_thenOK() {
		List<EncuestaResponseDTO> listEncuesta = encuestaService.findAll();
		assertNotNull(listEncuesta);
	}
}