package com.ceiba.equipo.servicio;

import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarEquipoTest {

    @Test
    @DisplayName("Deberia eliminar el usuario llamando al repositorio")
    void deberiaEliminarElEquipoLlamandoAlRepositorio() {
        EquipoRepositorio equipoRepositorio = Mockito.mock(EquipoRepositorio.class);
        EliminarEquipoServicio eliminarEquipoServicio = new EliminarEquipoServicio(equipoRepositorio);

        eliminarEquipoServicio.ejecutar(1l);

        Mockito.verify(equipoRepositorio, Mockito.times(1)).eliminar(1l);

    }
}
