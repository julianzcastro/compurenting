update prestamo
inner join
equipo
on
equipo.id=prestamo.id_equipo
set
prestamo.total= :total, prestamo.estado=false, equipo.disponible= true
where
prestamo.id_equipo = :idEquipo