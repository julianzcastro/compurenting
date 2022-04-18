package com.ceiba.prestamo.comando.manejador;

import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.EliminarPrestamoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPrestamo {
    private final EliminarPrestamoServicio eliminarPrestamoServicio;

    public ManejadorEliminarPrestamo(EliminarPrestamoServicio eliminarPrestamoServicio) {
        this.eliminarPrestamoServicio = eliminarPrestamoServicio;
    }

    public void ejecutar(Long idPrestramo){
        this.eliminarPrestamoServicio.ejecutar(idPrestramo);
    }
}
