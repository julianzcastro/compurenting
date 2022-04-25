package com.ceiba.prestamo.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;


public class FinalizarPrestamoServicio {
    private static final String PRESTAMO_NO_EXISTE="El prestamo que intenta finalizar no existe en el sistema.";
    private final PrestamoRepositorio prestamoRepositorio;

    public FinalizarPrestamoServicio(PrestamoRepositorio prestamoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
    }

    public void ejecutar(Long id){
        validarExistencia(id);
        Prestamo prestamo = this.prestamoRepositorio.buscarPorId(id);
        prestamo.asignarTotal();
        this.prestamoRepositorio.finalizar(prestamo);
    }

    private void validarExistencia(Long id) {
        boolean existe = this.prestamoRepositorio.existeporId(id);
        if(!existe){
            throw new ExcepcionDuplicidad(PRESTAMO_NO_EXISTE);
        }
    }


}
