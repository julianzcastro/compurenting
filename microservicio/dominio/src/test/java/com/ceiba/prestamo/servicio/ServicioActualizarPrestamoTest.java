package com.ceiba.prestamo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.equipo.servicio.testdatabuillder.EquipoTestDataBuilder;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import com.ceiba.prestamo.servicio.testdatabuilder.PrestamoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarPrestamoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del prestamo")
    void deberiaValidarLaExistenciaPreviaDelPrestamo() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(prestamoRepositorio.existeporId(Mockito.anyLong())).thenReturn(false);
        ActualizarPrestamoServicio actualizarPrestamoServicio = new ActualizarPrestamoServicio(prestamoRepositorio, equipoRepositorio);
        // act - assert
        BasePrueba.assertThrows(() -> actualizarPrestamoServicio.ejecutar(prestamo), ExcepcionDuplicidad.class,"El prestamo que intenta actualizar no esta registrado en el sistema.");
    }

    @Test
    @DisplayName("Deberia validar la existencia previa del prestamo")
    void deberiaLanzarUnaExcepcionSiElEquipoQueSeVaAAgregarNoEstaRegistrado() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(prestamoRepositorio.existeporId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(equipoRepositorio.existePorId(Mockito.anyLong())).thenReturn(false);
        ActualizarPrestamoServicio actualizarPrestamoServicio = new ActualizarPrestamoServicio(prestamoRepositorio, equipoRepositorio);
        // act - assert
        BasePrueba.assertThrows(() -> actualizarPrestamoServicio.ejecutar(prestamo), ExcepcionDuplicidad.class,"El equipo que intenta agregar al prestamo no esta registrado en el sistema.");
    }

    @Test
    @DisplayName("Deberia validar la existencia previa del prestamo")
    void deberiaLanzarUnaExcepcionSiElEquipoIngresadoNoEstaDisponible() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();
        Equipo equipoOcupado = new EquipoTestDataBuilder().conId(2L).conDisponibilidad(false).build();
        Prestamo prestamoPreviamenteRegistrado = new PrestamoTestDataBuilder().conId(2L).conEquipo(equipoOcupado).build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(prestamoRepositorio.buscarPorId(Mockito.anyLong())).thenReturn(prestamoPreviamenteRegistrado);
        Mockito.when(prestamoRepositorio.existeporId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(equipoRepositorio.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(equipoRepositorio.disponible(Mockito.anyLong())).thenReturn(false);
        ActualizarPrestamoServicio actualizarPrestamoServicio = new ActualizarPrestamoServicio(prestamoRepositorio, equipoRepositorio);
        // act - assert
        BasePrueba.assertThrows(() -> actualizarPrestamoServicio.ejecutar(prestamo), ExcepcionDuplicidad.class,"El equipo que intenta actualizar al prestamo no esta disponible.");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().conId(1L).build();

        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(prestamoRepositorio.buscarPorId(Mockito.anyLong())).thenReturn(prestamo);
        Mockito.when(prestamoRepositorio.existeporId(prestamo.getId())).thenReturn(true);
        Mockito.when(equipoRepositorio.existePorId(Mockito.anyLong())).thenReturn(true);
        Mockito.when(equipoRepositorio.disponible(Mockito.anyLong())).thenReturn(true);

        ActualizarPrestamoServicio actualizarPrestamoServicio = new ActualizarPrestamoServicio(prestamoRepositorio, equipoRepositorio);
        // act
        actualizarPrestamoServicio.ejecutar(prestamo);
        //assert
        Mockito.verify(prestamoRepositorio,Mockito.times(1)).actualizar(prestamo);
    }
}
