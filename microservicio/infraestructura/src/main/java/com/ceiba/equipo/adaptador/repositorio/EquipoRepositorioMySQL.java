package com.ceiba.equipo.adaptador.repositorio;

import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
import com.ceiba.equipo.fabrica.EquipoTransaccional;
import com.ceiba.equipo.fabrica.FabricaEntidadEquipoTransaccional;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.equipo.puerto.repositorio.EquipoRepositorio;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class EquipoRepositorioMySQL implements EquipoRepositorio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final FabricaEquipo fabricaEquipo;
    private final FabricaEntidadEquipoTransaccional fabricaEntidadEquipoTransaccional;

    @SqlStatement(namespace="equipo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="equipo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="equipo", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="equipo", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="equipo", value="existePorSerial")
    private static String sqlExistePorSerial;

    @SqlStatement(namespace="equipo", value="disponible")
    private static String sqlDisponible;

    @SqlStatement(namespace="equipo", value="buscarPorId")
    private static String sqlExistePorIdentificacion;

    @SqlStatement(namespace="equipo", value="verificarDisponibilidadPorId")
    private static String sqlVerificarDisponibilidadPorId;

    @SqlStatement(namespace="equipo", value="actualizarDisponibilidad")
    private static String sqlActualizarDisponibilidad;


    public EquipoRepositorioMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, FabricaEquipo fabricaEquipo, FabricaEntidadEquipoTransaccional fabricaEntidadEquipoTransaccional) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.fabricaEquipo=fabricaEquipo;
        this.fabricaEntidadEquipoTransaccional=fabricaEntidadEquipoTransaccional;
    }

    @Override
    public Long crear(Equipo equipo) {
        EquipoTransaccional equipoTransaccional = this.fabricaEntidadEquipoTransaccional.crear(equipo);
        return this.customNamedParameterJdbcTemplate.crear(equipoTransaccional, sqlCrear);
    }

    @Override
    public void actualizar(Equipo equipo) {
        EquipoTransaccional equipoTransaccional = this.fabricaEntidadEquipoTransaccional.crear(equipo);
        this.customNamedParameterJdbcTemplate.actualizar(equipoTransaccional, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }

    @Override
    public boolean existePorSerial(String serial) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("serial", serial);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorSerial, paramSource, Boolean.class);
    }

    @Override
    public boolean disponible(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlDisponible, paramSource, Boolean.class);
    }

    @Override
    public Equipo buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorIdentificacion, paramSource, new MapeoEquipoEntidad(fabricaEquipo));
    }

    @Override
    public void actualizarDisponibilidad(Equipo equipo) {
        this.customNamedParameterJdbcTemplate.actualizar(equipo,sqlActualizarDisponibilidad);
    }


}
