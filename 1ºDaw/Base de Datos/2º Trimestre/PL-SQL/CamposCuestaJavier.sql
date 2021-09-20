-- Escribir  un  procedimiento  que  modifique  la  localidad  de  un  departamento.  El procedimiento recibirá como parámetros el número del departamento 
-- y la localidad nueva
CREATE TABLE DEPARTAMENTO(
    COD_DEPARTAMENTO NUMBER PRIMARY KEY ,
    LOCALIDAD VARCHAR2(50)
)

INSERT INTO DEPARTAMENTO VALUES (1, 'BURGUILLOS');
INSERT INTO DEPARTAMENTO VALUES (2, 'BRENES');

-- Me creo esta tabla y le añado esos valores para comprobar el procedimiento

CREATE OR REPLACE PROCEDURE MODIFICAR_LOCALIDAD(COD_DEPARTAMENTO1 NUMBER, localidadNueva VARCHAR2) AS 
    BEGIN
        UPDATE DEPARTAMENTO SET LOCALIDAD = localidadNueva
        WHERE COD_DEPARTAMENTO = COD_DEPARTAMENTO1;
    END;

    CALL MODIFICAR_LOCALIDAD(1, 'SEVILLA');


-- Codificar unafunciónque reciba una lista de hasta 5 númerosy que devuelvauna de estas opciones dependiendo de unvalor que se introduzca por teclado:
-- a.-Que visualice su suma. 
-- b.-Que visualice la resta del mayor menos el menor.
-- c.-Quevisualicelamultiplicación del primero con el tercero y el quinto.
-- d. -Que visualice la división del segundo con el cuarto, controlando que no se puede dividir por 0.




-- Para realizar esta funcion, la cual recibe 5 numero y posteriormente pide una opcion por teclado para realizar una operacion u otra, el principal problema es
-- la opcion a, ya que nos pide que restemos el minimo al máximo. Para hacer esto la forma que se me ha ocurrido es a traves de condicionales buscar el maximo y 
-- posteriormente el minimo. El buscar el maximo y minimo lo hago dentro del caso que la opcion a, ya que si fuese otra opcion la que se introduce no sería ncesario
-- realizar esta busqueda. Los demas métodos no tienen mucha complicacion, ya que es simplemente operar con algunos de los parametros que hemos introducido

CREATE or REPLACE function operaciones(num1 number, num2 number, num3 number, num4 number, num5 number) return number is
opcion char := &opcion;
resultado number;
    mayor number;
    menor number;
    begin

        CASE opcion
     WHEN 'a'  THEN resultado:=num1+num2+num3+num4+num5;
	 WHEN 'b' THEN
	      if num1>num2 and num1 >num3 and num1 > num4 and num1 > num5 then
            mayor:=num1;
        elsif num2>num1 and num2 >num3 and num2 > num4 and num2 > num5 then
            mayor:=num2;
        elsif num3>num1 and num3 >num2 and num3 > num4 and num3 > num5 then
            mayor:=num3;
        elsif num4>num1 and num4 >num2 and num4 > num3 and num4 > num5 then
            mayor:=num4;
        elsif num5>num1 and num5 >num2 and num5 > num3 and num5 > num4 then
            mayor:=num5;
        elsif num1 = num2 or num1 = num3 or num1 = num4 or num1 = num5 then
            mayor:=num1;
        elsif  num2 = num3 or num2 = num4 or num2 = num5 then
            mayor:=num2;
        elsif  num3 = num4 or num3 = num5 then
            mayor:=num3;
        else
            mayor:=num4;
        end if;

        if num1<num2 and num1 <num3 and num1 < num4 and num1 < num5 then
            menor:=num1;
        elsif num2<num1 and num2 <num3 and num2 < num4 and num2 < num5 then
            menor:=num2;
        elsif num3<num1 and num3 <num2 and num3 < num4 and num3 < num5 then
            menor:=num3;
        elsif num4<num1 and num4 <num2 and num4 < num3 and num4 < num5 then
            menor:=num4;
        elsif num5<num1 and num5 <num2 and num5 < num3 and num5 < num4 then
            menor:=num5;
        elsif num1 = num2 or num1 = num3 or num1 = num4 or num1 = num5 then
            menor:=num1;
        elsif  num2 = num3 or num2 = num4 or num2 = num5 then
            menor:=num2;
        elsif  num3 = num4 or num3 = num5 then
            menor:=num3;
        else
            menor:=num4;
        end if;
	      resultado:=mayor-menor;
    WHEN 'c'  THEN resultado:=num1*num3*num5;
    WHEN 'd'  THEN
        if num4 <> 0 then
            resultado:=NUM2/NUM4;
        end if;

	 END CASE;
        return resultado;

    end;

select OPERACIONES(4, 5, 6, 7, 1) from dual;



--Ejercicio 3
-- Escribir  una  función  que  devuelva  solamente  caracteres numéricos sustituyendo cualquier otro carácter por ‘X’a partir de una cadena alfanumérica
--  que se pasará en la llamada.



-- La forma mas sencilla de hacer esta funcion sería a través del codigo ascii, el cual es una tabla donde tenemos todo los caracteres que existen con
-- un digito asignado, para este caso los valores entre del 0 al 9 estan comprendidos entre los codigos ascii 48 y 57, es por esto por lo que si el codigo del
-- caracter que analicemos no está comprendido entre esos valores significará que no será un valor numérico, y por lo tanto pondremos en su lugar una 'X',
-- si fuese cierto que es un valor numerico lo añadiriamos tambien, ya que vamos guardando el caracter en otra variable a la que llamo caracter.
-- Esta sería la forma más optima que se me ocurre


CREATE OR REPLACE FUNCTION soloNumeros1(cadena VARCHAR2) RETURN VARCHAR2 AS
nuevaCadena VARCHAR2(100);
car CHARACTER;
BEGIN
FOR i IN 1..LENGTH(cadena) LOOP
caracter:=SUBSTR(cadena,i,1);
IF (ASCII(car) NOT BETWEEN 48 AND 57) THEN
caracter :='X';
END IF;
nuevaCadena := nuevaCadena || caracter;
END LOOP;
RETURN nuevaCadena;
END;

select SOLONUMEROS1('a123dsf       sdf') from dual;


-- Otra forma que tengo para hacerlo es sin utilizar el codigo ascii, esta funcion no es tan exacta como la anterior, pero aún así deveria funcionar,
-- en cuanto a optimización creo que la forma anterior con el codigo ascii es mejor

create function soloNumeros(cadena varchar2) return varchar2 as
        i number:=0;
        j number:=0;
        nuevaCadena varchar2(99):='';
        numeros varchar2(50):='1234567890';
begin
    loop
        exit when i>length(cadena);
        loop
            exit when j>length(numeros);
            if substr(cadena, i, 1)= substr(numeros, j, 1) then
                nuevaCadena:=concat(nuevaCadena, substr(cadena,j, 1));
            end if;
            j:=j+1;
        end loop;
        if length(nuevaCadena)<=i then
                nuevaCadena:=concat(nuevaCadena, 'X');
            end if;
        i:=i+1;
        j:=0;
    end loop;
    return nuevaCadena;
end;
/

select SOLONUMEROS('a123dsfsdf') from dual;

-- Ejercicio 4
-- Desarrollarun procedimiento que reciba una cantidad monetariay realice eldesglose del  cambio 
--  en  unidades  monetarias  de  1,  5,  10,  25,  50,  100,  200,  500 unidades monetarias. en orden inverso al que aparecen enunciadas.
--  Visualizar el resultado


-- Mi procedimiento lo que realiza basicamente es que obtiene un importe y comprueba de mayor a menor si el importe es mayor o igual a los dintintos tipos de cambios 
-- que podemos dar. Si fuese cierto realizaria la division truncada del cambio entre la moneda correspondiente, esto nos dará un valor positivo que es el numero
-- de veces que va a estar esa moneda en el cambio, en cambio el resto, el cual ya es menor que esta moneda sería el restante del cambio que tenemos que dar, al cual 
-- le iremos haciendo el mismo procedimiento hasta que el cambio sea igual a 0

 CREATE OR REPLACE PROCEDURE darCambio( importe NUMBER) AS
    cambio number := importe;
    moneda number;
    v_uni_moneda number;
        BEGIN
            DBMS_OUTPUT.PUT_LINE('Dar el cambio de: ' || importe ||' euros');
            WHILE cambio > 0 LOOP
                
                IF cambio >= 500 THEN
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
                DBMS_OUTPUT.PUT_LINE(v_uni_moneda ||' Unidades de: ' || moneda || ' euros. ');
                cambio := MOD(cambio, moneda);
            END LOOP;
        END;



call DARCAMBIO(7234);