package com.ceiba.prestamo.consulta;

import com.ceiba.prestamo.modelo.dto.PrestamoDTO;
import com.ceiba.prestamo.puerto.dao.PrestamoDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPrestamos {
    private final PrestamoDAO prestamoDAO;

    public ManejadorListarPrestamos(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }

    public List<PrestamoDTO> ejecutar(){ return this.prestamoDAO.listar(); }
}
