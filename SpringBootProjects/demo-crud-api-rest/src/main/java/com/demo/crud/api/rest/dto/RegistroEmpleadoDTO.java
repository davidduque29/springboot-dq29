package com.demo.crud.api.rest.dto;

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
public class RegistroEmpleadoDTO {
    // El Dto trasnporta los datos para no dejarle esa funcion al entity
	private Long id;
	private String nombre;    
	private String apellido;    
	private String cargo;	
	private LocalDate fechaIngreso;
}
