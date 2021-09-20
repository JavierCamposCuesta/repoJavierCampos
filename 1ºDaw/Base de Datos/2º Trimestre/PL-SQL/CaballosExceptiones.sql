
/*Ejercicio1: (2puntos) Realizar una función cuyo nombre sea
TUNOMBREAPELLIDONUMERO que reciba dos parámetros, un número y un
parámetro de entrada salida. La función debe devolver el valor -1 y en el
parámetro de entrada salida un 0 si el número que recibe como primer
parámetro no es entero y positivo. Si el primer parámetro es entero y positivo
devolver en el parámetro de entrada y salida la suma de los n primeros números,
es decir si el primer parámetro es un 5 deberá devolver en el parámetro de
entrada salida el resultado de sumar 1+2+3+4+5. En este caso la función
devolverá un 1. (1,5 punto)
Realizar un bloque anónimo para probar está función en la que se llamará con
un número negativo, un número no entero, y por último con un número entero
y positivo. En este bloque se debe escribir el resultado de la función o el mensaje
de error correspondiente. (0.5 puntos)*/
CREATE OR REPLACE FUNCTION DUMMY.RAFAELCUBEROSNUMERO(numero NUMBER, param NUMBER) RETURN NUMBER IS

suma NUMBER ;
resultado NUMBER;
parametro NUMBER := param;
BEGIN
	suma:=0;

--Primer Caso devuelve -1 y entradaSalida es 0;
IF (numero!=TRUNC(numero)) AND numero>0 THEN --Or numero<0 depende como se entienda el enunciado
	resultado:=-1;
	parametro:=0;

--Segundo caso devuelde entradaSalida=suma n numeros, return=1
ELSIF (numero=TRUNC(numero)) AND numero>0 THEN
	FOR i IN 1..numero LOOP
		suma:=suma+i;
		parametro:=suma;
	END LOOP;
	resultado:=1;
END IF;
RETURN resultado;
END RAFAELCUBEROSNUMERO;



/*Ejercicio 2: (1,5 puntos) Realiza un procedure para insertar una apuesta que se
llame TUNOMBREAPELLIDOINSERTARAPUESTA. El procedure recibirá el código
del caballo, el código de la carrera, el dni del cliente y el importe. El procedure
deberá mostrar los siguientes posibles errores:
o Si el caballo no existe lanzar la excepción -20001 con el mensaje
“Caballo imaginario”
o Si la carrera no existe lanzar la excepción -20002 con el mensaje
“Caballo imaginario”
o Si el cliente no existe lanzar la excepción -20003 con el mensaje “Cliente
imaginario”
o Si el caballo no participa en la carrera lanzar la excepción -20004 con el
mensaje “Caballo existente, pero descansando”
o Si el importe apostado supera el límite fijado para dicha carrera lanzar la
excepción -20005 con el mensaje, “Jugar es malo”.
El tantoporuno será de uno siempre. Si se comprueba uno de los errores no es
necesario seguir mirando los demás.*/


CREATE OR REPLACE PROCEDURE javierCamposInsertarApuesta(codCab varchar2, pcodCarrera varchar2, pdniCliente varchar2, pimporte NUMBER) IS

aux NUMBER;
V_apuesta_Max NUMBER;
BEGIN

SELECT COUNT(*) INTO aux FROM CABALLOS c WHERE c.CODCABALLO=codCab;
IF aux= 0 THEN

RAISE_APPLICATION_ERROR(-20001,'Caballo Imaginario');
END IF;
SELECT COUNT(*) INTO aux FROM CARRERAS c WHERE c.CODCARRERA=pcodCarrera;
IF aux = 0 THEN

RAISE_APPLICATION_ERROR(-20002,'Carrera Imaginario');
END IF;
SELECT COUNT(*) INTO aux FROM CLIENTES c WHERE c.DNI=pdniCliente;
IF aux = 0 THEN

    RAISE_APPLICATION_ERROR(-20003,'Cliente Imaginario');
END IF;
SELECT COUNT(*) INTO aux FROM CABALLOS c, PARTICIPACIONES p, CARRERAS c2 WHERE c.CODCABALLO=codCab AND c.CODCABALLO=p.CODCABALLO AND p.CODCARRERA=c2.CODCARRERA;
IF aux != 0 THEN

RAISE_APPLICATION_ERROR(-20004,'Caballo Descansando');
END IF;

SELECT c.APUESTALIMITE INTO v_apuesta_Max FROM CARRERAS c WHERE c.CODCARRERA=codCarrera;
IF pimporte>V_apuesta_Max THEN

     RAISE_APPLICATION_ERROR(-20005,'Jugar es Malo');
END IF;
INSERT INTO APUESTAS VALUES(pdniCliente, codCab, pcodCarrera, pimporte, 1);

END;


/*Ejercicio 3: (3 puntos)+(1punto) Realiza un procedimiento que reciba una fecha
inicial y una fecha final y muestre todas las apuestas que han resultado ganadoras
entre esas dos fechas. Las apuestas deben mostrarse con el siguiente formato:
INFORME DE APUESTAS GANADORAS ENTRE dd/mm/yy y dd/mm/yy
Carrera: Nombre de la carrera1
Fecha: dd/mm/yyyy
Cliente1 ImporteApostado1 Ganancias1
....
Clienten ImporteApostadon Gananciasn
Total ganancias de los apostantes en la carrera: nnnnn
Total ganancias Hipódromo en la carrera: nnnnnn
Carrera: Nombre de la carrera2
Fecha: dd/mm/yyyy
Cliente1 ImporteApostado1 Ganancias1
....
Clienten ImporteApostadon Gananciasn
Total ganancias de los apostantes en la carrera: nnnnn
Total ganancias Hipódromo en la carrera: nnnnnn
..........
Total Ganancias Hipódromo: nnnnnn
Para las ganancias del hipódromo se calculan sumando los importes apostados y
restando el premio al ganador de la carrera y los pagos realizados a los
apostantes ganadores. Para ello crea una función que reciba el código de la
carrera y devuelva las ganancias del hipódromo con esta carrera (1 punto).
Si la fecha inicial es mayor que la final, debe mostrarse un mensaje de error y
salir.*/
create or replace procedure FechaEntre (fechaInic date, fechaFin date) is
    cursor datos is
    select ca.NOMBRECARRERA, ca.FECHAHORA, apu.DNICLIENTE, sum(apu.IMPORTE) sumganancias, apu.TANTOPORUNO
    from CARRERAS ca, APUESTAS apu where ca.CODCARRERA=apu.CODCARRERA and ca.FECHAHORA<fechaFin
                                     and ca.FECHAHORA>fechaInic group by ca.NOMBRECARRERA, ca.FECHAHORA, apu.DNICLIENTE, apu.TANTOPORUNO;
    v_ganancias number;

    begin
        DBMS_OUTPUT.PUT_LINE('INFORME DE APUESTAS GANADORAS ENTRE ' || fechaInic || ' y ' || fechaFin);
            for dt in datos loop
                    v_ganancias:= dt.sumganancias*(dt.TANTOPORUNO-1);
                    DBMS_OUTPUT.PUT_LINE('Carrera: ' || dt.NOMBRECARRERA);
                    DBMS_OUTPUT.PUT_LINE('Fecha: ' || dt.FECHAHORA);
                    DBMS_OUTPUT.PUT_LINE('Cliente: ' || dt.DNICLIENTE);
                    DBMS_OUTPUT.PUT_LINE('Total de las ganancias de los apostantes en la carrera: '
                                        || v_ganancias);
                    v_ganancias:= v_ganancias - dt.sumganancias;
                    DBMS_OUTPUT.PUT_LINE('Total de las ganancias Hipódromo en la carrera: '
                                        || v_ganancias);
             end loop;

end FechaEntre;
    /

call FechaEntre(to_date('21-10-2008', 'dd-mm-yyyy'), to_date('07-12-2009', 'dd-mm-yyyy'));


/*Ejercicio 4 (2,5 puntos):
Para la realización de este ejercicio es necesario que ejecutes la siguiente
instrucción para crear la tabla AUDITORIA_APUESTAS.
CREATE TABLE AUDITORIA_APUESTAS (descripcion VARCHAR2(200));
Crea un trigger que, cada vez que se modifiquen o se borren datos de la tabla
APUESTAS, registre una entrada en la tabla AUDITORIA_APUESTAS. La
información que deberá guardar será la fecha del suceso, valor antiguo y valor
nuevo de cada campo modificado, así como el tipo de operación realizada (en el
caso de actualización de datos deberá indicarse la palabra MODIFICACIÓN, en el
caso de borrado de datos deberá indicarse BORRADO).*/
--Crear tabla auditoria_Apuestas
create or replace trigger AUDITORIA_APUESTAS after update OR DELETE on APUESTAS for each row
    begin
       if updating ('DNICLIENTE') THEN
            INSERT INTO AUDITORIA_APUESTAS VALUES((sysdate || ', DNICLIENTE: ' || :OLD.DNICLIENTE || ', ' || :NEW.DNICLIENTE || ', ' || 'MODIFICACION'));
         end if;
        IF UPDATING ('CODCABALLO') THEN
            INSERT INTO AUDITORIA_APUESTAS VALUES((sysdate || ', CODCABALLO: ' || :OLD.CODCABALLO || ', ' || :NEW.CODCABALLO || ', ' || 'MODIFICACION'));
        end if;
        IF UPDATING ('CODCARRERA') THEN
            INSERT INTO AUDITORIA_APUESTAS VALUES((sysdate || ', CODCARRERA: ' || :OLD.CODCARRERA || ', ' || :NEW.CODCARRERA || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('IMPORTE') THEN
            INSERT INTO AUDITORIA_APUESTAS VALUES((sysdate || ', IMPORTE: ' || :OLD.IMPORTE || ', ' || :NEW.IMPORTE || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('TANTOPORUNO') THEN
            INSERT INTO AUDITORIA_APUESTAS VALUES((sysdate || ', TANTOPORUNO: ' || :OLD.TANTOPORUNO || ', ' || :NEW.TANTOPORUNO || ', ' || 'MODIFICACION'));
        end if;
       IF DELETING  THEN
          INSERT INTO AUDITORIA_APUESTAS VALUES((sysdate || ', BORRADO: ' ));
          END IF;

    end;

   UPDATE APUESTAS SET IMPORTE  = 1200 WHERE IMPORTE = 350;
COMMIT;





/*Añade una columna a la tabla Caballos para almacenar el número de carreras
ganadas por cada uno de ellos. Realiza un procedimiento para llenarla con los
valores adecuados (2 puntos)*/




/*3. (2 puntos) Realizar un procedimiento que reciba un número entero y positivo (si
no es así mostrar un mensaje de error y salir), y dos letras distintas (si no son
distintas mostrar mensaje de error y salir) y escriba una tabla en la que
aparecerán n veces la primera letra, luego otra fila con n veces la segunda letra,
otra fila con n veces la primera fila, y así hasta completar n filas.

Por ejemplo, si llamo a la función con el número 6 y la letra A y B deberá aparecer
algo como esto
AAAAAA
BBBBBB
AAAAAA
BBBBBB
AAAAAA
BBBBBBB

No olvides que “hay que cuidar a Oracle”

Si la llamo con el número 5 y la letra A y B deberá aparecer algo como esto
AAAAA
BBBBB
AAAAA
BBBBBB
AAAAA*/

create or replace procedure tablaLetras(numero number, letras varchar2) is
    aux varchar2(500);
    auxNumero number:=1;
    begin
        if numero<0 or (mod(numero, 1) <>0 )then
            RAISE_APPLICATION_ERROR(-20005,'El numero no es positivo o no es entero');
        end if;
        if substr(letras, 1,1) = substr(letras, 2,1) then
            RAISE_APPLICATION_ERROR(-20005,'Las letras no pueden ser iguales');
        end if;

        for i in 0..numero-1
        loop
            for j in 0..numero-1
            loop
                if auxNumero=1 then
                aux := concat(aux,substr(letras, 1,1));
                else
                aux := concat(aux,substr(letras, 2,1));
                    end if;
            end loop;

            DBMS_OUTPUT.PUT_LINE(aux);
            aux:=null;

           if auxNumero =1 then
               auxNumero := 2;
            else
               auxNumero :=1;
           end if;
            end loop;
        DBMS_OUTPUT.PUT_LINE(aux);


    end;

    call tablaLetras(5,'aO');




/*4. (2 puntos) Realiza un procedimiento para insertar una apuesta. El procedimiento
recibirá el nombre del caballo, el nombre de la carrera, el nombre y nacionalidad
del cliente y el importe. El procedimiento deberá mostrar los siguientes posibles
errores:
• El caballo, la carrera o el cliente no existe
• Si el importe apostado supera el límite fijado para dicha carrera mostrar el
correspondiente mensaje de error.
El tantoporuno será de uno siempre. (2 puntos)*/
--Crear tabla auditoria_Apuestas
