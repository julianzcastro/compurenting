package com.ceiba.equipo.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;

public class CrearEquipoServicio {

    private static final String SERIAL_EQUIPO_YA_EXISTE="El serial del equipo ya está registrado en el sistema.";
    private final EquipoRepositorio equipoRepositorio;

    public CrearEquipoServicio(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }
    public Long ejecutar(Equipo equipo){
        validarExistenciaEquipo(equipo);
        return this.equipoRepositorio.crear(equipo);
    }

    private void validarExistenciaEquipo(Equipo equipo) {
        boolean existe = this.equipoRepositorio.existePorSerial(equipo.getSerial());
        if(existe){
            throw new ExcepcionDuplicidad(SERIAL_EQUIPO_YA_EXISTE);
        }
    }

}
