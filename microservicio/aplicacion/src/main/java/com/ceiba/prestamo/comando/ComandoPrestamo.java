package com.ceiba.prestamo.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPrestamo {

    private Long id;
    private String identificacionUsuario;
    private Long idEquipo;
    private Integer numeroDias;

}
