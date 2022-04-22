package com.ceiba.prestamo.comando.manejador;

import com.ceiba.prestamo.servicio.FinalizarPrestamoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorFinalizarPrestamo {

    private final FinalizarPrestamoServicio finalizarPrestamoServicio;

    public ManejadorFinalizarPrestamo(FinalizarPrestamoServicio finalizarPrestamoServicio) {
        this.finalizarPrestamoServicio = finalizarPrestamoServicio;
    }

    public void ejecutar(Long id){
        this.finalizarPrestamoServicio.ejecutar(id);
    }
}
