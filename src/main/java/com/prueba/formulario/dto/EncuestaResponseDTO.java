package com.prueba.formulario.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncuestaResponseDTO {
	
	private Long idEncuestaCreada;
	
	private Long numeroDocumento;
	
	private String email;
	
	private String comentarios;
	
	private MarcaComputadorDTO marcaPCSeleccionada;
	
	private Date fechaRespuesta;
	
}
