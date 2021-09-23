-- Enunciado:
-- Creación
--     + Tendremos 3 entidades: profesor, asignatura, alumno , recibe.
--     + Del profesor recogeremos un idProfesor, un nif, nombre, especialidad y telefono.
--     + De la asignatura almacenaremos el cod, nombre y el id del profesor que la imparte
--     + Del alumno recogeremos el numero de matricula, su nombre, fecha de nacimiento y telefono
--     + La tabla recibe tendra un atributo cursoEscolar y su primary Key sera el curso, el num matricula y el cod asignatura

-- Insert, delete, update
--     + Insertaremos 2 profesores, 4 asignaturas, 10 alumnos y cada alumno realizará 2 asignaturas.
--     + Modificaremos el telefono de 2 alumnos
--     + Pondremos a todos los alumnos la misma fecha de nacimiento
--     + A los profesores que no tengan numero de telefono y el nif no comiencen por 9, le pondremos informatica como especialidad
--     + Borraremos a 2 alumnos.


--Primero comenzaremos borrando las tablas que tenemos que crear, por si quizas estuviesen ya creadas
DROP TABLE RECIBE;
DROP TABLE ALUMNO;
DROP TABLE ASIGNATURA;
DROP TABLE PROFESOR;

--Creamos las tablas
CREATE TABLE PROFESOR (
IdProfesor NUMBER(9) PRIMARY KEY,
NIF_P VARCHAR2(10) UNIQUE,
Nombre VARCHAR2(20),
Especialidad VARCHAR2(20),
Telefono VARCHAR2(9)
);

CREATE TABLE ASIGNATURA (
Cod_Asignatura VARCHAR2(9) PRIMARY KEY,
Nombre VARCHAR2(20),
IdProfesor NUMBER(9) REFERENCES PROFESOR
);

CREATE TABLE ALUMNO (
NumMatricula NUMBER(9) PRIMARY KEY,
Nombre VARCHAR2(20),
FechaNacimiento DATE,
Telefono VARCHAR2(9)
);

--Insertamos 2 profesores
INSERT INTO PROFESOR VALUES(123, '29497784P', 'JORGE', 'PROGRAMACION', '675446757');
INSERT INTO PROFESOR VALUES(1234, '29497785P', 'JOAQUIN', 'DESPLIEGUE', '675446758');

--Insertamos 4 asignaturas
INSERT INTO ASIGNATURA VALUES('1A', 'PROGRAMACION', '123');
INSERT INTO ASIGNATURA VALUES('2A', 'DESPLIEGUE', '1234');
INSERT INTO ASIGNATURA VALUES('3A', 'ENTORNO-SERVIDOR', '123');
INSERT INTO ASIGNATURA VALUES('4A', 'ENTORNO-CLIENTE', '1234');

--Insertamos 10 alumnos
INSERT INTO ALUMNO VALUES(1, 'ANTONIO', '29-05-1998', '675446700');
INSERT INTO ALUMNO VALUES(2, 'JOSE', '28-05-1998', '675446701');
INSERT INTO ALUMNO VALUES(3, 'JOSE', '27-05-1998', '675446702');
INSERT INTO ALUMNO VALUES(4, 'MARIO', '26-05-1998', '675446703');
INSERT INTO ALUMNO VALUES(5, 'LUCIA', '25-05-1998', '675446704');
INSERT INTO ALUMNO VALUES(6, 'MARIA', '24-05-1998', '675446705');
INSERT INTO ALUMNO VALUES(7, 'CLAUDIA', '23-05-1998', '675446706');
INSERT INTO ALUMNO VALUES(8, 'RAFA', '22-05-1998', '675446707');
INSERT INTO ALUMNO VALUES(9, 'CRISTINA', '21-05-1998', '675446708');
INSERT INTO ALUMNO VALUES(10, 'JAIME', '20-05-1998', '675446709');

--Cada alumno realizará 2 asignaturas
INSERT INTO RECIBE VALUES('2021/2022',1, '1A');
INSERT INTO RECIBE VALUES('2021/2022',1, '2A');
INSERT INTO RECIBE VALUES('2021/2022',2, '1A');
INSERT INTO RECIBE VALUES('2021/2022',2, '2A');
INSERT INTO RECIBE VALUES('2021/2022',3, '1A');
INSERT INTO RECIBE VALUES('2021/2022',3, '2A');
INSERT INTO RECIBE VALUES('2021/2022',4, '1A');
INSERT INTO RECIBE VALUES('2021/2022',4, '2A');
INSERT INTO RECIBE VALUES('2021/2022',5, '1A');
INSERT INTO RECIBE VALUES('2021/2022',5, '2A');
INSERT INTO RECIBE VALUES('2021/2022',6, '3A');
INSERT INTO RECIBE VALUES('2021/2022',6, '4A');
INSERT INTO RECIBE VALUES('2021/2022',7, '3A');
INSERT INTO RECIBE VALUES('2021/2022',7, '4A');
INSERT INTO RECIBE VALUES('2021/2022',8, '3A');
INSERT INTO RECIBE VALUES('2021/2022',8, '4A');
INSERT INTO RECIBE VALUES('2021/2022',9, '3A');
INSERT INTO RECIBE VALUES('2021/2022',9, '4A');
INSERT INTO RECIBE VALUES('2021/2022',10, '3A');
INSERT INTO RECIBE VALUES('2021/2022',10, '4A');

--Modificaremos el telefono de 2 alumnos
UPDATE ALUMNO SET Telefono '675446800' WHERE NumMatricula = 12;
UPDATE ALUMNO SET Telefono '675446801' WHERE NumMatricula = 13;


