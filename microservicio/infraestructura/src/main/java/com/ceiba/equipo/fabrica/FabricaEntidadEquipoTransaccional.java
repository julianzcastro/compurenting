package com.ceiba.equipo.fabrica;


import com.ceiba.equipo.modelo.entidad.Equipo;
import org.springframework.stereotype.Component;

@Component
public class FabricaEntidadEquipoTransaccional {

    public EquipoTransaccional crear(Equipo equipo){
        return new EquipoTransaccional(
                equipo.getId(),
                equipo.getSerial(),
                equipo.getMarca(),
                equipo.isDisponible(),
                equipo.getTipoEquipo().getDescripcion()
        );
    }
}
