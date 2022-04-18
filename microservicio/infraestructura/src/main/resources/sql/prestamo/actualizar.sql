update prestamo
set identificacion_usuario = :identificacionUsuario,
	fecha_prestamo = :fechaPrestamo,
	total = :total,
	id_equipo = :idEquipo
where id = :id