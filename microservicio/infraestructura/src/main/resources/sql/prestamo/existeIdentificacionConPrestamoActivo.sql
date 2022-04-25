select count(1) from prestamo
where prestamo.identificacion_usuario= :identificacionUsuario and prestamo.estado = true