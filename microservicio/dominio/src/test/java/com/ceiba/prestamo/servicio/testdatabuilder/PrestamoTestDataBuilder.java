package com.ceiba.prestamo.servicio.testdatabuilder;

import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.servicio.testdatabuillder.EquipoTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.tipoequipo.TipoEquipoEnum;

import java.time.LocalDate;

public class PrestamoTestDataBuilder {

    private Long id;
    private String identificacionUsuario;
    private Equipo equipo;
    private Integer numeroDias;


    public PrestamoTestDataBuilder(){
        identificacionUsuario="100";
        equipo= new EquipoTestDataBuilder().conId(1L).build();
        numeroDias=5;
    }

    public PrestamoTestDataBuilder conId(Long id){
        this.id = id;
        return this;
    }

    public PrestamoTestDataBuilder conIdentificacionUsuario(String identificacionUsuario){
        this.identificacionUsuario = identificacionUsuario;
        return this;
    }

    public PrestamoTestDataBuilder conEquipo(Equipo equipo){
        this.equipo = equipo;
        return this;
    }

    public PrestamoTestDataBuilder conNumeroDias(Integer numeroDias){
        this.numeroDias = numeroDias;
        return this;
    }

    public Prestamo build(){
        return new Prestamo(id, identificacionUsuario, equipo, numeroDias);
    }
}
