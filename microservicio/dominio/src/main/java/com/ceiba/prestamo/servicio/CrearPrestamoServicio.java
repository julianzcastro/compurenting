package com.ceiba.prestamo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;

public class CrearPrestamoServicio {

    private static final String PRESTAMO_YA_EXISTE="El préstamo que intenta registrar ya existe en el sistema.";
    private static final String IDENTIFICACION_USUARIO_TIENE_PRESTAMO_ACTIVO="El usuario ya tiene un préstamo activo, registrado en el sistema.";
    private static final String EQUIPO_NO_ESTA_DISPONIBLE="El equipo ingresado tiene otro préstamo activo registrado en el sistema.";

    private final PrestamoRepositorio prestamoRepositorio;
    private final EquipoRepositorio equipoRepositorio;

    public CrearPrestamoServicio(PrestamoRepositorio prestamoRepositorio, EquipoRepositorio equipoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
        this.equipoRepositorio = equipoRepositorio;
    }

    public Long ejecutar(Prestamo prestamo){
        validarExistenciaPrevia(prestamo);
        validarPorIdentificacion(prestamo.getIdentificacionUsuario());
        validarDisponibilidadEquipo(prestamo.getEquipo().getId());
        cambiarDisponibilidadEquipo(prestamo.getEquipo());
        return this.prestamoRepositorio.crear(prestamo);
    }

    private void validarExistenciaPrevia(Prestamo prestamo) {
        boolean existe = this.prestamoRepositorio.existeporId(prestamo.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(PRESTAMO_YA_EXISTE);
        }
    }

    private void cambiarDisponibilidadEquipo(Equipo equipo){
        this.equipoRepositorio.actualizarDisponibilidad(equipo);
    }

    private void validarDisponibilidadEquipo(Long idEquipo) {
        boolean disponible = this.equipoRepositorio.disponible(idEquipo);
        if(!disponible){
            throw new ExcepcionDuplicidad(EQUIPO_NO_ESTA_DISPONIBLE);
        }
    }

    private void validarPorIdentificacion(String identificacionUsuario){
        boolean tienePrestamoActivo = this.prestamoRepositorio.existeIdentificacionConPrestamoActivo(identificacionUsuario);
        if(tienePrestamoActivo){
            throw new ExcepcionDuplicidad(IDENTIFICACION_USUARIO_TIENE_PRESTAMO_ACTIVO);
        }
    }

}
