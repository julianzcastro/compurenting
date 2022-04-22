package com.ceiba.prestamo.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.prestamo.modelo.dto.PrestamoDTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class MapeoPrestamo implements RowMapper<PrestamoDTO>, MapperResult {
    @Override
    public PrestamoDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String identificacionUsuario= resultSet.getString("identificacion_usuario");
        LocalDate fechaPrestamo= extraerLocalDate(resultSet, "fecha_prestamo");
        Long idEquipo= resultSet.getLong("id_equipo");
        Integer numeroDias = resultSet.getInt("numero_dias");
        Integer total = resultSet.getInt("total");
        boolean estado = resultSet.getBoolean("estado");
        return new PrestamoDTO(id, identificacionUsuario, idEquipo, fechaPrestamo, numeroDias, total, estado);
    }
}
