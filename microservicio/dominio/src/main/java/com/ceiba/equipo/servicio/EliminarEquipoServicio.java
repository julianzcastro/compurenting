package com.ceiba.equipo.servicio;

import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;

public class EliminarEquipoServicio {
    private EquipoRepositorio equipoRepositorio;

    public EliminarEquipoServicio(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }

    public void ejecutar(Long id){
        this.equipoRepositorio.eliminar(id);
    }
}
