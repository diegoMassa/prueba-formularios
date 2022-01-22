package com.prueba.formulario.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MarcaComputadorDTO {

	private Long id;
	
	private String descripcion;
	
	private String estado;
}