package com.ceiba.prestamo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.prestamo.modelo.dto.PrestamoDTO;
import com.ceiba.prestamo.puerto.dao.PrestamoDAO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PrestamoDAOMySQL implements PrestamoDAO {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace= "prestamo", value="listar")
    private static String sqlListar;

    public PrestamoDAOMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<PrestamoDTO> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPrestamo());
    }
}
