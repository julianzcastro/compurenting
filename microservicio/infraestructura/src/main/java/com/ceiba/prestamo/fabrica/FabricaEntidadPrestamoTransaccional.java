package com.ceiba.prestamo.fabrica;

import com.ceiba.prestamo.modelo.entidad.Prestamo;

public class FabricaEntidadPrestamoTransaccional {
    public static PrestamoTransaccional crear(Prestamo prestamo){
        return new PrestamoTransaccional(
                prestamo.getId(),
                prestamo.getIdentificacionUsuario(),
                prestamo.getEquipo().getId(),
                prestamo.getFechaPrestamo(),
                prestamo.getNumeroDias(),
                prestamo.getTotal(),
                prestamo.isEstado()
        );
    }
}
