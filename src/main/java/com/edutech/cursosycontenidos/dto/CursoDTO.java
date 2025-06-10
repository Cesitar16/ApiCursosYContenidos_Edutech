package com.edutech.cursosycontenidos.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CursoDTO {
    private Integer idCurso;
    private String nombreCurso;
    private String descripcion;
    private LocalDate fechaCreacion;
    private String estado;
    private int precio;
    private Integer usuarioId;
    private CategoriaDTO categoria;
}