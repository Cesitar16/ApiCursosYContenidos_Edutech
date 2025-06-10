package com.edutech.cursosycontenidos.services;

import com.edutech.cursosycontenidos.dto.ModuloDTO;
import com.edutech.cursosycontenidos.models.Modulo;
import com.edutech.cursosycontenidos.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository repository;

    //Para Guardar los Modulos nuevos
    public ModuloDTO guardar(ModuloDTO dto) {
        Modulo modulo = toEntity(dto);
        Modulo saved = repository.save(modulo);
        return toDTO(saved);
    }

    //Para obtener una Lista de ModuloDTO con todos los modulos Existentes
    public List<ModuloDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //Buscar modulo por ID
    public Optional<ModuloDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    //Actualiza los datos de un modulo Existente
    public Optional<ModuloDTO> actualizar(Integer id, ModuloDTO dto) {
        return repository.findById(id)
                .map(modulo -> {
                    modulo.setTitulo(dto.getTitulo());
                    modulo.setOrden(dto.getOrden());
                    modulo.setDescripcion(dto.getDescripcion());
                    Modulo actualizado = repository.save(modulo);
                    return toDTO(actualizado);
                });
    }

    //Para Eliminar un modulo de la base de datos
    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Métodos auxiliares---

    //Convierte una entidad Modulo a un DTO
    private ModuloDTO toDTO(Modulo modulo) {
        ModuloDTO dto = new ModuloDTO();
        dto.setIdModulo(modulo.getIdMdoulo());
        dto.setTitulo(modulo.getTitulo());
        dto.setOrden(modulo.getOrden());
        dto.setDescripcion(modulo.getDescripcion());
        return dto;
    }

    //Convierte un DTO a una entidad Modulo
    private Modulo toEntity(ModuloDTO dto) {
        Modulo modulo = new Modulo();
        modulo.setIdMdoulo(dto.getIdModulo());
        modulo.setTitulo(dto.getTitulo());
        modulo.setOrden(dto.getOrden());
        modulo.setDescripcion(dto.getDescripcion());
        return modulo;
    }
}