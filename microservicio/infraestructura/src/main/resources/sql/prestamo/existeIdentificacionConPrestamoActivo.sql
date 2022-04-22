select count(1) from prestamo join equipo on prestamo.id_equipo=equipo.id
where prestamo.identificacion_usuario= :identificacionUsuario and equipo.disponible = false