-- Una empresa almacena los datos de sus empleados en una tabla denominada
-- "empleados". En una tabla denominada "controlCambios" guarda los cambios que se
-- realizan en la tabla "empleados", en ella almacena el nombre del usuario que realiza la
-- modificación, la fecha, el valor anterior del campo modificado y el nuevo valor.
-- Eliminamos las tablas:
--  drop table empleados;
--  drop table controlCambios;
-- Creamos las tablas, con las siguientes estructuras:
-- create table empleados(
--  documento char(8) not null,
--  nombre varchar2(30) not null,
--  domicilio varchar2(30),
--  seccion varchar2(20)
-- );
-- create table controlCambios(
--  usuario varchar2(30),
--  fecha date,
--  datoanterior varchar2(30),
--  datonuevo varchar2(30)
-- );
-- Ingresamos algunos registros:
-- insert into empleados values('22222222','Ana Acosta','Bulnes 56','Secretaria');
-- insert into empleados values('23333333','Bernardo Bustos','Bulnes 188','Contaduria');
-- insert into empleados values('24444444','Carlos Caseres','Caseros 364','Sistemas');
-- insert into empleados values('25555555','Diana Duarte','Colon 1234','Sistemas');
-- insert into empleados values('26666666','Diana Duarte','Colon 897','Sistemas');
-- insert into empleados values('27777777','Matilda Morales','Colon 542','Gerencia');




-- 1. Creamos un disparador que se active cuando modificamos algún campo de
-- "empleados" y almacene en "controlCambios" el nombre del usuario que realiza
-- la actualización, la fecha, el dato que se cambia y el nuevo valor.
create or replace trigger actualizarEmpl after update on EMPLEADOS for each row
    begin
       if updating ('DOCUMENTO') THEN
           INSERT INTO CONTROLCAMBIOS VALUES(USER, SYSDATE, :OLD.DOCUMENTO, :NEW.DOCUMENTO);
         end if;
        IF UPDATING ('NOMBRE') THEN
            INSERT INTO CONTROLCAMBIOS VALUES(USER, SYSDATE, :OLD.NOMBRE, :NEW.NOMBRE);
        end if;
        IF UPDATING ('DOMICILIO') THEN
            INSERT INTO CONTROLCAMBIOS VALUES(USER, SYSDATE, :OLD.DOMICILIO, :NEW.DOMICILIO);
        end if;
       IF UPDATING ('SECCION') THEN
            INSERT INTO CONTROLCAMBIOS VALUES(USER, SYSDATE, :OLD.SECCION, :NEW.SECCION);
        end if;

    end;

    UPDATE EMPLEADOS SET NOMBRE='JAVIER' WHERE DOCUMENTO=22222222;
COMMIT;

-- 2. Creamos otro desencadenador que se active cuando ingresamos un nuevo
-- registro en "empleados", debe almacenar en "controlCambios" el nombre del
-- usuario que realiza el ingreso, la fecha, "null" en "datoanterior" (porque se
-- dispara con una inserción) y en "datonuevo" el documento.
create or replace trigger insertarEmpl after INSERT on EMPLEADOS for each row
    begin
       INSERT INTO CONTROLCAMBIOS VALUES(USER, SYSDATE, NULL, :NEW.DOCUMENTO);
    end;

INSERT INTO EMPLEADOS VALUES(69,'CHICOTE', 'BUGUILLOS 24', 'JEFE' );
COMMIT;

-- 3. Creamos un tercer trigger sobre "empleados" que se active cuando eliminamos
-- un registro en "empleados", debe almacenar en "controlCambios" el nombre del
-- usuario que realiza la eliminación, la fecha, el documento en "datoanterior" y
-- "null" en "datonuevo":
create or replace trigger borrarEmpl after DELETE on EMPLEADOS for each row
    begin
       INSERT INTO CONTROLCAMBIOS VALUES(USER, SYSDATE, :OLD.DOCUMENTO, NULL);
    end;

DELETE EMPLEADOS WHERE DOCUMENTO=69;
COMMIT;

-- 4. Los tres triggers están habilitados. Consultamos el diccionario "user_triggers"
-- para corroborarlo:
select * from USER_TRIGGERS where STATUS='ENABLED';

-- 5. Vamos a ingresar un empleado y comprobar que el trigger
-- "tr_ingresar_empleados" se dispara recuperando los registros de
-- "controlCambios".
INSERT INTO EMPLEADOS VALUES(100,'LA VENENO', 'BRENES 24', 'LIMPIEZA' );
COMMIT;

SELECT * FROM CONTROLCAMBIOS;

-- 6. Deshabilitamos el trigger "tr_ingresar_empleados"
ALTER TRIGGER insertarEmpl disable;

-- 7. Consultamos el diccionario "user_triggers" para corroborarlo.
select * from USER_TRIGGERS

-- 8. Vamos a ingresar un empleado y comprobar que el trigger de inserción no se
-- dispara recuperando los registros de "controlCambios".
INSERT INTO EMPLEADOS VALUES(200,'paquito', 'guillena 24', 'reponedor' );
COMMIT;

SELECT * FROM CONTROLCAMBIOS;

-- 9. Vamos a actualizar el domicilio de un empleado y comprobar que el trigger de
-- actualización se dispara recuperando los registros de "controlCambios".

update  EMPLEADOS set DOMICILIO='cordoba' where DOCUMENTO=200;
COMMIT;

SELECT * FROM CONTROLCAMBIOS;

-- 10. Deshabilitamos el trigger "tr_actualizar_empleados".
ALTER TRIGGER actualizarEmpl disable;

-- 11. Consultamos el diccionario "user_triggers" para corroborarlo.
select * from USER_TRIGGERS

-- 12. Los triggers "tr_ingresar_empleados" y "tr_actualizar_empleados" están
-- deshabilitados, "tr_eliminar_empleados" está habilitado.
select * from USER_TRIGGERS

-- 13. Vamos a borrar un empleado de "empleados" y comprobar que el trigger de
-- borrado se disparó recuperando los registros de "controlCambios".
-- 14. Deshabilitamos el trigger "tr_eliminar_empleados".
-- 15. Consultamos el diccionario "user_triggers" para comprobarlo.
-- 16. Los tres trigger establecidos sobre "empleados" están deshabilitados.
-- 17. Eliminamos un empleado de "empleados" y comprobamos que el trigger de
-- borrado no se dispara recuperando los registros de "controlCambios".
-- 18. Habilitamos el trigger "tr_actualizar_empleados".
-- 19. Actualizamos la sección de un empleado y comprobamos que el trigger de
-- actualización se dispara recuperando los registros de "controlCambios".
-- 20. Habilitamos todos los triggers establecidos sobre "empleados"