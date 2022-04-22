package com.ceiba.prestamo.adaptador.repositorio;

import com.ceiba.equipo.comando.ComandoEquipo;
import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPrestamoEntidad implements RowMapper<Prestamo>, MapperResult {

    private final FabricaEquipo fabricaEquipo;

    public MapeoPrestamoEntidad(FabricaEquipo fabricaEquipo) {
        this.fabricaEquipo = fabricaEquipo;
    }

    public Prestamo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("prestamo_id");
        String identificacionUsuario= resultSet.getString("prestamo_usuario");
        Integer numeroDias = resultSet.getInt("prestamo_dias");
        return new Prestamo(id, identificacionUsuario, obtenerEquipo(resultSet), numeroDias);
    }

    private Equipo obtenerEquipo(ResultSet resultSet) throws SQLException{

        Long idEquipo = resultSet.getLong("equipo_id");
        String serial = resultSet.getString("equipo_serial");
        String marca = resultSet.getString("equipo_marca");
        boolean disponible = resultSet.getBoolean("equipo_disponible");
        String tipoEquipo = resultSet.getString("equipo_tipo");
        return this.fabricaEquipo.crear(new ComandoEquipo(
                idEquipo,
                serial,
                marca,
                disponible,
                tipoEquipo
        ));
    }
}

