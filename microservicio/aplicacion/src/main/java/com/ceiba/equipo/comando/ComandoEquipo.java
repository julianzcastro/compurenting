package com.ceiba.equipo.comando;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEquipo {
    private Long id;
    private String serial;
    private String marca;
    private boolean disponible;
    private String tipoEquipo;
}
