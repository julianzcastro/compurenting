package com.ceiba.equipo.comando.manejador;

import com.ceiba.equipo.servicio.EliminarEquipoServicio;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarEquipo implements ManejadorComando<Long> {

    private final EliminarEquipoServicio eliminarEquipoServicio;

    public ManejadorEliminarEquipo(EliminarEquipoServicio eliminarEquipoServicio) {
        this.eliminarEquipoServicio = eliminarEquipoServicio;
    }

    public void ejecutar(Long idEquipo){
        this.eliminarEquipoServicio.ejecutar(idEquipo);
    }
}
