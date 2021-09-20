-- 1. Desarrolla el paquete ARITMETICA cuyo código fuente viene en este tema.
-- Crea un archivo para la especi(cación y otro para el cuerpo. Realiza varias pruebas
-- para comprobar que las llamadas a funciones y procedimiento funcionan
-- correctamente.
CREATE OR REPLACE
PACKAGE aritmetica IS
  version NUMBER := 1.0;

  PROCEDURE mostrar_info;
  FUNCTION suma       (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION resta      (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION multiplica (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION divide     (a NUMBER, b NUMBER) RETURN NUMBER;
END aritmetica;
/

CREATE OR REPLACE
PACKAGE BODY aritmetica IS

  PROCEDURE mostrar_info IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE
      ('Paquete de operaciones aritméticas. Versión ' || version);
  END mostrar_info;

  FUNCTION suma       (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a+b);
  END suma;

  FUNCTION resta      (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a-b);
  END resta;

  FUNCTION multiplica (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a*b);
  END multiplica;

  FUNCTION divide     (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a/b);
  END divide;

END aritmetica;
/


--Hago las siguientes pruebas
BEGIN
  ARITMETICA.MOSTRAR_INFO;
END;
/

SELECT ARITMETICA.SUMA(4,3) FROM DUAL;
SELECT ARITMETICA.RESTA(4,3) FROM DUAL;
SELECT ARITMETICA.MULTIPLICA(4,3) FROM DUAL;
SELECT ARITMETICA.DIVIDE(4,3) FROM DUAL;



-- 2. Al paquete anterior añade una función llamada RESTO que reciba dos
-- parámetros, el dividendo y el divisor, y devuelva el resto de la división.
CREATE OR REPLACE
PACKAGE aritmetica IS
  version NUMBER := 1.0;

  PROCEDURE mostrar_info;
  FUNCTION suma       (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION resta      (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION multiplica (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION divide     (a NUMBER, b NUMBER) RETURN NUMBER;
    FUNCTION resto     (dividendo NUMBER, divisor NUMBER) RETURN NUMBER;


END aritmetica;
/




CREATE OR REPLACE
PACKAGE BODY aritmetica IS

  PROCEDURE mostrar_info IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE
      ('Paquete de operaciones aritméticas. Versión ' || version);
  END mostrar_info;

  FUNCTION suma       (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a+b);
  END suma;

  FUNCTION resta      (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a-b);
  END resta;

  FUNCTION multiplica (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a*b);
  END multiplica;

  FUNCTION divide     (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a/b);
  END divide;

      FUNCTION resto     (dividendo NUMBER, divisor NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (mod(dividendo, divisor));
  END resto;

END aritmetica;
/
-- 3.  Al paquete anterior añade un procedimiento sin parámetros llamado AYUDA
-- que muestre un mensaje por pantalla de los procedimientos y funciones disponibles
-- en el paquete, su utilidad y forma de uso
CREATE OR REPLACE
PACKAGE aritmetica IS
  version NUMBER := 1.0;

  PROCEDURE mostrar_info;
  FUNCTION suma       (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION resta      (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION multiplica (a NUMBER, b NUMBER) RETURN NUMBER;
  FUNCTION divide     (a NUMBER, b NUMBER) RETURN NUMBER;
    FUNCTION resto     (dividendo NUMBER, divisor NUMBER) RETURN NUMBER;
procedure AYUDA;


END aritmetica;
/


CREATE OR REPLACE
PACKAGE BODY aritmetica IS

  PROCEDURE mostrar_info IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE
      ('Paquete de operaciones aritméticas. Versión ' || version);
  END mostrar_info;

  FUNCTION suma       (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a+b);
  END suma;

  FUNCTION resta      (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a-b);
  END resta;

  FUNCTION multiplica (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a*b);
  END multiplica;

  FUNCTION divide     (a NUMBER, b NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (a/b);
  END divide;

      FUNCTION resto     (dividendo NUMBER, divisor NUMBER) RETURN NUMBER IS
  BEGIN
    RETURN (mod(dividendo, divisor));
  END resto;

 PROCEDURE AYUDA IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE('Procedure mostrar_info: Muestra un mensaje con la version introducida');
    DBMS_OUTPUT.PUT_LINE('Funtion suma: Recibe dos numeros y devuelve la suma entre ellos');
    DBMS_OUTPUT.PUT_LINE('Funtion resta: Recibe dos numeros y devuelve la resta entre ellos');
    DBMS_OUTPUT.PUT_LINE('Funtion multiplicacion: Recibe dos numeros y devuelve la multiplicacion entre ellos');
    DBMS_OUTPUT.PUT_LINE('Funtion division: Recibe dos numeros y devuelve la division entre ellos');
    DBMS_OUTPUT.PUT_LINE('Funtion resto: Recibe dos numeros y devuelve el resto de la operación');
  END AYUDA;


END aritmetica;
/
4.  Desarrolla el paquete GESTION. En un principio tendremos los
procedimientos para gestionar los departamentos. Dado el archivo de
especi(cación mostrado más abajo crea el archivo para el cuerpo. Realiza varias
pruebas para comprobar que las llamadas a funciones y procedimientos funcionan
correctamente.

-- PAQUETE GESTION – Especificación
-- PACKAGE_GESTION.SQL


--Creamos la tabla para este ejercicio
create table DepartamentoEj3 (
    nombre varchar2(60),
    presupuesto number(6),
    id number(3) primary key
);

--Creamos la secuencia para darsela al id
create sequence idDepartamento
start with 0
increment by 1
minvalue 0
maxvalue 999;


--Aqui hago el ejercicio
CREATE OR REPLACE
PACKAGE GESTION AS
 PROCEDURE CREAR_DEP (NOMBRE VARCHAR, PRESUPUESTO NUMBER);
 FUNCTION NUM_DEP (NOMBRE1 VARCHAR2) RETURN NUMBER;
 PROCEDURE MOSTRAR_DEP (numero1 NUMBER);
 PROCEDURE BORRAR_DEP (numero number);
 PROCEDURE MODIFICAR_DEP (numero number, presupuestoDepartamento number);
END;

    CREATE OR REPLACE PACKAGE BODY GESTION IS
PROCEDURE CREAR_DEP (NOMBRE VARCHAR, PRESUPUESTO NUMBER) is
    BEGIN
        INSERT INTO DEPARTAMENTOEJ3 VALUES (NOMBRE, PRESUPUESTO, idDepartamento.nextval);
    end;

FUNCTION NUM_DEP (NOMBRE1 VARCHAR2) RETURN NUMBER IS
    id number;
BEGIN
    SELECT DepartamentoEj3.id INTO id from DEPARTAMENTOEJ3 where NOMBRE= nombre1;

    return id;
end;

procedure MOSTRAR_DEP (numero1 NUMBER)  IS
nombreDepartamento varchar2(100);
    presupuestoDepartamento number;
    idDepartamento number;
BEGIN
    SELECT nombre, presupuesto, id INTO nombreDepartamento, presupuestoDepartamento, idDepartamento from DEPARTAMENTOEJ3 where id= numero1;
    DBMS_OUTPUT.PUT_LINE('El nombre del departamento es: ' || nombreDepartamento);
     DBMS_OUTPUT.PUT_LINE('El presupuesto del departamento es: ' || presupuestoDepartamento);
     DBMS_OUTPUT.PUT_LINE('El id del departamento es: ' || idDepartamento);


end;

procedure BORRAR_DEP( numero number) is
        begin
            delete from DEPARTAMENTOEJ3 where id=numero;
         end;

procedure MODIFICAR_DEP (numero number, presupuestoDepartamento number) is
        begin
            update DEPARTAMENTOEJ3 set presupuesto=presupuestoDepartamento where id=numero;
        end;
end GESTION;