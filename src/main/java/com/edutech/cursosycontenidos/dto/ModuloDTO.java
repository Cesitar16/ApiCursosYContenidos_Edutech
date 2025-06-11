package com.edutech.cursosycontenidos.dto;

import lombok.Data;

@Data
public class ModuloDTO {
    private Integer idModulo;
    private String titulo;
    private int orden;
    private String descripcion;
    private Integer cursoId;
}