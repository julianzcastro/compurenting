package com.ceiba.prestamo.adaptador.repositorio;

import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PrestamoRepositorioMySQL implements PrestamoRepositorio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final FabricaEquipo fabricaEquipo;

    @SqlStatement(namespace="prestamo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="prestamo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="prestamo", value="finalizar")
    private static String sqlFinalizar;

    @SqlStatement(namespace="prestamo", value="existeIdentificacionConPrestamoActivo")
    private static String sqlExisteIdentificacionconPrestamoActivo;

    @SqlStatement(namespace="prestamo", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="prestamo", value="buscarPorId")
    private static String sqlBuscarPorId;



    public PrestamoRepositorioMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, FabricaEquipo fabricaEquipo) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.fabricaEquipo=fabricaEquipo;
    }

    @Override
    public Long crear(Prestamo prestamo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", prestamo.getId());
        paramSource.addValue("identificacionUsuario", prestamo.getIdentificacionUsuario());
        paramSource.addValue("idEquipo", prestamo.getEquipo().getId());
        paramSource.addValue("fechaPrestamo", prestamo.getFechaPrestamo());
        paramSource.addValue("numeroDias", prestamo.getNumeroDias());
        paramSource.addValue("total", prestamo.getTotal());
        paramSource.addValue("estado", prestamo.isEstado());

        return Integer.toUnsignedLong(this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource));
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", prestamo.getId());
        paramSource.addValue("identificacionUsuario", prestamo.getIdentificacionUsuario());
        paramSource.addValue("idEquipo", prestamo.getEquipo().getId());
        paramSource.addValue("fechaPrestamo", prestamo.getFechaPrestamo());
        paramSource.addValue("numeroDias", prestamo.getNumeroDias());
        paramSource.addValue("total", prestamo.getTotal());
        paramSource.addValue("estado", prestamo.isEstado());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);
    }

    @Override
    public void finalizar(Prestamo prestamo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", prestamo.getId());
        paramSource.addValue("idEquipo", prestamo.getEquipo().getId());
        paramSource.addValue("total", prestamo.getTotal());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlFinalizar, paramSource);
    }

    @Override
    public boolean existeporId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }

    @Override
    public boolean estadoDisponibleEquipo(Long idEquipo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("idEquipo", idEquipo);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }

    @Override
    public boolean existeIdentificacionConPrestamoActivo(String identificacionUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("identificacionUsuario", identificacionUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteIdentificacionconPrestamoActivo, paramSource, Boolean.class);
    }

    @Override
    public Prestamo buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, paramSource, new MapeoPrestamoEntidad(fabricaEquipo));
    }
}
