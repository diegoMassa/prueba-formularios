package com.prueba.formulario.controllers;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.formulario.dto.EncuestaRequestDTO;
import com.prueba.formulario.dto.EncuestaResponseDTO;
import com.prueba.formulario.dto.ErrorsDTO;
import com.prueba.formulario.services.IEncuesta;

@RestController
@RequestMapping("/encuesta")
public class EncuestaController {
	
	@Autowired
	private IEncuesta encuestaService;
	
	@Autowired
	private Validator validator;

	
	/**
	 * Get All Forms
	 * @return
	 */
	@GetMapping("/findAll")
	public ResponseEntity<List<EncuestaResponseDTO>> findAllEncuestas() {
		try {
			List<EncuestaResponseDTO> encuestas = encuestaService.findAll();
			
			if (encuestas == null || encuestas.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(encuestas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * Create a Form
	 * @param encuestaRequestDTO
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> createEncuesta(@RequestBody EncuestaRequestDTO encuestaRequestDTO) {
		try {
			Errors errors = new BeanPropertyBindingResult(encuestaRequestDTO, EncuestaRequestDTO.class.getName());
			validator.validate(encuestaRequestDTO, errors);
			if (errors.hasErrors()) {
				
				List<FieldError> listFieldErrors = errors.getFieldErrors();
				List<String> listErrors = new ArrayList<>();
				
				for (FieldError fieldError : listFieldErrors) {
					listErrors.add("El campo " + fieldError.getField() + " " + fieldError.getDefaultMessage());
				}
				return new ResponseEntity<>(ErrorsDTO.builder().listErrors(listErrors).build(), HttpStatus.BAD_REQUEST);
			}
			EncuestaResponseDTO responseDTO = encuestaService.save(encuestaRequestDTO);
			return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	/**
	 * Delete a Form By FormId
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Long id) {
		try {
			encuestaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}