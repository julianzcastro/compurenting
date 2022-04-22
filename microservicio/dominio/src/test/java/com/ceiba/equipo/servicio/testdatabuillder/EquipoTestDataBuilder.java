package com.ceiba.equipo.servicio.testdatabuillder;


import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.tipoequipo.TipoEquipoEnum;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class EquipoTestDataBuilder {

    private Long id;
    private String serial;
    private String marca;
    private Boolean disponible;
    private TipoEquipoEnum tipoEquipo;

    public EquipoTestDataBuilder(){
        serial="SN1";
        marca="Apple";
        disponible = true;
        tipoEquipo= TipoEquipoEnum.BASICO;
    }
    public EquipoTestDataBuilder conId(Long id){
        this.id=id;
        return this;
    }

    public EquipoTestDataBuilder conSerial(String serial){
        this.serial=serial;
        return this;
    }

    public EquipoTestDataBuilder conMarca(String marca){
        this.marca=marca;
        return this;
    }

    public EquipoTestDataBuilder conDisponible(Boolean disponible){
        this.disponible=disponible;
        return this;
    }

    public EquipoTestDataBuilder conTipoEquipo(TipoEquipoEnum tipoEquipo){
        this.tipoEquipo=tipoEquipo;
        return this;
    }

    public Equipo build(){
        return new Equipo(id, serial, marca, disponible, tipoEquipo);
    }
}
