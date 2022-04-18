package com.ceiba.equipo.comando.manejador;

import com.ceiba.equipo.comando.ComandoEquipo;
import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.servicio.ActualizarEquipoServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEquipo implements ManejadorComando<ComandoEquipo> {

    private final FabricaEquipo fabricaEquipo;
    private final ActualizarEquipoServicio actualizarEquipoServicio;

    public ManejadorActualizarEquipo(FabricaEquipo fabricaEquipo, ActualizarEquipoServicio actualizarEquipoServicio) {
        this.fabricaEquipo = fabricaEquipo;
        this.actualizarEquipoServicio = actualizarEquipoServicio;
    }
    public void ejecutar(ComandoEquipo comandoEquipo){
        Equipo equipo = this.fabricaEquipo.crear(comandoEquipo);
        this.actualizarEquipoServicio.ejecutar(equipo);
    }
}
