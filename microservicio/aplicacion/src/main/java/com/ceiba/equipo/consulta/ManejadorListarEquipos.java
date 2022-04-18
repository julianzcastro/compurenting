package com.ceiba.equipo.consulta;

import com.ceiba.equipo.modelo.dto.EquipoDTO;
import com.ceiba.equipo.puerto.dao.EquipoDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarEquipos {

    private final EquipoDAO equipoDAO;

    public ManejadorListarEquipos(EquipoDAO equipoDAO) {
        this.equipoDAO = equipoDAO;
    }
    public List<EquipoDTO> ejecutar(){
        return this.equipoDAO.listar();
    }
}
