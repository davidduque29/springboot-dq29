package com.colegio.dto.api.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.colegio.dto.api.rest.converter. Converter;
import com.colegio.dto.api.rest.dto.EstudianteDto;
import com.colegio.dto.api.rest.entity.Estudiante;
import com.colegio.dto.api.rest.service.EstudianteService;
import com.colegio.dto.api.rest.dto.EstudianteDto;

@RestController
public class EstudianteController {

	@Autowired
	EstudianteService estudianteService;
	
	private  Converter estudianteConverter = new  Converter();
	
	@PostMapping("/estudiante")
    public ResponseEntity<EstudianteDto> addEstudiante(@RequestBody EstudianteDto estudiante)
    {	
		Estudiante crearEstudiante = estudianteService.registrarEstudiante(estudianteConverter.fromDTO(estudiante));
        EstudianteDto estudianteDto =  estudianteConverter.fromEntity(crearEstudiante);
        return new ResponseEntity<EstudianteDto>(estudianteDto, HttpStatus.CREATED); 
    }
	@GetMapping("/listados")
    public ResponseEntity<List<EstudianteDto>> getAllEmpleados()
    {
		List<Estudiante> listarEstudiantes = estudianteService.findAllEstudiantes();
        List<EstudianteDto> listarEstudiantesDto = estudianteConverter.fromEntity(listarEstudiantes) ;
        return new ResponseEntity<List<EstudianteDto>>(listarEstudiantesDto, HttpStatus.OK);
    }
	@GetMapping("/buscarestudiante/{id}")
    public ResponseEntity<EstudianteDto> getEmpleadoById(@PathVariable("id") Long id)
    {
		Optional<Estudiante> buscarEstudiante = estudianteService.findEstudianteById(id) ;
		EstudianteDto buscarEstudianteDto = estudianteConverter.fromEntity(buscarEstudiante) ;
        return new ResponseEntity<EstudianteDto>(buscarEstudianteDto, HttpStatus.OK);
    }
		
	@PutMapping("/actualizar/{id}")
    public ResponseEntity<EstudianteDto> updateEstudianteId(@PathVariable("id") Long usuarioId, @RequestBody EstudianteDto estudiante)
    {
		Optional<Estudiante> updateEstudiante = estudianteService.updateEstudianteId(usuarioId, estudianteConverter.fromDTO(estudiante)) ;
		EstudianteDto actualizarEstudiante =  estudianteConverter.fromEntity(updateEstudiante);
        return new ResponseEntity<EstudianteDto>(actualizarEstudiante, HttpStatus.OK);
    }
	@DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Long id)
    {
		 
		estudianteService.deleteEstudiante(id) ;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
