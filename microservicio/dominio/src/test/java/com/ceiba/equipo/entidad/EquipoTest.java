package com.ceiba.equipo.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.servicio.testdatabuillder.EquipoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipoTest {

    @Test
    @DisplayName("Deberia crear correctamente el equipo")
    void deberiaCrearCorrectamenElEquipo(){

        Equipo equipo = new EquipoTestDataBuilder().conId(1L).build();

        assertEquals(1, equipo.getId());
        assertEquals("SN1", equipo.getSerial());
        assertEquals("Apple", equipo.getMarca());
        assertEquals(true, equipo.isDisponible());
        assertEquals( "Básico",equipo.getTipoEquipo().getDescripcion());

    }

    @Test
    void deberiaFallarSinSerial(){

        EquipoTestDataBuilder equipoTestDataBuilder = new EquipoTestDataBuilder().conId(1L).conSerial(null);

        BasePrueba.assertThrows(() -> {
                    equipoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar un serial de Equipo válido");
    }

    @Test
    void deberiaFallarSinMarca(){

        EquipoTestDataBuilder equipoTestDataBuilder = new EquipoTestDataBuilder().conId(1L).conMarca(null);

        BasePrueba.assertThrows(() -> {
                    equipoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar una marca de Equipo válido");
    }

    @Test
    void deberiaFallarSinTipoEquipo(){

        EquipoTestDataBuilder equipoTestDataBuilder = new EquipoTestDataBuilder().conId(1L).conTipoEquipo(null);

        BasePrueba.assertThrows(() -> {
                    equipoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar un tipo de Equipo válido");
    }





}
