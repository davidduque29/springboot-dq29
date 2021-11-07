package com.colegio.dto.api.rest.converter;

import java.util.Optional;

import com.colegio.dto.api.rest.dto.EstudianteDto;
import com.colegio.dto.api.rest.entity.Estudiante;

public class Converter extends AbstractConverter<Estudiante, EstudianteDto>{

	// convertir de ENTITY a DTO 
	@Override
	public EstudianteDto fromEntity(Estudiante entity) {
		 if(entity == null) return null;
       return EstudianteDto.builder()
               .id(entity.getId())
               .nombre(entity.getNombre())
               .identificacion(entity.getIdentificacion())
               .apellido(entity.getApellido())
               .fechaNacimiento(entity.getFechaNacimiento())
               .build();
	
	}	
	
	// convertir de DTO A ENTITY 
	@Override
	public Estudiante fromDTO(EstudianteDto dto) {
      if(dto == null) return null;
      return Estudiante.builder()
    		  .id(dto.getId())
              .nombre(dto.getNombre())
              .identificacion(dto.getIdentificacion())
              .apellido(dto.getApellido())
              .fechaNacimiento(dto.getFechaNacimiento())
              .build();
	
	}

	@Override
	public EstudianteDto fromEntity(Optional<Estudiante> entity) {
		 if(entity == null) return null;
	       return EstudianteDto.builder()
	               .id(entity.get().getId())
	               .nombre(entity.get().getNombre())
	               .identificacion(entity.get().getIdentificacion())
	               .apellido(entity.get().getApellido())
	               .fechaNacimiento(entity.get().getFechaNacimiento())
	               .build();
	}

	@Override
	public Estudiante fromDTO(Optional<EstudianteDto> dto) {
	      if(dto == null) return null;
	      return Estudiante.builder()
	    		  .id(dto.get().getId())
	              .nombre(dto.get().getNombre())
	              .identificacion(dto.get().getIdentificacion())
	              .apellido(dto.get().getApellido())
	              .fechaNacimiento(dto.get().getFechaNacimiento())
	              .build();
	}

}
