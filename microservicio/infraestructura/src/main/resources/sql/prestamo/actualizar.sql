update prestamo
set identificacion_usuario = :identificacionUsuario,
	id_equipo = :idEquipo,
	fecha_prestamo = :fechaPrestamo,
	total = :total,
	estado= :estado

where id = :id


