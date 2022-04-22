package com.ceiba.equipo.fabrica;

public class EquipoTransaccional {
    private Long id;
    private String serial;
    private String marca;
    private boolean disponible;
    private String tipoEquipo;

    public EquipoTransaccional(Long id, String serial, String marca, boolean disponible, String tipoEquipo) {
        this.id = id;
        this.serial = serial;
        this.marca = marca;
        this.disponible = disponible;
        this.tipoEquipo = tipoEquipo;
    }
}