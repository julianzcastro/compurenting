package com.ceiba.equipo.puerto.repositorio;

import com.ceiba.equipo.modelo.entidad.Equipo;

public interface EquipoRepositorio {

    Long crear(Equipo equipo);
    void actualizar(Equipo equipo);
    void eliminar(Long id);
    boolean existePorId(Long id);
    boolean existePorSerial(String serial);
    boolean disponible(Long id);
    Equipo buscarPorId(Long id);
    boolean verificarDisponibilidadPorId(Long id);
    void actualizarDisponibilidad(Equipo equipo);
}
