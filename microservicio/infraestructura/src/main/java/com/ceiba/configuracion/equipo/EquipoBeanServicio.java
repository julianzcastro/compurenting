package com.ceiba.configuracion.equipo;

import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.equipo.servicio.ActualizarEquipoServicio;
import com.ceiba.equipo.servicio.CrearEquipoServicio;
import com.ceiba.equipo.servicio.EliminarEquipoServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EquipoBeanServicio {
    @Bean
    public CrearEquipoServicio crearEquipoServicio(EquipoRepositorio equipoRepositorio){
        return new CrearEquipoServicio(equipoRepositorio);
    }

    @Bean
    public ActualizarEquipoServicio actualizarEquipoServicio(EquipoRepositorio equipoRepositorio){
        return new ActualizarEquipoServicio(equipoRepositorio);
    }

    @Bean
    public EliminarEquipoServicio eliminarEquipoServicio(EquipoRepositorio equipoRepositorio){
        return new EliminarEquipoServicio(equipoRepositorio);
    }

}
