package com.ceiba.equipo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.equipo.comando.ComandoEquipo;
import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.servicio.CrearEquipoServicio;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEquipo implements ManejadorComandoRespuesta<ComandoEquipo, ComandoRespuesta<Long>> {
    private final FabricaEquipo fabricaEquipo;
    private final CrearEquipoServicio crearEquipoServicio;

    public ManejadorCrearEquipo(FabricaEquipo fabricaEquipo, CrearEquipoServicio crearEquipoServicio) {
        this.fabricaEquipo = fabricaEquipo;
        this.crearEquipoServicio = crearEquipoServicio;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoEquipo comandoEquipo) {
        Equipo equipo = this.fabricaEquipo.crear(comandoEquipo);
        return new ComandoRespuesta<>(this.crearEquipoServicio.ejecutar(equipo));
    }
}
