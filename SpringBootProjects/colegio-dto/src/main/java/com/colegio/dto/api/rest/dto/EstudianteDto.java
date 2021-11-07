package com.colegio.dto.api.rest.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteDto{ // transporta la informacion entre capas
	Long id;
	String nombre;
	String apellido;
	Integer identificacion;
	LocalDate fechaNacimiento;
}
