package com.ceiba.equipo.fabrica;


import com.ceiba.equipo.fabrica.EquipoCreacional;
import com.ceiba.equipo.modelo.entidad.Equipo;

public class FabricaEntidadEquipoCreacional {
    public static EquipoCreacional crear(Equipo equipo){
        return new EquipoCreacional(
                equipo.getId(),
                equipo.getSerial(),
                equipo.getMarca(),
                equipo.isDisponible(),
                equipo.getTipoEquipo().getDescripcion()
        );
    }
}
