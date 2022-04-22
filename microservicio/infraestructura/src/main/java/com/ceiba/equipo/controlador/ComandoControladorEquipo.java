package com.ceiba.equipo.controlador;


import com.ceiba.ComandoRespuesta;
import com.ceiba.equipo.comando.ComandoEquipo;
import com.ceiba.equipo.comando.manejador.ManejadorActualizarEquipo;
import com.ceiba.equipo.comando.manejador.ManejadorCrearEquipo;
import com.ceiba.equipo.comando.manejador.ManejadorEliminarEquipo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/equipos")
@Api(tags = { "Controlador comando equipos"})
public class ComandoControladorEquipo {

    private final ManejadorCrearEquipo manejadorCrearEquipo;
    private final ManejadorActualizarEquipo manejadorActualizarEquipo;
    private final ManejadorEliminarEquipo manejadorEliminarEquipo;

    @Autowired
    public ComandoControladorEquipo(ManejadorCrearEquipo manejadorCrearEquipo, ManejadorActualizarEquipo manejadorActualizarEquipo, ManejadorEliminarEquipo manejadorEliminarEquipo) {
        this.manejadorCrearEquipo = manejadorCrearEquipo;
        this.manejadorActualizarEquipo = manejadorActualizarEquipo;
        this.manejadorEliminarEquipo = manejadorEliminarEquipo;
    }
    @PostMapping
    @ApiOperation("Crear Equipo")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoEquipo comandoEquipo){
        return manejadorCrearEquipo.ejecutar(comandoEquipo);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Equipo")
    public void actualizar(@RequestBody ComandoEquipo comandoEquipo, @PathVariable Long id){
        comandoEquipo.setId(id);
        manejadorActualizarEquipo.ejecutar(comandoEquipo);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Equipo")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarEquipo.ejecutar(id);
    }
}
