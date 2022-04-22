package com.ceiba.prestamo.fabrica;

import java.time.LocalDate;

public class PrestamoTransaccional {
    private Long id;
    private String identificacionUsuario;
    private Long idEquipo;
    private LocalDate fechaPrestamo;
    private Integer numeroDias;
    private Integer total;
    private boolean estado;

    public PrestamoTransaccional(Long id, String identificacionUsuario, Long idEquipo, LocalDate fechaPrestamo, Integer numeroDias, Integer total, boolean estado) {
        this.id = id;
        this.identificacionUsuario = identificacionUsuario;
        this.idEquipo = idEquipo;
        this.fechaPrestamo = fechaPrestamo;
        this.numeroDias = numeroDias;
        this.total = total;
        this.estado = estado;
    }
}
