package com.ceiba.equipo.comando.fabrica;

import com.ceiba.equipo.comando.ComandoEquipo;
import com.ceiba.equipo.modelo.entidad.Equipo;
import com.ceiba.tipoequipo.TipoEquipoEnum;
import org.springframework.stereotype.Component;

@Component
public class FabricaEquipo {
    public Equipo crear(ComandoEquipo comandoEquipo){
        return new Equipo(
                comandoEquipo.getId(),
                comandoEquipo.getSerial(),
                comandoEquipo.getMarca(),
                comandoEquipo.isDisponible(),
                asignarTipoEquipo(comandoEquipo.getTipoEquipo())
        );
    }

    private TipoEquipoEnum asignarTipoEquipo(String tipo){
        if(TipoEquipoEnum.BASICO.getDescripcion().equalsIgnoreCase(tipo)){
            return TipoEquipoEnum.BASICO;
        }else{
            return TipoEquipoEnum.GAMER;
        }
    }
}
