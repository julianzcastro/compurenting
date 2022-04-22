package com.ceiba.equipo.fabrica;


import com.ceiba.equipo.modelo.entidad.Equipo;

public class FabricaEntidadEquipoTransaccional {
    public static EquipoTransaccional crear(Equipo equipo){
        return new EquipoTransaccional(
                equipo.getId(),
                equipo.getSerial(),
                equipo.getMarca(),
                equipo.isDisponible(),
                equipo.getTipoEquipo().getDescripcion()
        );
    }
}
