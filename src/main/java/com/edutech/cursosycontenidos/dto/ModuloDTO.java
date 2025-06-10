package com.edutech.cursosycontenidos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuloDTO {
    private Integer idModulo;
    private String titulo;
    private int orden;
    private String descripcion;
    private Long cursoId; // Solo el ID del curso al que pertenece
    private List<ContenidoDTO> contenidos; // Lista de contenidos del módulo
}