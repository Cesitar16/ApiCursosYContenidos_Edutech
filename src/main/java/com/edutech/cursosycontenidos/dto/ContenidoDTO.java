package com.edutech.cursosycontenidos.dto;

import lombok.Data;

@Data
public class ContenidoDTO {
    private Integer idContenido;
    private String tipo;
    private String urlArchivo;
    private Integer moduloId;
}