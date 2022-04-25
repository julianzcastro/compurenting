package com.ceiba.prestamo.adaptador.repositorio;

import com.ceiba.equipo.comando.fabrica.FabricaEquipo;
import com.ceiba.equipo.fabrica.FabricaEntidadEquipoTransaccional;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.prestamo.fabrica.FabricaEntidadPrestamoTransaccional;
import com.ceiba.prestamo.fabrica.PrestamoTransaccional;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PrestamoRepositorioMySQL implements PrestamoRepositorio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final FabricaEquipo fabricaEquipo;
    private final FabricaEntidadPrestamoTransaccional fabricaEntidadPrestamoTransaccional;

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



    public PrestamoRepositorioMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, FabricaEquipo fabricaEquipo, FabricaEntidadPrestamoTransaccional fabricaEntidadPrestamoTransaccional) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.fabricaEquipo=fabricaEquipo;
        this.fabricaEntidadPrestamoTransaccional=fabricaEntidadPrestamoTransaccional;
    }

    @Override
    public Long crear(Prestamo prestamo) {
        PrestamoTransaccional prestamoTransaccional = fabricaEntidadPrestamoTransaccional.crear(prestamo);
        return this.customNamedParameterJdbcTemplate.crear(prestamoTransaccional, sqlCrear);
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        PrestamoTransaccional prestamoTransaccional = fabricaEntidadPrestamoTransaccional.crear(prestamo);
        this.customNamedParameterJdbcTemplate.actualizar(prestamoTransaccional, sqlActualizar);
    }

    @Override
    public void finalizar(Prestamo prestamo) {
        PrestamoTransaccional prestamoTransaccional = fabricaEntidadPrestamoTransaccional.crear(prestamo);
        this.customNamedParameterJdbcTemplate.actualizar(prestamoTransaccional, sqlFinalizar);
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
