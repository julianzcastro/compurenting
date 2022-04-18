package com.ceiba.prestamo.modelo.dto;

import com.ceiba.equipo.modelo.entidad.Equipo;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PrestamoDTO {
    private Long id;
    private String identificacionUsuario;
    private LocalDate fechaPrestamo;
    private Long idEquipo;
    private Integer numeroDias;
    private Integer total;

}
