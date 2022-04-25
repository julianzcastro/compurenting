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
    private static final String NUMERO_DIAS_DEBE_SER_NUMERICO= "El número de días debe ser numérico.";
    private static final String NUMERO_DIAS_DEBE_SER_VALOR_POSITIVO= "El número de días debe ser positivo, mayor a cero.";

    private static final int COSTO_POR_DIA_EXTRA = 10;

    private final Long id;
    private final String identificacionUsuario;
    private final Equipo equipo;
    private final LocalDate fechaPrestamo;
    private final Integer numeroDias;
    private Integer total;
    private final boolean estado;

    public Prestamo(Long id, String identificacionUsuario, Equipo equipo, Integer numeroDias) {

        ValidadorArgumento.validarObligatorio(identificacionUsuario, IDENTIFICACION_USUARIO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(equipo, INFORMACION_EQUIPO_OBLIGATORIO);
        ValidadorArgumento.validarObligatorio(numeroDias, NUMERO_DIAS_PRESTAMO_OBLIGATORIO);
        ValidadorArgumento.validarMayorQueCero(numeroDias, NUMERO_DIAS_DEBE_SER_VALOR_POSITIVO);
        this.id = id;
        this.identificacionUsuario = identificacionUsuario;
        this.equipo = equipo;
        this.fechaPrestamo = LocalDate.now();
        this.numeroDias = numeroDias;
        this.estado= true;
        calcularTotalInicial(numeroDias);
    }

    private void calcularTotalInicial(Integer numeroDias){
        this.total= numeroDias*getEquipo().getTipoEquipo().getPrecioDia();
    }

    public void asignarTotal(){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDevolucion = this.getFechaPrestamo();
        if(fechaActual.isAfter(fechaDevolucion)){
            this.calcularExcedente(fechaActual.getDayOfMonth()-fechaDevolucion.getDayOfMonth());
        }
    }

    public void calcularExcedente(Integer numeroDiasExtra){
        int excedente = numeroDiasExtra * COSTO_POR_DIA_EXTRA;
        setTotal(getTotal()+excedente);
    }

    private void setTotal(Integer total) {
        this.total = total;
    }

}
