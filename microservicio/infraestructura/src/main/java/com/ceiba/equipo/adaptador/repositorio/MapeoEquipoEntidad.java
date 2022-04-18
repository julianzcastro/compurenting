package com.ceiba.equipo.adaptador.repositorio;

import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.tipoequipo.TipoEquipoEnum;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoEquipoEntidad implements RowMapper<Equipo>, MapperResult {
    @Override
    public Equipo mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String serial = resultSet.getString("serial");
        String marca =  resultSet.getString("marca");
        boolean disponible = resultSet.getBoolean("disponible");
        String tipoEquipo = resultSet.getString("tipo_equipo");
        return new Equipo(id, serial, marca, disponible, asignarTipoEquipo(tipoEquipo));
    }

    private TipoEquipoEnum asignarTipoEquipo(String tipo){
        if(TipoEquipoEnum.BASICO.getDescripcion().equalsIgnoreCase(tipo)){
            return TipoEquipoEnum.BASICO;
        }else{
            return TipoEquipoEnum.GAMER;
        }
    }
}
