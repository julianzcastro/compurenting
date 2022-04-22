package com.ceiba.prestamo.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.prestamo.comando.ComandoPrestamo;
import com.ceiba.prestamo.comando.manejador.ManejadorActualizarPrestamo;
import com.ceiba.prestamo.comando.manejador.ManejadorCrearPrestamo;
import com.ceiba.prestamo.comando.manejador.ManejadorFinalizarPrestamo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamos")
@Api(tags = { "Controlador comando equipos"})
public class ComandoControladorPrestamo {
    private final ManejadorCrearPrestamo manejadorCrearPrestamo;
    private final ManejadorActualizarPrestamo manejadorActualizarPrestamo;
    private final ManejadorFinalizarPrestamo manejadorFinalizarPrestamo;

    @Autowired
    public ComandoControladorPrestamo(ManejadorCrearPrestamo manejadorCrearPrestamo, ManejadorActualizarPrestamo manejadorActualizarPrestamo, ManejadorFinalizarPrestamo manejadorFinalizarPrestamo) {
        this.manejadorCrearPrestamo = manejadorCrearPrestamo;
        this.manejadorActualizarPrestamo = manejadorActualizarPrestamo;
        this.manejadorFinalizarPrestamo = manejadorFinalizarPrestamo;
    }

    @PostMapping
    @ApiOperation("Crear Prestamo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPrestamo comandoPrestamo){
        return manejadorCrearPrestamo.ejecutar(comandoPrestamo);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Prestamo")
    public void actualizar(@RequestBody ComandoPrestamo comandoPrestamo, @PathVariable Long id){
        comandoPrestamo.setId(id);
        manejadorActualizarPrestamo.ejecutar(comandoPrestamo);
    }

    @PutMapping(value="/finalizar/{id}")
    @ApiOperation("Finalizar Prestamo")
    public void finalizar(@PathVariable Long id){
        manejadorFinalizarPrestamo.ejecutar(id);
    }
}
