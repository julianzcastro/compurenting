package com.ceiba.equipo.adaptador.repositorio;

import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEquipoEntidad implements RowMapper<Equipo>, MapperResult {

    private final FabricaEquipo fabricaEquipo;

    public MapeoEquipoEntidad(FabricaEquipo fabricaEquipo) {
        this.fabricaEquipo = fabricaEquipo;
    }

    @Override
    public Equipo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String serial = resultSet.getString("serial");
        String marca =  resultSet.getString("marca");
        boolean disponible = resultSet.getBoolean("disponible");
        String tipoEquipo = resultSet.getString("tipo_equipo");
        return new Equipo(id, serial, marca, disponible,fabricaEquipo.asignarTipoEquipo(tipoEquipo));
    }

}
