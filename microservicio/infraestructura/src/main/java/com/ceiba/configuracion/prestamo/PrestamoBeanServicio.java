package com.ceiba.configuracion.prestamo;

import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import com.ceiba.prestamo.servicio.ActualizarPrestamoServicio;
import com.ceiba.prestamo.servicio.CrearPrestamoServicio;
import com.ceiba.prestamo.servicio.EliminarPrestamoServicio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PrestamoBeanServicio {
    @Bean
    public CrearPrestamoServicio crearEquipoServicio(PrestamoRepositorio prestamoRepositorio){
        return new CrearPrestamoServicio(prestamoRepositorio);
    }

    @Bean
    public ActualizarPrestamoServicio actualizarEquipoServicio(PrestamoRepositorio prestamoRepositorio){
        return new ActualizarPrestamoServicio(prestamoRepositorio);
    }

    @Bean
    public EliminarPrestamoServicio eliminarEquipoServicio(PrestamoRepositorio prestamoRepositorio){
        return new EliminarPrestamoServicio(prestamoRepositorio);
    }
}
