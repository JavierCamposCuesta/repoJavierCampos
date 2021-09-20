-- Previamente deberemos crear una tabla AUDITORIA_EMPLEADOS para registrar los
-- eventos a auditar que ocurran sobre la tabla EMPLEADOS.
create table auditoria_empleados(
    descripcion varchar2(200)
);

-- También insertaremos en la tabla DEPARTAMENTOS uno llamado TEMP donde serán
-- movidos los empleados cuyo departamento desaparezca
INSERT INTO DEPARTAMENTOS VALUES (0, 10, 260, 'F', 10, 100, 'TEMP');

-- 7.1. Crea un trigger que, cada vez que se inserte o elimine un empleado, registre
-- una entrada en la tabla AUDITORIA_EMPLEADOS con la fecha del suceso,
-- número y nombre de empleado, así como el tipo de operación realizada
-- (INSERCIÓN o ELIMINACIÓN).
create or replace trigger insertarEmpl after INSERT or delete on EMPLEADOS for each row
    begin

        if inserting then
         INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :NEW.numem || ', ' || :NEW.NOMEM || ', ' || 'INSERCIÓN'));
         else
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.numem || ', ' || :OLD.NOMEM || ', ' || 'ELIMINACION'));
        end if;

    end;

DELETE EMPLEADOS WHERE NUMEM=110;
INSERT INTO EMPLEADOS VALUES(110,350,'11/10/1970','02/15/1985',1800,NULL,3,'CESAR',121);
COMMIT;


-- 7.2. Crea un trigger que, cada vez que se modi(quen datos de un empleado,
-- registre una entrada en la tabla AUDITORIA_EMPLEADOS con la fecha del
-- suceso, valor antiguo y valor nuevo de cada campo, así como el tipo de operación
-- realizada (en este caso MODIFICACIÓN).
create or replace trigger insertarEmpl after update on EMPLEADOS for each row
    begin
       if updating ('NUMEM') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.numem || ', ' || :NEW.NUMEM || ', ' || 'MODIFICACION'));
         end if;
        IF UPDATING ('EXTEL') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.EXTEL || ', ' || :NEW.EXTEL || ', ' || 'MODIFICACION'));
        end if;
        IF UPDATING ('FECNA') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.FECNA || ', ' || :NEW.FECNA || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('FECIN') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.FECIN || ', ' || :NEW.FECIN || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('SALAR') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.SALAR || ', ' || :NEW.SALAR || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('COMIS') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.COMIS || ', ' || :NEW.COMIS || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('NUMHI') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.NUMHI || ', ' || :NEW.NUMHI || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('NOMEM') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.NOMEM || ', ' || :NEW.NOMEM || ', ' || 'MODIFICACION'));
        end if;
       IF UPDATING ('NUMDE') THEN
            INSERT INTO AUDITORIA_EMPLEADOS VALUES((sysdate || ', ' || :OLD.NUMDE || ', ' || :NEW.NUMDE || ', ' || 'MODIFICACION'));
        end if;

    end;


UPDATE EMPLEADOS SET NOMEM='PAQUETON' WHERE NUMEM=110;
COMMIT;


-- 7.3. Crea un trigger para que registre en la tabla AUDITORIA_EMPLEADOS las
-- subidas de salarios superiores al 5%. 
create or replace trigger subidaSalario after UPDATE on EMPLEADOS for each row
    begin

       if updating ('salar') then
           if(:new.salar>:old.salar*1.05) then
               INSERT INTO AUDITORIA_EMPLEADOS VALUES(('Subida de salario superior al 5% ' || 'Viejo salario ' || :old.salar || ' Nuevo salario ' ||:new.salar));
           end if;
       end if;



    end;



