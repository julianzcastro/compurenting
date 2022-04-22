package com.ceiba.prestamo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.servicio.testdatabuillder.EquipoTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.servicio.testdatabuilder.PrestamoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrestamoPrueba {

    @Test
    @DisplayName("Deberia crear correctamente el prestamo")
    void deberiaCrearCorrectamenElEquipo(){

        Equipo equipo = new EquipoTestDataBuilder().conId(1L).build();
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();

        assertEquals(1, prestamo.getId());
        assertEquals("100", prestamo.getIdentificacionUsuario());
        assertEquals(equipo, prestamo.getEquipo());
        assertEquals(5, prestamo.getNumeroDias());

    }

    @Test
    void deberiaFallarSinIdentificacionDeUsuario(){

        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conId(1L).conIdentificacionUsuario(null);

        BasePrueba.assertThrows(() -> {
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "La información de la identificación del usuario debe ser ingresada.");
    }

    @Test
    void deberiaFallarSinEquipo(){

        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conId(1L).conEquipo(null);

        BasePrueba.assertThrows(() -> {
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "La información del equipo a prestar debe ser ingresada.");
    }

    @Test
    void deberiaFallarSinNumeroDeDias(){

        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conId(1L).conNumeroDias(null);

        BasePrueba.assertThrows(() -> {
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "El número de días que prestará el equipo es obligatorio.");
    }

    @Test
    void deberiaFallarConNumeroDiasConValorNegativo(){

        PrestamoTestDataBuilder prestamoTestDataBuilder = new PrestamoTestDataBuilder().conId(1L).conNumeroDias(-1);

        BasePrueba.assertThrows(() -> {
                    prestamoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "El número de días debe ser positivo, mayor a cero.");
    }


}
