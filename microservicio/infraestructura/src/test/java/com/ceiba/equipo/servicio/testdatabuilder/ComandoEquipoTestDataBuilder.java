package com.ceiba.equipo.servicio.testdatabuilder;

import com.ceiba.equipo.comando.ComandoEquipo;

public class ComandoEquipoTestDataBuilder {

    private Long id;
    private final String serial;
    private final String marca;
    private final boolean disponible;
    private final String tipoEquipo;

    public ComandoEquipoTestDataBuilder(){
        serial= "MAC234";
        marca= "Apple";
        disponible = true;
        tipoEquipo = "Básico";
    }

    public ComandoEquipo build(){
        return new ComandoEquipo(id, serial, marca, disponible, tipoEquipo);
    }
}
