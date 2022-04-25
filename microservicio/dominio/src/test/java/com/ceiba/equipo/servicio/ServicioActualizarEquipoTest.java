package com.ceiba.equipo.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.equipo.servicio.testdatabuillder.EquipoTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarEquipoTest {
    @Test
    @DisplayName("Deberia validar la existencia previa del equipo")
    void deberiaValidarLaExistenciaPreviaDelEquipo() {
        // arrange
        Equipo equipo = new EquipoTestDataBuilder().conId(1L).build();
        EquipoRepositorio repositorioEquipo = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(repositorioEquipo.existePorId(Mockito.anyLong())).thenReturn(false);
        ActualizarEquipoServicio actualizarEquipoServicio = new ActualizarEquipoServicio(repositorioEquipo);
        // act - assert
        BasePrueba.assertThrows(() -> actualizarEquipoServicio.ejecutar(equipo), ExcepcionDuplicidad.class,"El equipo no está registrado en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Equipo equipo = new EquipoTestDataBuilder().conId(1L).build();
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        Mockito.when(equipoRepositorio.existePorId(Mockito.anyLong())).thenReturn(true);
        ActualizarEquipoServicio actualizarEquipoServicio = new ActualizarEquipoServicio(equipoRepositorio);
        // act
        actualizarEquipoServicio.ejecutar(equipo);
        //assert
        Mockito.verify(equipoRepositorio,Mockito.times(1)).actualizar(equipo);
    }
}
