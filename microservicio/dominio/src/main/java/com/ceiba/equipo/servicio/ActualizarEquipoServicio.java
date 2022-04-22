package com.ceiba.equipo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;

public class ActualizarEquipoServicio {

    private EquipoRepositorio equipoRepositorio;

    public ActualizarEquipoServicio(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }

    public void ejecutar(Equipo equipo){
        validarExistencia(equipo);
        this.equipoRepositorio.actualizar(equipo);
    }

    private void validarExistencia(Equipo equipo){
        boolean existe = this.equipoRepositorio.existePorId(equipo.getId());
        if(!existe){
            throw new ExcepcionDuplicidad("El equipo no está registrado en el sistema");
        }
    }


}
