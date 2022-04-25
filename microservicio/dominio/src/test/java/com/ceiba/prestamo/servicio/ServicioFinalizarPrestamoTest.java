package com.ceiba.prestamo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import com.ceiba.prestamo.servicio.testdatabuilder.PrestamoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioFinalizarPrestamoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del prestamo")
    void deberiaValidarLaExistenciaPreviaDelPrestamo() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        Mockito.when(prestamoRepositorio.existeporId(Mockito.anyLong())).thenReturn(false);
        FinalizarPrestamoServicio finalizarPrestamoServicio = new FinalizarPrestamoServicio(prestamoRepositorio);
        // act - assert
        BasePrueba.assertThrows(() -> finalizarPrestamoServicio.ejecutar(1L), ExcepcionDuplicidad.class,"El prestamo que intenta finalizar no existe en el sistema.");
    }

    @Test
    @DisplayName("Deberia finalizar el prestamo llamando al repositorio")
    void deberiaFinalizarElPrestamoLlamandoAlRepositorio() {
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        Mockito.when(prestamoRepositorio.buscarPorId(Mockito.anyLong())).thenReturn(prestamo);
        Mockito.when(prestamoRepositorio.existeporId(Mockito.anyLong())).thenReturn(true);
        FinalizarPrestamoServicio finalizarPrestamoServicio = new FinalizarPrestamoServicio(prestamoRepositorio);
        finalizarPrestamoServicio.ejecutar(1L);

        Mockito.verify(prestamoRepositorio, Mockito.times(1)).finalizar(prestamo);

    }
}
