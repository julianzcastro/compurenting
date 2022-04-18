package com.ceiba.equipo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import com.ceiba.prestamo.servicio.ActualizarPrestamoServicio;

import java.time.LocalDate;

public class ActualizarEquipoServicio {

    private EquipoRepositorio equipoRepositorio;
    private PrestamoRepositorio prestamoRepositorio;
    private ActualizarPrestamoServicio actualizarPrestamoServicio;

    public ActualizarEquipoServicio(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }

    public void ejecutar(Equipo equipo){
        validarExistencia(equipo);
        validarCambioDisponibilidad(equipo);
        this.equipoRepositorio.actualizar(equipo);
    }

    private void validarExistencia(Equipo equipo){
        boolean existe = this.equipoRepositorio.existePorId(equipo.getId());
        if(!existe){

            throw new ExcepcionDuplicidad("El equipo no está registrado en el sistema");
        }
    }

    public void validarCambioDisponibilidad(Equipo equipo){
        if(equipo.isDisponible()){
            //this.actualizarPrestamoServicio.ejecutar(this.prestamoRepositorio.);
       }
    }
}
