create table usuario (
 id int not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion date not null,
 primary key (id)
);

create table equipo (
 id int not null auto_increment,
 serial varchar(100) not null,
 marca varchar(45) not null,
 disponible boolean not null,
 tipo_equipo varchar(10) null,
 primary key (id)
);

create table prestamo(
 id int not null auto_increment,
 identificacion_usuario varchar(100) not null,
 fecha_prestamo date not null,
 total int,
 id_equipo int not null,
 primary key (id),
 FOREIGN KEY(id_equipo) REFERENCES equipo(id)
 ON DELETE CASCADE ON UPDATE CASCADE
);
