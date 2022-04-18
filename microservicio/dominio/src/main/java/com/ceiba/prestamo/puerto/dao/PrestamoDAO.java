package com.ceiba.prestamo.puerto.dao;

import com.ceiba.prestamo.modelo.dto.PrestamoDTO;
import com.ceiba.prestamo.modelo.entidad.Prestamo;

import java.util.List;

public interface PrestamoDAO {
    List<PrestamoDTO> listar();
}
