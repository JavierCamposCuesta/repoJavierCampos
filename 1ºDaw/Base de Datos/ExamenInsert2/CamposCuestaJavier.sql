--BORRAMOS LAS TABLAS QUE TENEMOS QUE CREAR POR SI POR CASUALIDAD ESTUVIESEN YA CREADAS

DROP TABLE RECIBE;
DROP TABLE ALUMNO;
DROP TABLE ASIGNATURA;
DROP TABLE PROFESOR;



--CREAMOS LAS TABLAS
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

CREATE TABLE RECIBE (
CursoEscolar VARCHAR2(20),
NumMatricula NUMBER(9) REFERENCES ALUMNO,
CodAsignatura VARCHAR2(9) REFERENCES ASIGNATURA,
PRIMARY KEY (CursoEscolar, NumMatricula, CodAsignatura)
);

--APARTADO A Realiza las siguientes inserciones
--Inserta 2 profesores.
INSERT INTO PROFESOR VALUES(123, '29497784P', 'JAVIER', 'PROGRAMACION', '675446757');
INSERT INTO PROFESOR VALUES(1234, '29497785P', 'MANUEL', 'INGLES', '675446758');

--Inserta 4 asignaturas.
INSERT INTO ASIGNATURA VALUES('1A', 'LENGUA', '123');
INSERT INTO ASIGNATURA VALUES('2A', 'MATEMATICAS', '1234');
INSERT INTO ASIGNATURA VALUES('3A', 'LATIN', '123');
INSERT INTO ASIGNATURA VALUES('4A', 'INFORMATICA', '1234');

--Inserta 10 alumnos
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

--Cada alumno debe realizar al menos 2 asignaturas
INSERT INTO RECIBE VALUES('2020/2021',1, '1A');
INSERT INTO RECIBE VALUES('2020/2021',1, '2A');
INSERT INTO RECIBE VALUES('2020/2021',2, '1A');
INSERT INTO RECIBE VALUES('2020/2021',2, '2A');
INSERT INTO RECIBE VALUES('2020/2021',3, '1A');
INSERT INTO RECIBE VALUES('2020/2021',3, '2A');
INSERT INTO RECIBE VALUES('2020/2021',4, '1A');
INSERT INTO RECIBE VALUES('2020/2021',4, '2A');
INSERT INTO RECIBE VALUES('2020/2021',5, '1A');
INSERT INTO RECIBE VALUES('2020/2021',5, '2A');
INSERT INTO RECIBE VALUES('2020/2021',6, '3A');
INSERT INTO RECIBE VALUES('2020/2021',6, '4A');
INSERT INTO RECIBE VALUES('2020/2021',7, '3A');
INSERT INTO RECIBE VALUES('2020/2021',7, '4A');
INSERT INTO RECIBE VALUES('2020/2021',8, '3A');
INSERT INTO RECIBE VALUES('2020/2021',8, '4A');
INSERT INTO RECIBE VALUES('2020/2021',9, '3A');
INSERT INTO RECIBE VALUES('2020/2021',9, '4A');
INSERT INTO RECIBE VALUES('2020/2021',10, '3A');
INSERT INTO RECIBE VALUES('2020/2021',10, '4A');

--APARTADO B Introduce  2  profesores  con  el  mismo  NIF.  ¿Qué  sucede?  ¿Por  qué?
INSERT INTO PROFESOR VALUES(12345, '29497786P', 'FLAVIO', 'GIMNASIA', '675446759'); 
INSERT INTO PROFESOR VALUES(12345, '29497786P', 'JAIRO', 'GIMNASIA', '675446759'); 
	/*Esta sería la sentencia para introducir dos profesores con el mismo dni,
	si introdujesemos primero uno y luego el otro el primero si se nos crearía sin problemas,
	pero el segundo ya no nos dejaría porque la columna dni es única, por lo que los valores no
	se puden repetir.
	Lo que ha sucedido en mi caso que las he introducido las dos a la vez es que ha insertado la 
	primera fila pero la segunda a dado error de restrinccion única, por lo que al final solo tengo 
	al primer profesor FLAVIO introducido*/



--APARTADO C Introduce  2  alumnos  con  el  mismo  NumMatrícula.  ¿Qué  sucede?  ¿Por  qué?
INSERT INTO ALUMNO VALUES(11, 'ERMENEJILDO', '20-05-1990', '675446710');
INSERT INTO ALUMNO VALUES(11, 'PANCRACIO', '20-05-1990', '675446710');
	/*Esta sería la sentecia que utilizaría para introducir dos alumnos con el mismo nuúmero de matrícula,
	al igual que con el caso anterior nos da un fallo por restricción única, ya que la primary key no se 
	pueden repetir. Lo que sucede es que nos inserta la primera fila de ERMENEJILDO pero la segunda no. */

--APARTADO D Introduce  3  alumnos  para  los  cuales  no  conocemos el  número  de  teléfono.
INSERT INTO ALUMNO VALUES(12, 'SOFIA', '20-05-1998', '');
INSERT INTO ALUMNO VALUES(13, 'LUCAS', '20-05-1998', '');
INSERT INTO ALUMNO VALUES(14, 'JUAN', '20-05-1998', '');

--APARTADO E Modifica los datos de los 3 alumnos anteriores para establecer un número de teléfono.
UPDATE ALUMNO SET TELEFONO = '675446711' WHERE NUMMATRICULA =12;
UPDATE ALUMNO SET TELEFONO = '675446712' WHERE NUMMATRICULA =13;
UPDATE ALUMNO SET TELEFONO = '675446713' WHERE NUMMATRICULA =14;

--APARTADO F Para todos los alumnos, poner 2000 como año de nacimiento.
UPDATE ALUMNO SET FECHANACIMIENTO = '01-01-2000';

--APARTADO G Para los profesores que tienen número de teléfono y NIF no comience por 9, poner “Informática” como especialidad.
UPDATE PROFESOR SET ESPECIALIDAD = 'INFORMATICA' WHERE TELEFONO IS NOT NULL AND NIF_P NOT LIKE ('9%');

--APARTADO H Cambia  la  asignación  de  asignaturas  para  los  profesores.  Es  decir,  las asignaturas impartidas por un profesor las dará el otro profesor y viceversa.
UPDATE PROFESOR P1, PROFESOR  P2 SET P1.ESPECIALIDAD = P2.ESPECIALIDAD WHERE P1.IDPROFESOR = 12345 AND P2.IDPROFESOR = 123456;
	--Lo he intentado de esta forma pero no me funciona

--APARTADO I En  la  tabla  Recibe  borra  todos  los  registros  que  pertenecen  a  una  de  las asignaturas.
DELETE FROM RECIBE WHERE CODASIGNATURA ='1A';

--APARTADO J En la tabla Asignatura borra dicha asignatura
DELETE FROM ASIGNATURA WHERE COD_ASIGNATURA ='1A';

--APARTADO K Borra   el   resto   de   asignaturas.   ¿Qué   sucede?   ¿Por   qué?   ¿Como   lo solucionarías?  ¿Podría  haberse  evitado  el  problema  con  otro  diseño  físico?¿Cómo?
DELETE FROM ASIGNATURA ;
	/* Este sería el comnado, pero no funciona, ya que esos dódigos de asignaturas se están 
	utilizando en la tabla recibe, se podría solucionar eliminando antes los registros que tienen 
	asociados esos códigos de asignatura de la tabla recibe, es decir todos.
	Se podría haber evitado poniendo en la tabla asignatura ON DELETE EN CASCADE,
	De esta forma se borraría todo lo que contuviese los codigo de las asignaturas.
	Ahora mismo lo mas sencillo sería borrar primero todos los registros de la tabla recibe y posteriormente
	borrarlo todo de la tabla asignaturas, es decir, los comandos:*/

DELETE FROM RECIBE WHERE CODASIGNATURA ='2A' OR CODASIGNATURA ='3A' OR CODASIGNATURA ='4A';
DELETE FROM ASIGNATURA WHERE CODASIGNATURA ='2A' OR CODASIGNATURA ='3A' OR CODASIGNATURA ='4A';


--APARTADO L Borra todos los profesores. ¿Qué sucede? ¿Por qué? ¿Como lo solucionarías?¿Podría  haberse  evitado  el  problema  con  otro  diseño  físico?¿Cómo?
DELETE FROM PROFESOR ;
 /*Lo que sucede es exactamente igual que en el caso anterior, no podemos borrarlo porque los id de profesor están referenciados en la tabla asignaturas,
 si el comando del apartado anterior (los dos últimos que si borrarían las tablas) lo hubiesemos ejecutado y borrado las asignaturas sí podríamos borrar a 
 todos los profesores, pero como no lo he llegado a ejecutar no podemos borrar a los profesores directamente.
 Al igual que en el caso anterior la solución mas óptima hubiese sido al comienzo de crear las tablas ir poniendo ON DELETE EN CASCADE en las columnas que 
 a referenciar en otras tablas, para que a la hora de borrar datos no tengamos estos problemas.
 Si realmente queremos eliminar los datos de las tablas ASIGNATURA y PROFESOR ejecutariamos estas tres sentencias:*/

DELETE FROM RECIBE;
DELETE FROM ASIGNATURA;
DELETE FROM PROFESOR;

--APARTADO M Borra  todos  los  alumnos.  ¿Qué  sucede?  ¿Por  qué?  ¿Como  lo  solucionarías? ¿Podría  haberse  evitado  el  problema  con  otro  diseño  físico?¿Cómo?
DELETE FROM ALUMNO;
/* Estamos en la misma situación que los dos casos anteriores, este sería el comando para eliminarlo directamente si tuviesemos puesto el NumMatricula con ON DELETE EN CASCADE,
pero como no es así pues no vamos a poder borrarlo directamente, en el caso que ejecutasemos las tres últimas sentencias del apartado L si vamos a poder ejecutar esta sentencia,
ya que el NumMatricula de los alumnos estará borrado de la tabla recibe.
