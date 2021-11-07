package com.colegio.dto.api.rest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.colegio.dto.api.rest.entity.Estudiante;
import com.colegio.dto.api.rest.repositoy.EstudianteRepository;


@Service
public class EstudianteService {
	@Autowired
	EstudianteRepository estudianteRepository;

	public static LocalDate getLocalDate() {
		return LocalDate.now();
	}

	public Estudiante registrarEstudiante(@RequestBody Estudiante estudiante) {
		// estudiante.setFechaNacimiento(getLocalDate());

		return estudianteRepository.save(estudiante);
	}

	public Estudiante editarEstudiante(Estudiante registroEmpleado) {

		return estudianteRepository.save(registroEmpleado); // se va para el controller
	}

	public List<Estudiante> findAllEstudiantes() {
		return estudianteRepository.findAll();
	}
	
	public Optional<Estudiante> findEstudianteById(Long id) {
		return estudianteRepository.findEstudianteById(id) ;
	}
	public Optional<Estudiante> updateEstudianteId(Long usuarioId, Estudiante estudianteReq) {
		return estudianteRepository.findById(usuarioId).map(estudiante -> {
			estudiante.setNombre(estudianteReq.getNombre());
			estudiante.setApellido(estudianteReq.getApellido());
			estudiante.setIdentificacion(estudianteReq.getIdentificacion());
			estudiante.setFechaNacimiento(estudianteReq.getFechaNacimiento());
			return estudianteRepository.save(estudiante);
		});
	}
	public void deleteEstudiante(Long id) {
		estudianteRepository.deleteById(id);
	}
 
}
