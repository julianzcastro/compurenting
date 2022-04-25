--insert into usuario(id, nombre,clave,fecha_creacion) values(1,'test','1234',now());

insert into equipo (id, serial, marca, disponible, tipo_equipo) values (1, 'SN1', 'Dell', false, 'Básico');
insert into equipo (id, serial, marca, disponible, tipo_equipo) values (2, 'SN2', 'Apple', false, 'Gamer');
insert into equipo (id, serial, marca, disponible, tipo_equipo) values (3, 'SN3', 'Sony', true, 'Básico');


insert into prestamo (id, identificacion_usuario, id_equipo, fecha_prestamo, numero_dias, total, estado) values (1, 100, 1, now(), 5, 15, true);
insert into prestamo (id, identificacion_usuario, id_equipo, fecha_prestamo, numero_dias, total, estado) values (2, 101, 2, now(), 5,25, true);
