package com.ceiba.prestamo.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.tipoequipo.TipoEquipoEnum;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Prestamo {

    private static final String IDENTIFICACION_USUARIO_OBLIGATORIO= "La información de la identificación del usuario debe ser ingresada.";
    private static final String INFORMACION_EQUIPO_OBLIGATORIO= "La información del equipo a prestar debe ser ingresada.";
    private static final String NUMERO_DIAS_PRESTAMO_OBLIGATORIO= "El número de días que prestará el equipo es obligatorio.";
    private static final String ESTADO_PRESTAMO_OBLIGATORIO= "El estado del prestamo es un dato obligatorio.";

    private static final int COSTO_DIAS_EXTRA = 10;

    private Long id;
    private String identificacionUsuario;
    private Equipo equipo;
    private LocalDate fechaPrestamo;
    private Integer numeroDias;
    private Integer total;

    public Prestamo(Long id, String identificacionUsuario, Equipo equipo, LocalDate fechaPrestamo, Integer numeroDias) {

        ValidadorArgumento.validarObligatorio(identificacionUsuario, IDENTIFICACION_USUARIO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(equipo, INFORMACION_EQUIPO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(numeroDias, NUMERO_DIAS_PRESTAMO_OBLIGATORIO);
        this.id = id;
        this.identificacionUsuario = identificacionUsuario;
        this.equipo = equipo;
        this.fechaPrestamo = LocalDate.now();
        this.numeroDias = numeroDias;
        this.total=calcularTotal(numeroDias);
    }

    private Integer calcularTotal(Integer numeroDias){
        return numeroDias*getEquipo().getTipoEquipo().getPrecioDia();
    }

    public void calcularExcedente(Integer numeroDiasExtra){
        int excedente = numeroDiasExtra * COSTO_DIAS_EXTRA;
        setTotal(getTotal()+excedente);
    }

    private void setTotal(Integer total) {
        this.total = total;
    }

}
