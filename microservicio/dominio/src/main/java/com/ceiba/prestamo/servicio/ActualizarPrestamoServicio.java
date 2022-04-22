package com.ceiba.prestamo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;


public class ActualizarPrestamoServicio {
    private static final String PRESTAMO_NO_EXISTE="El préstamo que intenta actualizar no está registrado en el sistema.";
    private static final String EQUIPO_NO_EXISTE="El equipo que intenta agregar al préstamo no está registrado en el sistema.";
    private static final String EQUIPO_NO_ESTA_DISPONIBLE="El equipo que intenta actualizar al préstamo no está disponible.";
    private PrestamoRepositorio prestamoRepositorio;
    private EquipoRepositorio equipoRepositorio;

    public ActualizarPrestamoServicio(PrestamoRepositorio prestamoRepositorio, EquipoRepositorio equipoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
        this.equipoRepositorio = equipoRepositorio;
    }

    public void ejecutar(Prestamo prestamo) {
        validarExistenciaPrevia(prestamo);
        validarExistenciaEquipoPorId(prestamo.getEquipo().getId());
        validarEquipoEnOtroPrestamo(prestamo);
        validarDisponinibilidadEquipoPorId(prestamo.getEquipo().getId());
        this.prestamoRepositorio.actualizar(prestamo);
    }

    private void validarExistenciaPrevia(Prestamo prestamo) {
        boolean existe = this.prestamoRepositorio.existeporId(prestamo.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(PRESTAMO_NO_EXISTE);
        }
    }

    private void validarExistenciaEquipoPorId(Long idEquipo){
        boolean existe= this.equipoRepositorio.existePorId(idEquipo);
        if(!existe){
            throw new ExcepcionDuplicidad(EQUIPO_NO_EXISTE);
        }
    }

    private void validarEquipoEnOtroPrestamo(Prestamo prestamo){
        Prestamo prestamoPrevio = this.prestamoRepositorio.buscarPorId(prestamo.getId());
        if(!prestamo.getEquipo().getId().equals(prestamoPrevio.getEquipo().getId())){
            validarDisponinibilidadEquipoPorId(prestamo.getEquipo().getId());
        }
    }

    private void validarDisponinibilidadEquipoPorId(Long idEquipo){
        boolean estaDisponible = this.equipoRepositorio.verificarDisponibilidadPorId(idEquipo);
        if(!estaDisponible){
            throw new ExcepcionDuplicidad(EQUIPO_NO_ESTA_DISPONIBLE);
        }
    }
    
}
