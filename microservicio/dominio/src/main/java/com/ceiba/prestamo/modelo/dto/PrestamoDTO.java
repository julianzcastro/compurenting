package com.ceiba.prestamo.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PrestamoDTO {

    private Long id;
    private String identificacionUsuario;
    private Long idEquipo;
    private LocalDate fechaPrestamo;
    private Integer numeroDias;
    private Integer total;
    private boolean estado;

}
