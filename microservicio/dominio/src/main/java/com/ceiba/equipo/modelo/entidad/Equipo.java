package com.ceiba.equipo.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.tipoequipo.TipoEquipoEnum;
import lombok.Getter;

@Getter
public class Equipo {

    private static final String ID_EQUIPO_OBLIGATORIO="Se debe ingresar un id de Equipo válido.";
    private static final String SERIAL_EQUIPO_OBLIGATORIO ="Se debe ingresar un serial de Equipo válido";
    private static final String MARCA_EQUIPO_OBLIGATORIO ="Se debe ingresar una marca de Equipo válido";
    private static final String TIPO_EQUIPO_OBLIGATORIO ="Se debe ingresar un tipo de Equipo válido";
    private static final String DISPONIBILIDAD_EQUIPO_OBLIGATORIA = "la disponibilidad del equipo debe ser válida.";

    private Long id;
    private String serial;
    private String marca;
    private boolean disponible;
    private TipoEquipoEnum tipoEquipo;

    public Equipo(Long id, String serial, String marca, boolean disponible, TipoEquipoEnum tipoEquipo) {
        ValidadorArgumento.validarObligatorio(serial, SERIAL_EQUIPO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(marca, MARCA_EQUIPO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(disponible, DISPONIBILIDAD_EQUIPO_OBLIGATORIA);
        ValidadorArgumento.validarObligatorio(tipoEquipo, TIPO_EQUIPO_OBLIGATORIO);

        this.id = id;
        this.serial = serial;
        this.marca = marca;
        this.disponible = disponible;
        this.tipoEquipo = tipoEquipo;
    }

}
