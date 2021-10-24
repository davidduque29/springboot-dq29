package com.demo.crud.api.rest.controller;

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

import com.demo.crud.api.rest.dto.RegistroEmpleadoDTO;
import com.demo.crud.api.rest.entity.RegistroEmpleado;
import com.demo.crud.api.rest.service.RegistroEmpleadoService;

@RestController
public class RegistroEmpleadoController {

	@Autowired
	private RegistroEmpleadoService registroEmpleadoService;
	
	@PostMapping("/empleado")
    public ResponseEntity<RegistroEmpleado> addEmpleado(@RequestBody RegistroEmpleado empleado)
    {
	
        RegistroEmpleado crearEmpleado = registroEmpleadoService.agregarEmpleado(empleado);
        return new ResponseEntity<>(crearEmpleado, HttpStatus.CREATED); 
    }
	@GetMapping("/listados")
    public ResponseEntity<List<RegistroEmpleado>> getAllEmpleados()
    {
        List<RegistroEmpleado> listarEmpleados = registroEmpleadoService.findAllEmpleados();
        return new ResponseEntity<>(listarEmpleados, HttpStatus.OK);
    }
	@GetMapping("/buscarempleado/{id}")
    public ResponseEntity<Optional<RegistroEmpleado>> getEmpleadoById(@PathVariable("id") Long id)
    {
		Optional<RegistroEmpleado> buscarEmpleado = registroEmpleadoService.findEmpleadoById(id);
        return new ResponseEntity<>(buscarEmpleado, HttpStatus.OK);
    }
		
	@PutMapping("/actualizar/{id}")
    public ResponseEntity<Optional<RegistroEmpleado>> updateUsuarioId(@PathVariable("id") Long usuarioId, @RequestBody RegistroEmpleado empleado)
    {
		Optional<RegistroEmpleado> actualizarUsuario = registroEmpleadoService.updateUsuarioId(usuarioId, empleado);
        return new ResponseEntity<>(actualizarUsuario, HttpStatus.OK);
    }
	@DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("id") Long id)
    {
		registroEmpleadoService.deleteUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
