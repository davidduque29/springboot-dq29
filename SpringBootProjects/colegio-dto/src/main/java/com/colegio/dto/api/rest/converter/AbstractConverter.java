package com.colegio.dto.api.rest.converter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E,D> {//Entidad, DTO
    //tenga la capacidad de convertir de entidad a DTO y de DTO a entidad, pero el tambien que me permita convertir listas.
    public abstract D fromEntity(E entity); //convertir de entidad a DTO, va regresar DTO
    public abstract D fromEntity(Optional<E> entity);
    public abstract E fromDTO(D dto); // convertir de DTO a entidad
    public abstract E fromDTO(Optional<D> dto);
    public List<D> fromEntity(List<E> entitys){
        // convertir listas
        return entitys.stream()
            .map(e -> fromEntity(e))
            .collect(Collectors.toList());
    }
   
    public List<E> fromDTO(List<D> dtos){
        // convertir listas
        return dtos.stream()
            .map(e -> fromDTO(e))
            .collect(Collectors.toList());
    }
    public List<D> fromOptionalEntity(List<Optional<E>> entitys){
        // convertir listas  
        return entitys.stream()
            .map(e -> fromEntity(e))
            .collect(Collectors.toList());
    }
    public List<E> fromOptionalDTO(List<Optional<D>> dtos){
        // convertir listas
        return dtos.stream()
            .map(e -> fromDTO(e))
            .collect(Collectors.toList());
    }
   
}
