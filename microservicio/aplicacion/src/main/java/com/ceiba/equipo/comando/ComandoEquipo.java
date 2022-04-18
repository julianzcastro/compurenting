package com.ceiba.equipo.comando;

import com.ceiba.tipoequipo.TipoEquipoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoEquipo {
    private Long id;
    private String serial;
    private String marca;
    private boolean disponible;
    private String tipoEquipo;
}
