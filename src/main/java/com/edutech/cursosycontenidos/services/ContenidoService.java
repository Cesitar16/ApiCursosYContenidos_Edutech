package com.edutech.cursosycontenidos.services;

import com.edutech.cursosycontenidos.dto.ContenidoDTO;
import com.edutech.cursosycontenidos.models.Contenido;
import com.edutech.cursosycontenidos.repository.ContenidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContenidoService {

    @Autowired
    private ContenidoRepository repository;

    //Para Guardar los Contenidos nuevos
    public ContenidoDTO guardar(ContenidoDTO dto) {
        Contenido contenido = toEntity(dto);
        Contenido saved = repository.save(contenido);
        return toDTO(saved);
    }

    //Para obtener una Lista de ContenidoDTO con todos los contenidos Existentes
    public List<ContenidoDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //Buscar contenido por ID
    public Optional<ContenidoDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    //Actualiza los datos de un contenido Existente
    public Optional<ContenidoDTO> actualizar(Integer id, ContenidoDTO dto) {
        return repository.findById(id)
                .map(contenido -> {
                    contenido.setTipo(dto.getTipo());
                    contenido.setUrlArchivo(dto.getUrlArchivo());
                    Contenido actualizado = repository.save(contenido);
                    return toDTO(actualizado);
                });
    }

    //Para Eliminar un contenido de la base de datos
    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Métodos auxiliares---

    //Convierte una entidad Contenido a un DTO
    private ContenidoDTO toDTO(Contenido contenido) {
        ContenidoDTO dto = new ContenidoDTO();
        dto.setIdContenido(contenido.getIdContenido());
        dto.setTipo(contenido.getTipo());
        dto.setUrlArchivo(contenido.getUrlArchivo());
        return dto;
    }

    //Convierte un DTO a una entidad Contenido
    private Contenido toEntity(ContenidoDTO dto) {
        Contenido contenido = new Contenido();
        contenido.setIdContenido(dto.getIdContenido());
        contenido.setTipo(dto.getTipo());
        contenido.setUrlArchivo(dto.getUrlArchivo());
        return contenido;
    }
}