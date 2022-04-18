package com.ceiba.tipoequipo;

public enum TipoEquipoEnum {

    BASICO("Básico",3), GAMER("Gamer",5);


    private String descripcion;
    private Integer precioDia;

    TipoEquipoEnum(String descripcion, Integer precioDia) {
        this.descripcion = descripcion;
        this.precioDia = precioDia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getPrecioDia() {
        return precioDia;
    }
}
