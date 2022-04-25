package com.ceiba.equipo.fabrica;


public class EquipoTransaccional {
    private final Long id;
    private final String serial;
    private final String marca;
    private final boolean disponible;
    private final String tipoEquipo;

    public EquipoTransaccional(Long id, String serial, String marca, boolean disponible, String tipoEquipo) {
        this.id = id;
        this.serial = serial;
        this.marca = marca;
        this.disponible = disponible;
        this.tipoEquipo = tipoEquipo;
    }

}
