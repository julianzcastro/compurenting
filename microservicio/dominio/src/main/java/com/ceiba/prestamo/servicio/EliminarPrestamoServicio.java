package com.ceiba.prestamo.servicio;

import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;

public class EliminarPrestamoServicio {
    private PrestamoRepositorio prestamoRepositorio;

    public EliminarPrestamoServicio(PrestamoRepositorio prestamoRepositorio) {
        this.prestamoRepositorio = prestamoRepositorio;
    }

    public void ejecutar(Long id){
        this.prestamoRepositorio.eliminar(id);
    }
}
