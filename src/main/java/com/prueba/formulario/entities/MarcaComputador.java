package com.prueba.formulario.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@Entity
@Table(name = "marca_pc")
@NoArgsConstructor
@AllArgsConstructor
public class MarcaComputador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "marca_id")
	private Long id;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
}