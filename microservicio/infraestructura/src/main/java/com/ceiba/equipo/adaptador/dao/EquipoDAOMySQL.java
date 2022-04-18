package com.ceiba.equipo.adaptador.dao;

import com.ceiba.equipo.modelo.dto.EquipoDTO;
import com.ceiba.equipo.puerto.dao.EquipoDAO;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EquipoDAOMySQL implements EquipoDAO {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "equipo", value="listar")
    private static String sqlListar;

    public EquipoDAOMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<EquipoDTO> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEquipo());
    }
}
