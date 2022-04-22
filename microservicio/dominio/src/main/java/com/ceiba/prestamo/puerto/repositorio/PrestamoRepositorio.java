package com.ceiba.prestamo.puerto.repositorio;

import com.ceiba.prestamo.modelo.entidad.Prestamo;

public interface PrestamoRepositorio {
    Long crear(Prestamo prestamo);
    void actualizar(Prestamo prestamo);
    void finalizar(Prestamo prestamo);
    boolean existeporId(Long id);
    boolean estadoDisponibleEquipo(Long idEquipo);
    boolean existeIdentificacionConPrestamoActivo(String identificacionUsuario);
    Prestamo buscarPorId(Long id);
}
