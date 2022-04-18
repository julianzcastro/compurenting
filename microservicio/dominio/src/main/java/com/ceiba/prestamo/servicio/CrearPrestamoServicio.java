package com.ceiba.prestamo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;

public class CrearPrestamoServicio {

    private static final String PRESTAMO_YA_EXISTE="El préstamo que intenta registrar ya existe";
    private static final String IDENTIFICACION_USUARIO_TIENE_PRESTAMO_ACTIVO="El usuario ya tiene un préstamo activo, registrado en el sistema.";
    private static final String EQUIPO_NO_ESTA_DISPONIBLE="El equipo ingresado tiene otro préstamo activo registrado en el sistema.";

    private PrestamoRepositorio prestamoRepositorio;

    public CrearPrestamoServicio(PrestamoRepositorio prestamoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
    }

    public Long ejecutar(Prestamo prestamo){
        validarDisponibilidadEquipo(prestamo);
        validarPorIdentificacion(prestamo.getIdentificacionUsuario());
        validarExistenciaPrevia(prestamo);
        return this.prestamoRepositorio.crear(prestamo);
    }

    private void validarDisponibilidadEquipo(Prestamo prestamo) {
        boolean disponible = this.prestamoRepositorio.estadoDisponibleEquipo(prestamo.getEquipo().getId());
        if(!disponible){
            throw new ExcepcionDuplicidad(EQUIPO_NO_ESTA_DISPONIBLE);
        }
    }

    private void validarExistenciaPrevia(Prestamo prestamo) {
        boolean existe = this.prestamoRepositorio.existeporId(prestamo.getId());
        if(existe){
            throw new ExcepcionDuplicidad(PRESTAMO_YA_EXISTE);
        }
    }

    private void validarPorIdentificacion(String identificacionUsuario){
        boolean tienePrestamoActivo = this.prestamoRepositorio.existeIdentificacionConPrestamoActivo(identificacionUsuario);
        if(tienePrestamoActivo){
            throw new ExcepcionDuplicidad(IDENTIFICACION_USUARIO_TIENE_PRESTAMO_ACTIVO);
        }
    }

}
