package com.ceiba.prestamo.puerto.dao;

import com.ceiba.prestamo.modelo.dto.PrestamoDTO;

import java.util.List;

public interface PrestamoDAO {
    List<PrestamoDTO> listar();
}
