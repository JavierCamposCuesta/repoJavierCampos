CREATE TABLE Medico(
	cod_medico NUMBER(5),
	nombre VARCHAR2(30),
	especialidad VARCHAR2(30) DEFAULT 'FAM',
	cod_director NUMBER(5),
	CONSTRAINT med_cod_medico_pk PRIMARY KEY(cod_medico),
	CONSTRAINT med_cod_director_fk FOREIGN KEY(cod_director) REFERENCES Medico ON DELETE SET NULL
	);

CREATE TABLE Enfermo
	(cod_inscripcion NUMBER(5),
	nss VARCHAR2(10),
	nombre VARCHAR2(30)
	sexo VARCHAR2(1)
	CONSTRAINT enf_cod_inscripcion_pk PRIMARY KEY(cod_inscripcion));

CREATE TABLE Habitacion
	(numhab NUMBER(3) CONSTRAINT hab_numhab CHECK (numhab BETWEEN 100 AND 399),
	numcamas NUMBER(1) CONSTRAINT hab_numcamas CHECK (numcamas BETWEEN 1 AND 3),
	CONSTRAINT hab_pk PRIMARY KEY(numhab)
);
	
CREATE TABLE Ingreso(
	codingreso NUMBER(5),
	cod_inscripcion NUMBER(5),
	fecha_ingreso DATE DEFAULT SYSDATE,
	fecha_alta DATE,
	numhab NUMBER(3),
	CONSTRAINT ingreso_fecha_alta CHECK ( fecha_alta > fecha_ingreso),
	CONSTRAINT ingreso_pk  PRIMARY KEY(codingreso),
	CONSTRAINT ingreso_cod_insc_fk FOREIGN KEY (cod_inscripcion) REFERENCES Enfermo  ON DELETE CASCADE,
	CONSTRAINT ingreso_numhab_fk FOREIGN KEY(numhab) REFERENCES Habitacion);

CREATE TABLE Visita (
	cod_medico NUMBER(5),
	cod_inscripcion NUMBER(5),
	fecha DATE,
	diagnostico VARCHAR2(30),
	CONSTRAINT visita_pk PRIMARY KEY(cod_medico, cod_inscripcion),
	CONSTRAINT visita_fk_med FOREIGN KEY (cod_medico) REFERENCES Medico ON DELETE CASCADE,
	CONSTRAINT visita_fk_enf FOREIGN KEY (cod_inscripcion) REFERENCES Enfermo ON DELETE CASCADE
	);

/*
9
*/
ALTER TABLE Enfermo ADD CONSTRAINT enfermo_sexo_h_m CHECK (sexo='H' or sexo='M'); 

/*
10
*/
ALTER TABLE visita DROP CONSTRAINT visita_pk;
ALTER TABLE visita ADD CONSTRAINT visita_pk PRIMARY KEY(cod_medico, cod_inscripcion, fecha);

/*
11
*/
ALTER TABLE Enfermo MODIFY nss VARCHAR2(12);
ALTER TABLE Enfermo ADD CONSTRAINT enfermo_nss CHECK ( REGEXP_LIKE( nss, '[0-9][A-Z]{5}-[A-Z]{5}'));



/*
12
*/
ALTER TABLE MEDICO ADD CONSTRAINT med_especialidad CHECK ( especialidad=upper(especialidad) and length(especialidad)=3);

/*
13
*/


ALTER TABLE visita ADD CONSTRAINT visita_fecha_no_navidad 
	CHECK ( to_char(fecha, 'dd/mm') <> '24/12' AND  to_char(fecha, 'dd/mm') <> '25/12');

/*
14
*/

insert into medico (cod_medico, nombre) values (1, 'PEPITO EL MEDICO');
insert into enfermo VALUES (1, '9AAAAA-ZZZZZ', 'JUANITO','M');
insert into enfermo VALUES (2, '3ZZZZZ-AAAAA', 'ANDRES', 'H');

/*
15
*/
insert into habitacion values (100, 3);
insert into ingreso(codingreso, cod_inscripcion, numhab) VALUES ( 1, 1, 100);
/*

/*
16
*/

insert into visita values (1, 2, sysdate, 'resfriado');

/*
17
*/

alter table visita add fecha_proxima_visita DATE;

/*
18
*/
update enfermo set nombre='PEPE PEREZ'  where  cod_inscripcion=1;
update enfermo set sexo='H'  where  cod_inscripcion=1;

/*
19
*/
delete from enfermo where cod_inscripcion=1;


/*
20
*/
drop table visita;
drop table ingreso;
drop table habitacion;
drop table enfermo;
drop table medico;