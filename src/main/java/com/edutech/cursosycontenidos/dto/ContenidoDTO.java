package com.edutech.cursosycontenidos.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContenidoDTO {
    private Integer idContenido;
    private String tipo;
    private String urlArchivo;
    private Long moduloId; // Solo el ID del módulo al que pertenece
}