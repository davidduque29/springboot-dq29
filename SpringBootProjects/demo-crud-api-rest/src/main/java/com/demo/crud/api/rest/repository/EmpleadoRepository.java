package com.demo.crud.api.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.crud.api.rest.entity.RegistroEmpleado;
 //entidad -> <RegistroEmpleado, Long> <- tipo de dato
@Repository
public interface EmpleadoRepository extends JpaRepository<RegistroEmpleado, Long>{
// DTO transporta la informacion de datos a la capa Service
	Optional<RegistroEmpleado> findEmpleadoById(Long id);
		
}
