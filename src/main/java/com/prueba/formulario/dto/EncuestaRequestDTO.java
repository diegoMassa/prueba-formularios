package com.prueba.formulario.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EncuestaRequestDTO {

	@NotNull(message = "Es obligatorio")
	private Long numeroDocumento;
	
	@Email
	@NotNull(message = "Es obligatorio")
	private String email;
	
	@NotNull(message = "Es obligatorio")
	private String comentarios;
	
	@NotNull(message = "Es obligatorio")
	private Long idMarcaSeleccionada;
}