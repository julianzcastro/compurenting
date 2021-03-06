package com.ceiba.equipo.adaptador.repositorio;

import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
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


    public EquipoRepositorioMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, FabricaEquipo fabricaEquipo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.fabricaEquipo=fabricaEquipo;
    }

    @Override
    public Long crear(Equipo equipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("serial", equipo.getSerial());
        paramSource.addValue("marca", equipo.getMarca());
        paramSource.addValue("disponible", equipo.isDisponible());
        paramSource.addValue("tipoEquipo", equipo.getTipoEquipo().getDescripcion());
        return Integer.toUnsignedLong(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource));
    }

    @Override
    public void actualizar(Equipo equipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", equipo.getId());
        paramSource.addValue("serial", equipo.getSerial());
        paramSource.addValue("marca", equipo.getMarca());
        paramSource.addValue("disponible", equipo.isDisponible());
        paramSource.addValue("tipoEquipo", equipo.getTipoEquipo().getDescripcion());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
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
