package com.edutech.cursosycontenidos.services;

import com.edutech.cursosycontenidos.dto.CursoDTO;
import com.edutech.cursosycontenidos.models.Curso;
import com.edutech.cursosycontenidos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    //Para Guardar los Cursos nuevos
    public CursoDTO guardar(CursoDTO dto) {
        Curso curso = toEntity(dto);
        Curso saved = repository.save(curso);
        return toDTO(saved);
    }

    //Para obtener una Lista de CursoDTO con todos los cursos Existentes
    public List<CursoDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //Buscar curso por ID
    public Optional<CursoDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    //Actualiza los datos de un curso Existente
    public Optional<CursoDTO> actualizar(Integer id, CursoDTO dto) {
        return repository.findById(id)
                .map(curso -> {
                    curso.setNombreCurso(dto.getNombreCurso());
                    curso.setDescripcion(dto.getDescripcion());
                    curso.setFechaCreacion(dto.getFechaCreacion()); // Ahora ambos son LocalDate
                    curso.setEstado(dto.getEstado());
                    curso.setPrecio(dto.getPrecio());               // Ahora el método existe
                    Curso actualizado = repository.save(curso);
                    return toDTO(actualizado);
                });
    }

    //Para Eliminar un curso de la base de datos
    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Métodos auxiliares---

    //Convierte una entidad Curso a un DTO
    private CursoDTO toDTO(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setIdCurso(curso.getIdCurso());
        dto.setNombreCurso(curso.getNombreCurso());
        dto.setDescripcion(curso.getDescripcion());
        dto.setFechaCreacion(curso.getFechaCreacion()); // Ahora ambos son LocalDate
        dto.setEstado(curso.getEstado());
        dto.setPrecio(curso.getPrecio());               // Ahora el método existe
        return dto;
    }

    //Convierte un DTO a una entidad Curso
    private Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setIdCurso(dto.getIdCurso());
        curso.setNombreCurso(dto.getNombreCurso());
        curso.setDescripcion(dto.getDescripcion());
        curso.setFechaCreacion(dto.getFechaCreacion()); // Ahora ambos son LocalDate
        curso.setEstado(dto.getEstado());
        curso.setPrecio(dto.getPrecio());               // Ahora el método existe
        return curso;
    }
}