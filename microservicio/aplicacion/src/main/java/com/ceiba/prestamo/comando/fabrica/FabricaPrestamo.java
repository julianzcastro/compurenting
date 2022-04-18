package com.ceiba.prestamo.comando.fabrica;

import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.prestamo.comando.ComandoPrestamo;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaPrestamo {

    @Autowired
    private EquipoRepositorio equipoRepositorio;

    public FabricaPrestamo(EquipoRepositorio equipoRepositorio) {
        this.equipoRepositorio = equipoRepositorio;
    }

    public Prestamo crear(ComandoPrestamo comandoPrestamo){
        return new Prestamo(
                comandoPrestamo.getId(),
                comandoPrestamo.getIdentificacionUsuario(),
                this.equipoRepositorio.buscarPorId(comandoPrestamo.getIdEquipo()),
                comandoPrestamo.getFechaPrestamo(),
                comandoPrestamo.getNumeroDias()
        );
    }

}
