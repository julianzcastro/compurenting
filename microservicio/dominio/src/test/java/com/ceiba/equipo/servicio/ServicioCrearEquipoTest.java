package com.ceiba.equipo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.equipo.servicio.testdatabuillder.EquipoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearEquipoTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando se valide la existencia del Usuario")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelEquipo() {
        // arrange
        Equipo equipo = new EquipoTestDataBuilder().build();
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(equipoRepositorio.existePorSerial(Mockito.anyString())).thenReturn(true);
        CrearEquipoServicio crearEquipoServicio = new CrearEquipoServicio(equipoRepositorio);
        // act - assert
        BasePrueba.assertThrows(() -> crearEquipoServicio.ejecutar(equipo), ExcepcionDuplicidad.class,"El serial del equipo ya está registrado en el sistema.");
    }

    @Test
    @DisplayName("Deberia Crear el usuario de manera correcta")
    void deberiaCrearElEquipoDeManeraCorrecta() {
        // arrange
        Equipo equipo = new EquipoTestDataBuilder().build();
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(equipoRepositorio.existePorSerial(Mockito.anyString())).thenReturn(false);
        Mockito.when(equipoRepositorio.crear(equipo)).thenReturn(10L);
        CrearEquipoServicio crearEquipoServicio = new CrearEquipoServicio(equipoRepositorio);
        // act
        Long idEquipo = crearEquipoServicio.ejecutar(equipo);
        //- assert
        assertEquals(10L,idEquipo);
        Mockito.verify(equipoRepositorio, Mockito.times(1)).crear(equipo);
    }
}
