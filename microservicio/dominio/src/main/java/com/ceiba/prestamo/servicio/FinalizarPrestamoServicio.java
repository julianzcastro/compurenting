package com.ceiba.prestamo.servicio;

import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;

import static com.ceiba.prestamo.modelo.entidad.Prestamo.asignarTotal;

public class FinalizarPrestamoServicio {
    private final PrestamoRepositorio prestamoRepositorio;

    public FinalizarPrestamoServicio(PrestamoRepositorio prestamoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
    }

    public void ejecutar(Long id){
        Prestamo prestamo = this.prestamoRepositorio.buscarPorId(id);
        asignarTotal(prestamo);
        this.prestamoRepositorio.finalizar(prestamo);
    }


}
