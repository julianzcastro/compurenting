package com.ceiba.prestamo.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.prestamo.modelo.entidad.Prestamo;
import com.ceiba.prestamo.puerto.repositorio.PrestamoRepositorio;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class PrestamoRepositorioMySQL implements PrestamoRepositorio {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="equipo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="equipo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="equipo", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="equipo", value="existePorId")
    private static String sqlExistePorId;

    @SqlStatement(namespace="equipo", value="estadoDisponibleEquipo")
    private static String sqlExistePorSerial;

    @SqlStatement(namespace="equipo", value="disponible")
    private static String sqlDisponible;

    @SqlStatement(namespace="equipo", value="buscarPorId")
    private static String sqlExistePorIdentificacion;

    public PrestamoRepositorioMySQL(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Prestamo prestamo) {
        return this.customNamedParameterJdbcTemplate.crear(prestamo, sqlCrear);
    }

    @Override
    public void actualizar(Prestamo prestamo) {
        this.customNamedParameterJdbcTemplate.actualizar(prestamo, sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
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
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }
}
