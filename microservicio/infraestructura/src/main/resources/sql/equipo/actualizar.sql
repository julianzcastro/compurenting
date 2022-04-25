update equipo
set serial = :serial,
	marca = :marca,
	disponible = :disponible,
	tipo_equipo = :tipoEquipo
where id = :id
