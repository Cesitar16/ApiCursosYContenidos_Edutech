package com.edutech.cursosycontenidos.services;

import com.edutech.cursosycontenidos.dto.CategoriaDTO;
import com.edutech.cursosycontenidos.models.Categoria;
import com.edutech.cursosycontenidos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    //Para Guardar las Categorias nuevas
    public CategoriaDTO guardar(CategoriaDTO dto) {
        Categoria categoria = toEntity(dto);
        Categoria saved = repository.save(categoria);
        return toDTO(saved);
    }

    //Para obtener una Lista de CategoriaDTO con todas las categorias Existentes
    public List<CategoriaDTO> listar() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    //Buscar categoria por ID
    public Optional<CategoriaDTO> obtenerPorId(Integer id) {
        return repository.findById(id)
                .map(this::toDTO);
    }

    //Actualiza los datos de una categoria Existente
    public Optional<CategoriaDTO> actualizar(Integer id, CategoriaDTO dto) {
        return repository.findById(id)
                .map(categoria -> {
                    categoria.setNombreCate(dto.getNombreCate());
                    Categoria actualizado = repository.save(categoria);
                    return toDTO(actualizado);
                });
    }

    //Para Eliminar una categoria de la base de datos
    public boolean eliminar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // --- Métodos auxiliares---

    //Convierte una entidad Categoria a un DTO
    private CategoriaDTO toDTO(Categoria categoria) {
        CategoriaDTO dto = new CategoriaDTO();
        dto.setIdCategoria(categoria.getIdCategoria());
        dto.setNombreCate(categoria.getNombreCate());
        return dto;
    }

    //Convierte un DTO a una entidad Categoria
    private Categoria toEntity(CategoriaDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setIdCategoria(dto.getIdCategoria());
        categoria.setNombreCate(dto.getNombreCate());
        return categoria;
    }
}