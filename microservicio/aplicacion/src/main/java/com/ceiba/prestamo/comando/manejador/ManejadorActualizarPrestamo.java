package com.ceiba.prestamo.comando.manejador;

import com.ceiba.prestamo.comando.ComandoPrestamo;
import com.ceiba.prestamo.comando.fabrica.FabricaPrestamo;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.ActualizarPrestamoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPrestamo {
    private final FabricaPrestamo fabricaPrestamo;
    private final ActualizarPrestamoServicio actualizarPrestamoServicio;

    public ManejadorActualizarPrestamo(FabricaPrestamo fabricaPrestamo, ActualizarPrestamoServicio actualizarPrestamoServicio) {
        this.fabricaPrestamo = fabricaPrestamo;
        this.actualizarPrestamoServicio = actualizarPrestamoServicio;
    }

    public void ejecutar(ComandoPrestamo comandoPrestamo){
        Prestamo prestamo = this.fabricaPrestamo.crear(comandoPrestamo);
        this.actualizarPrestamoServicio.ejecutar(prestamo);
    }
}
