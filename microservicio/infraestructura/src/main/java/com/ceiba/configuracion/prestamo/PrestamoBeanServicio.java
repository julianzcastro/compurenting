package com.ceiba.configuracion.prestamo;

import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import com.ceiba.prestamo.servicio.ActualizarPrestamoServicio;
import com.ceiba.prestamo.servicio.CrearPrestamoServicio;
import com.ceiba.prestamo.servicio.FinalizarPrestamoServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrestamoBeanServicio {
    @Bean
    public CrearPrestamoServicio crearPrestamoServicio(PrestamoRepositorio prestamoRepositorio, EquipoRepositorio equipoRepositorio){
        return new CrearPrestamoServicio(prestamoRepositorio, equipoRepositorio);
    }

    @Bean
    public ActualizarPrestamoServicio actualizarPrestamoServicio(PrestamoRepositorio prestamoRepositorio, EquipoRepositorio equipoRepositorio){
        return new ActualizarPrestamoServicio(prestamoRepositorio, equipoRepositorio);
    }

    @Bean
    public FinalizarPrestamoServicio finalizarPrestamoServicio(PrestamoRepositorio prestamoRepositorio){
        return new FinalizarPrestamoServicio(prestamoRepositorio);
    }
}
