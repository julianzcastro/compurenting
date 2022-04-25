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

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearPrestamoTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide que el equipo que se quiere prestar no está disponible")
    void deberiaLanzarUnaExepcionCuandoSeValideQueLaIdentificacionDelUsuarioYaTieneOtroPrestamoActivo() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(prestamoRepositorio.existeIdentificacionConPrestamoActivo(Mockito.anyString())).thenReturn(true);
        CrearPrestamoServicio crearPrestamoServicio = new CrearPrestamoServicio(prestamoRepositorio, equipoRepositorio);
        // act - assert
        BasePrueba.assertThrows(() -> crearPrestamoServicio.ejecutar(prestamo), ExcepcionDuplicidad.class,"El usuario ya tiene un préstamo activo, registrado en el sistema.");
    }


    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide que el equipo que se quiere prestar no está disponible")
    void deberiaLanzarUnaExepcionCuandoSeValideQueElEquipoNoEstaDisponible() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(equipoRepositorio.disponible(Mockito.anyLong())).thenReturn(false);
        CrearPrestamoServicio crearPrestamoServicio = new CrearPrestamoServicio(prestamoRepositorio, equipoRepositorio);
        // act - assert
        BasePrueba.assertThrows(() -> crearPrestamoServicio.ejecutar(prestamo), ExcepcionDuplicidad.class,"El equipo ingresado tiene otro préstamo activo registrado en el sistema.");
    }

    @Test
    @DisplayName("Deberia Crear el prestamo de manera correcta")
    void deberiaCrearElPrestamoDeManeraCorrecta() {
        // arrange
        Prestamo prestamo = new PrestamoTestDataBuilder().build();
        PrestamoRepositorio prestamoRepositorio = Mockito.mock(PrestamoRepositorio.class);
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(prestamoRepositorio.existeporId(Mockito.anyLong())).thenReturn(false);
        Mockito.when(prestamoRepositorio.existeIdentificacionConPrestamoActivo(Mockito.anyString())).thenReturn(false);
        Mockito.when(equipoRepositorio.disponible(Mockito.anyLong())).thenReturn(true);
        Mockito.when(prestamoRepositorio.crear(prestamo)).thenReturn(10L);
        CrearPrestamoServicio crearPrestamoServicio = new CrearPrestamoServicio(prestamoRepositorio, equipoRepositorio);
        // act
        Long idPrestamo = crearPrestamoServicio.ejecutar(prestamo);
        // assert
        assertEquals(10L,idPrestamo);
        Mockito.verify(prestamoRepositorio, Mockito.times(1)).crear(prestamo);
    }
}
