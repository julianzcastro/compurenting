package com.ceiba.prestamo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.equipo.comando.ComandoEquipo;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.prestamo.comando.ComandoPrestamo;
import com.ceiba.prestamo.comando.fabrica.FabricaPrestamo;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.CrearPrestamoServicio;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPrestamo implements ManejadorComandoRespuesta<ComandoPrestamo, ComandoRespuesta<Long>> {
    private final FabricaPrestamo fabricaPrestamo;
    private final CrearPrestamoServicio crearPrestamoServicio;

    public ManejadorCrearPrestamo(FabricaPrestamo fabricaPrestamo, CrearPrestamoServicio crearPrestamoServicio) {
        this.fabricaPrestamo = fabricaPrestamo;
        this.crearPrestamoServicio = crearPrestamoServicio;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoPrestamo comandoPrestamo){
        Prestamo prestamo = this.fabricaPrestamo.crear(comandoPrestamo);
        return new ComandoRespuesta<>(this.crearPrestamoServicio.ejecutar(prestamo));
    }
}
