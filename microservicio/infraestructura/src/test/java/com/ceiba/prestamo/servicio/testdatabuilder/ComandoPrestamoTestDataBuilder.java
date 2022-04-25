package com.ceiba.prestamo.servicio.testdatabuilder;

import com.ceiba.prestamo.comando.ComandoPrestamo;

public class ComandoPrestamoTestDataBuilder {

    private Long id;
    private String identificacionUsuario;
    private Long idEquipo;
    private Integer numeroDias;

    public ComandoPrestamoTestDataBuilder(){
        identificacionUsuario="200";
        idEquipo=2L;
        numeroDias=10;
    }

    public ComandoPrestamo build(){
        return new ComandoPrestamo(id, identificacionUsuario, idEquipo, numeroDias);
    }
}
