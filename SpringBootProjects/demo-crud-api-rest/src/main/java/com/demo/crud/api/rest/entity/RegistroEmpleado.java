package com.demo.crud.api.rest.entity;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleados")
public class RegistroEmpleado {
//	crtl+shit+o para importar todas las anotaciones 
	@Id  
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
    @Column(name = "nombre")
	private String nombre;
    
    @Column(name = "apellido")
	private String apellido;
    
    @Column(name = "cargo")
	private String cargo;
	
	@Column(name = "fechaIngreso")
	private LocalDate fechaIngreso;
	
}
