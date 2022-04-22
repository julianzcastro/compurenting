select
prestamo.id prestamo_id, prestamo.identificacion_usuario prestamo_usuario, prestamo.fecha_prestamo,
prestamo.numero_dias prestamo_dias, prestamo.estado prestamo_estado, prestamo.total prestamo_total,

equipo.id equipo_id, equipo.serial equipo_serial, equipo.marca equipo_marca,
equipo.disponible equipo_disponible, equipo.tipo_equipo equipo_tipo

from prestamo join equipo on prestamo.id_equipo=equipo.id where prestamo.id = :id

