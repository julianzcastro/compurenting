package com.ceiba.equipo.modelo.dto;

import com.ceiba.tipoequipo.TipoEquipoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EquipoDTO {
    private Long id;
    private String serial;
    private String marca;
    private boolean disponible;
    private String tipoEquipo;

}
