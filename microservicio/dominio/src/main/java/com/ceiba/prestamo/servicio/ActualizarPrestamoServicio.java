package com.ceiba.prestamo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.prestamo.modelo.dto.PrestamoDTO;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;

import java.time.LocalDate;

public class ActualizarPrestamoServicio {
    private static final String PRESTAMO_NO_EXISTE="El préstamo que intenta actualizar no está registrado en el sistema.";
    private PrestamoRepositorio prestamoRepositorio;

    public ActualizarPrestamoServicio(PrestamoRepositorio prestamoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
    }
    public void ejecutar(Prestamo prestamo) {
        validarExistenciaPrevia(prestamo);
        this.prestamoRepositorio.actualizar(prestamo);
    }

    private void validarExistenciaPrevia(Prestamo prestamo) {
        boolean existe = this.prestamoRepositorio.existeporId(prestamo.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(PRESTAMO_NO_EXISTE);
        }
    }

    public static void asignarTotal(Prestamo prestamo){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDevolucion = prestamo.getFechaPrestamo();
        if(prestamo.getEquipo().isDisponible()&& fechaActual.isAfter(fechaDevolucion)){
            prestamo.calcularExcedente(fechaActual.getDayOfMonth()-fechaDevolucion.getDayOfMonth());
        }
    }

}
