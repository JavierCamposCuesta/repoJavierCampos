
Boletín Introducción a Procedimientos y Funciones
1.Crea un procedimiento llamado ESCRIBE para mostrar por pantalla elmensaje HOLA MUNDO.

CREATE OR REPLACE PROCEDURE ESCRIBE IS
BEGIN
	 DBMS_OUTPUT.PUT_LINE ('Hola Mundo');
END;
/

CALL ESCRIBE();

2.Crea un procedimiento llamado ESCRIBE_MENSAJE que tenga unparámetro de tipo VARCHAR2 que recibe un texto y lo muestre 
por pantalla. La forma del procedimiento ser. la siguiente:ESCRIBE_MENSAJE (mensaje VARCHAR2)

CREATE OR REPLACE PROCEDURE ESCRIBE_MENSAJE( MENSAJE VARCHAR2) IS
BEGIN
	 DBMS_OUTPUT.PUT_LINE (MENSAJE);
END;
/
CALL ESCRIBE_MENSAJE('hoLA QUE ASE')

3.Crea un procedimiento llamado SERIE que muestre por pantalla una serie denúmeros  desde  un  mínimo  hasta  un  
máximo  con  un  determinado  paso.  La forma delprocedimiento ser. la siguiente:SERIE (minimo NUMBER, maximo NUMBER, 
paso NUMBER)

CREATE OR REPLACE PROCEDURE SERIE(MINIMO NUMBER, MAXIMO NUMBER, PASO NUMBER) IS
    i number :=MINIMO;
BEGIN
	 LOOP
        EXIT WHEN i > MAXIMO;
	    DBMS_OUTPUT.PUT_LINE(i);
	    i:=i+PASO;
     end loop;
    END;
/
CALL SERIE(0, 10, 1) 

4.Crea una función AZAR que reciba dos parámetros y genere un número alazar  entre  un  mínimo  y  máximoindicado.  
La  forma  de  la  función  serála siguiente:AZAR (minimo NUMBER, maximo NUMBER) RETURN NUMBER
create FUNCTION AZAR(MINIMO NUMBER, MAXIMO NUMBER) RETURN NUMBER IS
    i number :=MINIMO;
BEGIN
	 RETURN MOD(ABS(DBMS_RANDOM.RANDOM),((MAXIMO-MINIMO)+1))+MINIMO;
END;
/

SELECT AZAR(1, 50) FROM DUAL;


5.Crea una función NOTA que reciba un parámetro que seráuna notanumérica entre 0 y 10 y devuelva una cadena de 
textocon la calificación(Suficiente, Bien, Notable, ...). La forma de la función serála siguiente:
NOTA(nota NUMBER) RETURN VARCHAR2
create OR REPLACE FUNCTION NOTA(nota NUMBER) RETURN varchar2 IS
   RESULTADO VARCHAR2(30);
BEGIN
	 CASE nota
	 WHEN 10 THEN RESULTADO:='Sobresaliente';
	 WHEN 9  THEN RESULTADO:='Sobresaliente';
	 WHEN 8  THEN RESULTADO:='Notable';
	 WHEN 7  THEN RESULTADO:='Notable';
	 WHEN 6  THEN RESULTADO:='Bien';
	 WHEN 5  THEN RESULTADO:='Bien';
	 WHEN 4  THEN RESULTADO:='Insuficiente';
	 WHEN 3  THEN RESULTADO:='Insuficiente';
	 WHEN 2  THEN RESULTADO:='Insuficiente';
	 WHEN 1  THEN RESULTADO:='Insuficiente';
	 WHEN 0  THEN RESULTADO:='Insuficiente';
	 ELSE RESULTADO:='Nota no válida';
	 END CASE;

	 return RESULTADO;
END;
/

select NOTA(6) from dual
select NOTA(11) from dual
