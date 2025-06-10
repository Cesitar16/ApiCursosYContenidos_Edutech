package com.edutech.cursosycontenidos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {
    private Integer idCurso;
    private String nombreCurso;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;
    private int precio;
    private Long usuarioId; // ID del instructor (USUARIO_id_user)
    private CategoriaDTO categoria; // Objeto de Categoría anidado
    private List<ModuloDTO> modulos; // Lista de módulos del curso
}