package com.ceiba.prestamo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPrestamo {
    private Long id;
    private String identificacionUsuario;
    private LocalDate fechaPrestamo;
    private Long idEquipo;
    private Integer numeroDias;
    private Integer total;
}
