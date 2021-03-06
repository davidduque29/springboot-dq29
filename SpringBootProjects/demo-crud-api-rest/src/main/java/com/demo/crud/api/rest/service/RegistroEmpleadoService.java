package com.demo.crud.api.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.crud.api.rest.dto.RegistroEmpleadoDTO;
import com.demo.crud.api.rest.entity.RegistroEmpleado;
import com.demo.crud.api.rest.repository.EmpleadoRepository;

@Service
public class RegistroEmpleadoService{

	@Autowired
	//El repository es equivalente al DAO
	private EmpleadoRepository empleadoRepository;
	
	public RegistroEmpleado agregarEmpleado(RegistroEmpleado registroEmpleado) {
		return empleadoRepository.save(registroEmpleado); // se va para el controller
	}
	public RegistroEmpleado editarEmpleado(RegistroEmpleado registroEmpleado) {
		
		return empleadoRepository.save(registroEmpleado); // se va para el controller
	}
	public List<RegistroEmpleado> findAllEmpleados(){
        return empleadoRepository.findAll();
    }
	public Optional<RegistroEmpleado> findEmpleadoById(Long id)
    {
        return empleadoRepository.findEmpleadoById(id);     
    }
	public Optional<RegistroEmpleado> updateUsuarioId(Long usuarioId, RegistroEmpleado empleadoReq )
    {
		  return empleadoRepository.findById(usuarioId).map(empleado -> {
	        	empleado.setNombre(empleadoReq.getNombre());
	        	empleado.setApellido(empleadoReq.getApellido());
	        	empleado.setCargo(empleadoReq.getCargo());
	        	empleado.setFechaIngreso(empleadoReq.getFechaIngreso());
            return empleadoRepository.save(empleado);
        });
    }
	public void deleteUsuario(Long id)
    {
		empleadoRepository.deleteById(id);
    }
}
