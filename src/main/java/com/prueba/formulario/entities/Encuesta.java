package com.prueba.formulario.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "encuesta")
@NoArgsConstructor
@AllArgsConstructor
public class Encuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "encuesta_id")
	private Long id;
	
	@Column(name = "numero_documento")
	private Long numeroDocumento;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "comentarios")
	private String comentarios;
	
	@ManyToOne
	@JoinColumn(name = "marca_id")
	private MarcaComputador marcaComputador;
	
	@Column(name = "fecha_respuesta")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date fechaRespuesta;	
}