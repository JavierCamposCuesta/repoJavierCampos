Crear la siguiente base de datos:
MEDICO (#cod_medico, nombre, especialidad, cod_director)
PK(cod_medico)
FK(cod_director)/MEDICO

INGRESO (#cod_ingreso, cod_inscripcion, fecha_ingreso, fecha_alta, num_hab)
PK(cod_ingreso)
FK(num_hab)/HABITACION
FK(cod_inscripcion)/ENFERMO

ENFERMO (#cod_inscripcion, nss, nombre, sexo)
PK(cod_inscripcion)

HABITACION(#num_hab, numero_camas)
PK(num_hab) 

VISITA (#cod_medico, #cod_inscripcion, fecha, diagnostico)
PK(cod_medico, cod_inscripcion) 
FK(cod_medico)/MEDICO
FK(cod_inscripcion)/ENFERMO

APARTADO 1. Notas a tener en cuenta  en la creación de la BD
    1. El NSS es una cadena de longitud 10.
    2. La fecha de ingreso deberá toma como valor  la fecha del día actual
    3. Los números de habitación están entre 100 y 399.
    4. El número de camas máximo de un habitación son 3.
    5. La fecha de alta puede estar vacía pero si tiene valor será mayor que la fecha de ingreso
    6. Si no se indica nada,  la especialidad de un médico es  'FAM'.
    7. No debe borrarse una habitación si hay ingresos en ella.
    8. Cuando se borre un médico, los médicos que dependían de  el aparecerán temporalmente con el dato de su director a nulo.
APARTADO 2. Una vez que haz creado la base de datos realiza los siguientes cambios:
    9. El campo sexo podrá tomar valores 'H', o 'M'.
    10. Nos llaman para decirnos que en la base de datos no pueden insertar que un mismo médico vea dos veces a un mismo enfermo. ¿A qué puede ser debido? Arréglalo
    11. El  NSS es de longitud 12 y deberá empezar por un número, seguido de 5 caracteres (A-Z) un guión y otros 5 caracteres.
    12. La especialidad de un médico son siempre 3 caracteres y  en mayúscula.
    13. No se realizarán visitas los días 24 y 25 de Diciembre.
    14. Insertar un médico con código 1  y dos enfermos con código 1 y 2 y datos inventados.
    15. El enfermo 1 ingresa hoy en la habitación 102 que tiene 2 camas. Inserta los registros necesarios en la BD.
    16. El médico 1 visita al enfermo 1 hoy. Inserta los registros necesarios en la BD.
    17. Añade el campo fecha_próxima_visita a la tabla Visita.
    18. Cambia el enfermo 1, su nombre a 'PEPE PEREZ' y sexo 'H'.
    19. Borra todos los datos que hay en la BD del enfermo 1.
    20. Borra todas las tablas con el número mínimo de instrucciones.

CREATE TABLE MEDICO (
COD_MEDICO VARCHAR2(9) PRIMARY KEY,
COD_DIRECTOR VARCHAR2(9) NOT NULL,
ESPECIALIDAD VARCHAR2(20) DEFAULT 'FAN',
CONSTRAINT FK_DIRECT_MEDIC FOREIGN KEY (COD_DIRECTOR) REFERENCES MEDICO
);

CREATE TABLE ENFERMO (
COD_INSCRIPCION VARCHAR2(9) PRIMARY KEY,
NSS VARCHAR2(10),
NOMBRE VARCHAR2(20),
SEXO VARCHAR2(10)
); 

CREATE TABLE HABITACION (
NUM_HAB NUMBER(3) PRIMARY KEY, 
NUM_CAMAS NUMBER(1) CHECK (NUM_CAMAS IN (1, 2, 3)),
CONSTRAINT NUM_HABI_MAXIMO CHECK (NUM_HAB BETWEEN 100 AND 399)
); 

CREATE TABLE INGRESO (
COD_INGRESO VARCHAR2(9) PRIMARY KEY,
FECHA_INGRESO DATE DEFAULT SYSDATE,
FECHA_ALTA DATE,
COD_INSCRIPCION VARCHAR2(9) REFERENCES ENFERMO,
NUM_HAB NUMBER(3) REFERENCES HABITACION,
CONSTRAINT FECHA_MAYOR CHECK(FECHA_ALTA > FECHA_INGRESO)
); 

CREATE TABLE VISITA (
FECHA DATE,
DIAGNOSTICO VARCHAR2(20),
COD_MEDICO VARCHAR2(9) REFERENCES MEDICO,
COD_INSCRIPCION VARCHAR2(9) REFERENCES INGRESO,
PRIMARY KEY (COD_MEDICO, COD_INSCRIPCION)
); 

APARTADO 2. Una vez que haz creado la base de datos realiza los siguientes cambios:
    9. El campo sexo podrá tomar valores 'H', o 'M'.
    ALTER TABLE ENFERMO MODIFY (SEXO CHAR(1));
    10. Nos llaman para decirnos que en la base de datos no pueden insertar que un mismo médico vea dos veces a un mismo enfermo. ¿A qué puede ser debido? Arréglalo

    --PRIMERO BORRAMOS LA PRIMARI KEY DE LA TABLA VISITA
    ALTER TABLE VISITA DROP PRIMARY KEY;

    --PONEMOS COMO CLAVE PRIMARIA A LAS MISMAS QUE TENIA ANTES MAS LA FECHA

    ALTER TABLE VISITA ADD PRIMARY KEY(COD_MEDICO, COD_INSCRIPCION, FECHA);

    11. El  NSS es de longitud 12 y deberá empezar por un número, seguido de 5 caracteres (A-Z) un guión y otros 5 caracteres.
    ALTER TABLE ENFERMO MODIFY NSS VARCHAR2(12) CHECK(REGEXP_LIKE(NSS, '[0-9]-[A-Z][A-Z][A-Z][A-Z][A-Z]-[A-Z][A-Z][A-Z][A-Z][A-Z]'));
    12. La especialidad de un médico son siempre 3 caracteres y  en mayúscula.
	ALTER TABLE MEDICO MODIFY ESPECIALIDAD VARCHAR2(3) CHECK(REGEXP_LIKE(ESPECIALIDAD, '[A-Z][A-Z][A-Z]'));
    13. No se realizarán visitas los días 24 y 25 de Diciembre.

    14. Insertar un médico con código 1  y dos enfermos con código 1 y 2 y datos inventados.
    15. El enfermo 1 ingresa hoy en la habitación 102 que tiene 2 camas. Inserta los registros necesarios en la BD.
    16. El médico 1 visita al enfermo 1 hoy. Inserta los registros necesarios en la BD.
    17. Añade el campo fecha_próxima_visita a la tabla Visita.
    18. Cambia el enfermo 1, su nombre a 'PEPE PEREZ' y sexo 'H'.
    19. Borra todos los datos que hay en la BD del enfermo 1.
    20. Borra todas las tablas con el número mínimo de instrucciones.