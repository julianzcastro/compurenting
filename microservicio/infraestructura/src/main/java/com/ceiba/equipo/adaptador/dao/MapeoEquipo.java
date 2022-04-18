package com.ceiba.equipo.adaptador.dao;

import com.ceiba.equipo.modelo.dto.EquipoDTO;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipoequipo.TipoEquipoEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEquipo implements RowMapper<EquipoDTO>, MapperResult {
    @Override
    public EquipoDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String serial = resultSet.getString("serial");
        String marca =  resultSet.getString("marca");
        boolean disponible = resultSet.getBoolean("disponible");
        String tipoEquipo = resultSet.getString("tipo_equipo");
        return new EquipoDTO(id, serial, marca, disponible, tipoEquipo);
    }

}
