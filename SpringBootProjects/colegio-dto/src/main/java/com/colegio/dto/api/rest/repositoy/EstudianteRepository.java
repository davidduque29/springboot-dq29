package com.colegio.dto.api.rest.repositoy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.colegio.dto.api.rest.entity.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
	Optional<Estudiante> findEstudianteById(Long id);
}
