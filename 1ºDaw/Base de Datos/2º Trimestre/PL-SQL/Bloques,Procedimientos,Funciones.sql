--1.-Escribir un bloque PL/SQL que escriba el texto ‘Hola’
BEGIN
	 DBMS_OUTPUT.PUT_LINE ('Hola');
END;
/

--2.-Escribir  un  bloque  PL/SQL  que  cuente  el  número  de  filas  que  hay  en  
la  tabla productos, deposita el resultado en la variable v_num, y visualiza su 
contenido.

DECLARE
v_num NUMBER(9);
BEGIN
	SELECT COUNT(*) INTO v_num FROM ALUMNO a;
	 DBMS_OUTPUT.PUT_LINE(v_num);
END;
/


--CREATE OR REPLACE PROCEDURE/ FUNTION
--1) Escribir un procedimiento que reciba dos números y visualice su suma.

CREATE OR REPLACE PROCEDURE SUMA(NUM1 NUMBER, NUM2 NUMBER) IS
BEGIN
    DBMS_OUTPUT.PUT_LINE(NUM1+NUM2);
end;
/

CALL SUMA(8, 3)

--2) Codificar un procedimiento que reciba una cadena y la visualice al revés.

create or replace PROCEDURE CADENA_REVES(cadena VARCHAR2) IS
i number :=1;
nuevaCadena varchar2(50);
    BEGIN
    LOOP
        EXIT WHEN i>  length(cadena);
        nuevaCadena:=concat(substr(cadena, i, 1),nuevaCadena);
        i:=i+1;
    end loop;
     DBMS_OUTPUT.PUT_LINE(nuevaCadena);
end;
/

--------------------------------------

create or replace procedure cadena_reves(cadena varchar2) is
cadenaInversa varchar2(100);
    begin
        for i in reverse 1..length(cadena)
        loop
            cadenaInversa:= concat(cadenaInversa, substr(cadena, i, 1));
            end loop;
        DBMS_OUTPUT.PUT_LINE(cadenaInversa);
    end;

call CADENA_REVES('hola mundo')


--3) Escribir una función que reciba una fecha y devuelva el año, en número, 
correspondiente a esa fecha.

create function soloYear(fecha date) return number is
    begin
        return extract(year from fecha);
end;
/

SELECT SOLOYEAR('15-05-2021') FROM DUAL;


--4) Escribir un bloque PL/SQL que haga uso de la función anterior
--Este bloque calcula la edad que tenias en el año 2021
create PROCEDURE calcularEdad(fecha date) is
edad number;
    yearNacimiento number;
begin
   yearNacimiento:=to_number(SOLOYEAR(fecha));
   edad:=2021-yearNacimiento;
    DBMS_OUTPUT.PUT_LINE(edad);
end;
/


call CALCULAREDAD('29-05-1993')

/*
5) Dado el siguiente procedimiento: 
CREATE OR REPLACE PROCEDURE crear_depart 
( v_num_dept depart.dept_no%TYPE,
 v_dnombre depart.dnombre%TYPE DEFAULT 'PROVISIONAL',
  v_loc depart.loc%TYPE DEFAULT ‘PROVISIONAL’) IS 
  BEGIN
   INSERT INTO depart 
   VALUES
   (v_num_dept, v_dnombre, v_loc); 
   END crear_depart; 
   
   Indicar cuáles de las siguientes llamadas son correctas y cuáles incorrectas, en este 
   último caso escribir la llamada correcta usando la notación posicional (en los casos 
   que se pueda): 
   1º. crear_depart;  
   2º. crear_depart(50); Correcta
   3º. crear_depart('COMPRAS'); 
   4º. crear_depart(50,'COMPRAS'); Correcta
   5º. crear_depart('COMPRAS', 50); 
   6º. crear_depart('COMPRAS', 'VALENCIA'); 
   7º. crear_depart(50, 'COMPRAS', 'VALENCIA'); Correcta
   8º. crear_depart('COMPRAS', 50, 'VALENCIA'); 
   9º. crear_depart('VALENCIA', ‘COMPRAS’); 
   10º. crear_depart('VALENCIA', 50);
*/


--6) Desarrollar una función que devuelva el número de años completos que hay entre dos fechas que se pasan como argumentos
create FUNCTION totalYear(fechaInicio date, fechaFin date) RETURN number IS
        years NUMBER:=0;
    BEGIN
	years:=FLOOR(MONTHS_BETWEEN(fechaInicio, fechaFin)/12);
    RETURN years;
    END;
/

select TOTALYEAR('15-05-2020','15-05-2010') from  dual;


--7) Escribir una función que, haciendo uso de la función anterior devuelva los trienios que 
--hay entre dos fechas. (Un trienio son tres años completos).
create or replace procedure totalTrienios(fechaInicio date, fechaFin date) is
trienios number;
    begin
        trienios:=(TOTALYEAR(fechaInicio,fechaFin))/3;
        DBMS_OUTPUT.PUT_LINE(trienios);
    end;
/


--8) Codificar un procedimiento que reciba una lista de hasta 5 números y visualice su suma.
create or replace procedure sumaNumeros(num1 number, num2 number, num3 number, num4 number, num5 number) is
begin
    DBMS_OUTPUT.PUT_LINE(num1+num2+num3+num4+num5);
end;

call SUMANUMEROS(1,2,3,4,5);



--9) Escribir una función que devuelva solamente caracteres alfabéticos sustituyendo 
--cualquier otro carácter por blancos a partir de una cadena que se pasará en la llamada
create or replace function soloLetras(cadena varchar2) return varchar2 as
        i number:=0;
        j number:=0;
        nuevaCadena varchar2(99):='';
        alfabeto varchar2(50):='abcdefghijklmnñopqrstuvwxyz';
begin
    loop
        exit when i>length(cadena);
        loop
            exit when j>length(alfabeto);
            if substr(cadena, i, 1)= substr(alfabeto, j, 1) then
                nuevaCadena:=concat(nuevaCadena, substr(cadena,i, 1));
            end if;
            j:=j+1;
        end loop;
        if length(nuevaCadena)<=i then
                nuevaCadena:=concat(nuevaCadena, ' ');
            end if;
        i:=i+1;
        j:=0;
    end loop;
    return nuevaCadena;
end;




--10) Implementar un procedimiento que reciba un importe y visualice el desglose del cambio en
 --unidades monetarias de 1, 5, 10, 25, 50, 100, 200, 500, 1000, 2000, 5000unidades monetarias. 
 --en orden inverso al que aparecen aquí enumeradas.

 CREATE OR REPLACE PROCEDURE desglose_cambio( importe NUMBER) AS
    cambio number := importe;
    moneda number;
    v_uni_moneda number;
        BEGIN
            DBMS_OUTPUT.PUT_LINE('DESGLOSE DE: ' || importe ||' euros');
            WHILE cambio > 0 LOOP
                IF cambio >= 5000 THEN
                    moneda := 5000;
                ELSIF cambio >= 2000 THEN
                    moneda := 2000;
                ELSIF cambio >= 1000 THEN
                         moneda := 1000;
                ELSIF cambio >= 500 THEN
                    moneda := 500;
                ELSIF cambio >= 200 THEN
                    moneda := 200;
                ELSIF cambio >= 100 THEN
                    moneda := 100;
                ELSIF cambio >= 50 THEN
                    moneda := 50;
                ELSIF cambio >= 25 THEN
                    moneda := 25;
                ELSIF cambio >= 10 THEN
                    moneda := 10;
                ELSIF cambio >= 5 THEN
                    moneda := 5;
                ELSE
                    moneda := 1;
                END IF;
                v_uni_moneda := TRUNC(cambio / moneda);
                DBMS_OUTPUT.PUT_LINE(v_uni_moneda ||' Unidades de: ' || moneda || ' Euros. ');
                cambio := MOD(cambio, moneda);
            END LOOP;
        END desglose_cambio;


call desglose_cambio(7000);

--11) Codificar un procedimiento que permita borrar un empleado cuyo número se pasará en la llamada.
insert into EMPLEADOS values (5, 'Matute');
insert into EMPLEADOS values (2, 'Torrente');
insert into EMPLEADOS values (3, 'Chicote');
insert into EMPLEADOS values (4, 'La Veneno');

commit;

create procedure borrar_empleado(numero1 number) as
    begin
        delete from EMPLEADOS where NUMERO =numero1;
        commit;
    end;
/

call borrar_empleado(2);


--12) Escribir un procedimiento que modifique la localidad de un departamento. El procedimiento recibirá como parámetros
-- el número del departamento y la localidad nueva.
CREATE OR REPLACE PROCEDURE MODIFICAR_CIUDAD(DNI1 VARCHAR2,CIUDAD1 VARCHAR2) AS 
    BEGIN
        UPDATE PERSONA SET CIUDAD = CIUDAD1
        WHERE DNI = DNI1;
    END;

CALL MODIFICAR_CIUDAD('29497784P', 'Sevilla');


--13) Visualizar todos los procedimientos y funciones del usuario almacenados en la base de datos y su situación (valid o invalid)
SELECT OBJECT_NAME, OBJECT_TYPE, STATUS
FROM USER_OBJECTS
WHERE OBJECT_TYPE IN ('PROCEDURE','FUNCTION');
