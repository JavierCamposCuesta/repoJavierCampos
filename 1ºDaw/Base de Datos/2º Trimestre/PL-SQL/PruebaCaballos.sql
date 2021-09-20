-- PRUEBA PRÁCTICA 11/05/2020 PL/SQL
-- ES IMPORTANTE EN TODOS LOS EJERCICIOS CONTROLAR LAS EXCEPCIONES, ADEMÁS DE
-- COMENTAR EL CÓDIGO PARA QUE RESULTE MÁS FÁCIL SU ENTENDIMIENTO.
-- NO OLVIDÉIS CUIDAR A ORACLE, ES DECIR, IMPLEMENTAR CÓDIGO DE CALIDAD Y ÓPTIMO.
-- El examen consta de 3 ejercicios. Deberá entregarse los scripts necesarios para la
-- implementación así como incluirse un script que permita la prueba del procedimiento y función
-- creada. Incluir ejemplos de llamada a la función y al procedimiento.

-- 1. (1 punto) Crea un paquete con la siguiente nomenclatura TUNOMBREgestioncarreras que
-- contendrá la función y el procedimiento solicitados en el ejercicio 2 y ejercicio3. Es decir
-- tendrá:
--  Función listadocaballos que no recibirá ningún parámetro y devolverá un número.
--  Procedimiento agregarcaballos que recibirá como argumento el nombre, peso, fecha
-- de nacimiento, nacionalidad y el dni y el nombre del dueño

CREATE OR REPLACE
PACKAGE JavierGestionCarreras AS
    FUNCTION listadoCaballos  RETURN NUMBER;
    PROCEDURE agregarCaballos (NOMBRE VARCHAR, peso NUMBER, nacimiento date, nacionalidad varchar2, 
    dni varchar2, nombrePropietario varchar2);

END;
-- 2. (5 puntos) Realiza una FUNCIÓN listadocaballos que muestre en consola el siguiente listado y
-- que devuelva el número de caballos mostrados en el listado.
-- INFORME DE LOS CABALLOS EXISTENTES EN LA BASE DE DATOS
-- Caballo: Nombre del caballo1
-- Peso: XXXXXX
-- Nombre del Propietario: XXXXX
-- Nombre de Carrera Nombre del jokey Fecha Posición Final Importe Premio
-- ….
-- Nombre de Carrera Nombre del jokey Fecha Posición Final Importe Premio
-- Número de carreras ganadas: nnnnn
-- Total del importe de todos sus premios: nnnnnn
-- Caballo: Nombre del caballo2
-- Peso: XXXXX
-- Nombre del dueño: XXXXX
-- Nombre de Carrera Nombre del jokey Fecha Posición Final Importe Premio
-- ….
-- Nombre de Carrera Nombre del jokey Fecha Posición Final Importe Premio
-- Número de carreras ganadas: nnnnn
-- Total del importe de todos sus premios: nnnnnn 
-- PRUEBA PRÁCTICA 11/05/2020 PL/SQL
-- Los caballos deben salir ordenados descendentemente por nacionalidad, y dentro de la
-- nacionalidad por el nombre del propietario, y luego las carreras ordenadas por nombre
-- de carrera y fecha.

CREATE OR REPLACE FUNCTION listadocaballos RETURN NUMBER IS
numCaballos NUMBER(5);
codigoCaballo VARCHAR2(20);
numVictorias NUMBER(5);
importeTotal NUMBER(7);

CURSOR caballos IS SELECT c2.CODCABALLO,c2.NOMBRE , c2.PESO , c2.NACIONALIDAD , p.NOMBRE AS propietario FROM CABALLOS c2, PERSONAS p
WHERE p.CODIGO = c2.PROPIETARIO
ORDER BY c2.NACIONALIDAD DESC , p.NOMBRE;

CURSOR carreras IS SELECT c.CODCARRERA , c.NOMBRECARRERA ,p.NOMBRE, c.FECHAHORA, p2.POSICIONFINAL, c.IMPORTEPREMIO
FROM CARRERAS c ,PERSONAS p, PARTICIPACIONES p2, CABALLOS c2
WHERE codigoCaballo = c2.CODCABALLO AND c2.CODCABALLO  = p2.CODCABALLO AND
c.CODCARRERA = p2.CODCARRERA AND p2.JOCKEY = p.CODIGO
ORDER BY c.NOMBRECARRERA, c.FECHAHORA ;


   BEGIN
	SELECT COUNT(DISTINCT c.CODCABALLO) INTO numCaballos FROM CABALLOS c;
	dbms_output.put_line('INFORME DE LOS CABALkLOS EXISTENTES EN LA BASE DE DATOS');

	FOR i IN caballos LOOP
	dbms_output.put_line('Caballo: '||i.NOMBRE);
	dbms_output.put_line('Peso: '||i.PESO);
	dbms_output.put_line('Nombre propietario: '||i.PROPIETARIO);
	dbms_output.put_line('');

	codigoCaballo := i.CODCABALLO;
		FOR j IN carreras LOOP
			dbms_output.put_line('Nombre de carrera: '|| j.NOMBRECARRERA);
			dbms_output.put_line('Nombre del jokey: '|| j.NOMBRE);
			dbms_output.put_line('Fecha: '|| j.FECHAHORA);
			dbms_output.put_line('Posición Final: '|| j.POSICIONFINAL);
			dbms_output.put_line('Importe Premio: '|| j.IMPORTEPREMIO);
			dbms_output.put_line('');
		END LOOP;

	SELECT COUNT(p.CODCABALLO) INTO numVictorias FROM PARTICIPACIONES p
	WHERE p.POSICIONFINAL = 1 AND p.CODCABALLO = i.CODCABALLO;
	dbms_output.put_line('Número de carreras  ganadas: '||numVictorias);

	SELECT SUM(c.IMPORTEPREMIO) INTO importeTotal FROM PARTICIPACIONES p , CARRERAS c
	WHERE  p.POSICIONFINAL = 1 AND p.CODCARRERA = c.CODCARRERA AND p.CODCABALLO = i.CODCABALLO;
	dbms_output.put_line('Total del importe de todos sus premios: ' || importeTotal);

	END LOOP;
	RETURN numCaballos;
END listadocaballos;

    select LISTADOCABALLOS() from dual;


-- 3. (4 puntos) Realizar un PROCEDIMIENTO agregarcaballos que reciba como argumento el
-- nombre, peso, fecha de nacimiento, nacionalidad y el dni y el nombre del dueño. El
-- procedimiento debe insertar el dueño si este no existe, y luego insertar el caballo. Si hay algún
-- fallo debe dejar la base de datos como estaba, es decir, no puede insertar el dueño si no
-- puede insertar el caballo. Si la nacionalidad no tiene ningún valor se le pondrá “ESPAÑOL”.
   create or replace PROCEDURE agregarCaballos (NOMBRE1 VARCHAR, peso1 NUMBER, nacimiento1 date, nacionalidadN varchar2, dni1 varchar2, nombrePropietario varchar2) is
    comprobarNombre number:= 0 ;
        codigoCaballo number;
        codigoPersona number;
        cantidadCaballosVieja number:=0;
        cantidadCaballosNueva number:=0;
        nacionalidad3 varchar2(200):=nacionalidadN;

        noSePuedeInsertar EXCEPTION;
    BEGIN
        select count(*) into comprobarNombre from PERSONAS where PERSONAS.DNI=dni1;
        select max(CODCABALLO)+1 into codigoCaballo from CABALLOS;
        select max(CODIGO)+1 into codigoPersona from PERSONAS;
        select count(*) into cantidadCaballosVieja from CABALLOS;



        if comprobarNombre=0 then
            insert into PERSONAS(codigo, dni, nombre) values (codigoPersona,dni1, nombrePropietario);

            if nacionalidadN is null then
                nacionalidad3:='ESPAÑOL';
            end if;
             insert into CABALLOS(codcaballo, nombre, peso, fechanacimiento, propietario, nacionalidad) values(codigoCaballo,nombre1, peso1,nacimiento1
            , codigoPersona, NACIONALIDAD3);
        else
             insert into CABALLOS(codcaballo, nombre, peso, fechanacimiento, propietario, nacionalidad) values(codigoCaballo,nombre1, peso1,nacimiento1
            , codigoPersona, NACIONALIDAD3);

        end if;

            select count(*) into cantidadCaballosNueva from CABALLOS;

            IF cantidadCaballosVieja<>cantidadCaballosNueva then
                delete from PERSONAS where CODIGO = codigoPersona+1;

            else
                raise noSePuedeInsertar;
            end if;


        EXCEPTION
    WHEN noSePuedeInsertar THEN
      DBMS_OUTPUT.PUT_LINE ('No se puede insertar');

    end;











CREATE OR REPLACE
PACKAGE JavierGestionCarreras AS
    FUNCTION listadoCaballos  RETURN NUMBER;
    PROCEDURE agregarCaballos (NOMBRE VARCHAR, peso NUMBER, nacimiento date, nacionalidad varchar2, dni varchar2, nombrePropietario varchar2);

END;

    CREATE OR REPLACE PACKAGE BODY JavierGestionCarreras IS
        FUNCTION listadoCaballos RETURN NUMBER IS
    id number;
    BEGIN
    SELECT DepartamentoEj3.id INTO id from DEPARTAMENTOEJ3 where NOMBRE= nombre1;

    return id;

    end;
PROCEDURE agregarCaballos (NOMBRE VARCHAR, peso NUMBER, nacimiento date, nacionalidadN varchar2, dni varchar2, nombrePropietario varchar2) is
    comprobarNombre number:= 0 ;
        codigoCaballo number:=0;
        codigoPersona number:=0;
        cantidadCaballosVieja number:=0;
        cantidadCaballosNueva number:=0;

        noSePuedeInsertar EXCEPTION;
    BEGIN
        select count(*) into comprobarNombre from PERSONAS where DNI=dni;
        select max(CODCABALLO) into codigoCaballo from CABALLOS;
        select max(codigoPersona) into codigoPersona from PERSONAS;



        if comprobarNombre=0 then
            insert into PERSONAS(codigo, dni, nombre) values (codigoPersona+1,dni, nombrePropietario);
            if nacionalidadN is null then
                nacionalidadN:='ESPAÑOL';
            end if;
             select count(*) into cantidadCaballosVieja from CABALLOS;
            insert into CABALLOS(codcaballo, nombre, peso, fechanacimiento, propietario, nacionalidad) values(codigoCaballo+1,peso,FECHANACIMIENTO
            , codigoPersona+1, NACIONALIDADN);
            select count(*) into cantidadCaballosNueva from CABALLOS;

            IF cantidadCaballosVieja<>cantidadCaballosNueva then
                delete from PERSONAS where CODIGO = codigoPersona+1;
            end if;
            else
                raise noSePuedeInsertar;
        end if;

        EXCEPTION
    WHEN noSePuedeInsertar THEN
      DBMS_OUTPUT.PUT_LINE ('No se puede insertar');

    end;


    end;







--Flavio
     create or replace  PROCEDURE AGREGARCABALLO1(nombre VARCHAR2,  peso NUMBER,
     nacimiento DATE,   nacionalidadc VARCHAR2,
     dniPERSONA VARCHAR2, NOMBREPROPI VARCHAR2) IS

    COMPARADOR NUMBER;
    CODIGONUEVO NUMBER;
    CODIGONUEVOCABALLO NUMBER;
    SIZEOLD NUMBER;
    SIZENEW NUMBER;
    NACIONALIDAD3 VARCHAR2(100);
    CODIGOPROPIETARIO NUMBER;


    BEGIN

        IF NACIONALIDADC IS NULL THEN
            nacionalidad3:='ESPAÑOL';

        ELSE
             nacionalidad3:=nacionalidadc;

        END IF;


    SELECT COUNT(*) INTO COMPARADOR FROM PERSONAS WHERE DNI=DNIPERSONA;
    SELECT MAX(CODIGO)+1 INTO CODIGONUEVO FROM PERSONAS;
    SELECT MAX(CODCABALLO)+1 INTO CODIGONUEVOCABALLO FROM CABALLOS;
    SELECT COUNT(*) INTO SIZEOLD FROM CABALLOS;




    IF COMPARADOR=0 THEN

        INSERT INTO PERSONAS (CODIGO, DNI, NOMBRE) VALUES (codigonuevo,
                                                           DNIPERSONA, NOMBREPROPI);
        INSERT INTO CABALLOS (NOMBRE, PESO, FECHANACIMIENTO, NACIONALIDAD, PROPIETARIO,
                              CODCABALLO) values (nombre ,  peso ,
     nacimiento,   nacionalidad3, CODIGONUEVO, CODIGONUEVOCABALLO);

    ELSE
        SELECT CODIGO INTO CODIGOPROPIETARIO FROM PERSONAS WHERE DNI=dniPERSONA;

        INSERT INTO CABALLOS (NOMBRE, PESO, FECHANACIMIENTO, NACIONALIDAD,
                              PROPIETARIO, CODCABALLO) values (nombre ,  peso ,
     nacimiento,   nacionalidad3, CODIGOPROPIETARIO, CODIGONUEVOCABALLO);


    end if;



    end;
