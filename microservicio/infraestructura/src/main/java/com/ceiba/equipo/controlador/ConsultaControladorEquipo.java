package com.ceiba.equipo.controlador;

import com.ceiba.equipo.consulta.ManejadorListarEquipos;
import com.ceiba.equipo.modelo.dto.EquipoDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipos")
@Api(tags = { "Controlador consulta equipos"})
public class ConsultaControladorEquipo {
    private final ManejadorListarEquipos manejadorListarEquipos;

    public ConsultaControladorEquipo(ManejadorListarEquipos manejadorListarEquipos) {
        this.manejadorListarEquipos = manejadorListarEquipos;
    }

    @GetMapping()
    @ApiOperation("Listar Equipos")
    public List<EquipoDTO> consultar(){
        return manejadorListarEquipos.ejecutar();
    }
}
