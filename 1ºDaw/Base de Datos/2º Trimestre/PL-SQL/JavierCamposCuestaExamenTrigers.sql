-- 1.Realizar un paquete que contenga todos los procedimientos y funciones que se piden en este ejercicio
CREATE OR REPLACE
PACKAGE ExamenJavierCampos IS
  

  PROCEDURE listado;
  FUNCTION numeroCarrerasGanadas (nombreEquipo varchar2) RETURN NUMBER;
 
END ExamenJavierCampos;
/




--Despues de hacer los ejercicios
create or replace package body ExamenJavierCampos is
    procedure listado is
    codigoEquipo number;
cursor datos is
select NOMBRE, NACIONALIDAD, NOMBREDIRECTOR, CODEQUIPO from EQUIPOS;

cursor ciclistas is
    select CICLISTAS.NOMBRE, CICLISTAS.FECHANACIMIENTO from CICLISTAS, EQUIPOS where CICLISTAS.CODEQUIPO=EQUIPOS.CODEQUIPO;

    begin
        for equipo in datos loop
            codigoEquipo:=equipo.CODEQUIPO;

            DBMS_OUTPUT.PUT_LINE('Nombre equipo: '||equipo.NOMBRE || ' Nacionalidad: '|| equipo.NACIONALIDAD || ' Nombre director: ' || equipo.NOMBREDIRECTOR);
                for ciclista in ciclistas loop
                    DBMS_OUTPUT.PUT_LINE('Nombre ciclista: ' || ciclista.NOMBRE || ' Fecha nacimiento: ' || ciclista.FECHANACIMIENTO);
                    end loop;
            DBMS_OUTPUT.PUT_LINE(' ');

            end loop;
    end listado;
    
function numeroCarrerasGanadas(nombreEquipo varchar2) return number is
totalCarrerasGanadas number;
    aux number;
    begin
        select count(CODEQUIPO) into aux from EQUIPOS where NOMBRE=nombreEquipo;
        if aux =0 then
            RAISE_APPLICATION_ERROR(-20009, 'El equipo no existe');
        else
        select count(CLASIFICACIONETAPAS.DORSAL) into totalCarrerasGanadas from CLASIFICACIONETAPAS, CICLISTAS, EQUIPOS where EQUIPOS.NOMBRE=nombreEquipo and
                                                                                                    EQUIPOS.CODEQUIPO=CICLISTAS.CODEQUIPO and
                                                                                                    CICLISTAS.DORSAL=CLASIFICACIONETAPAS.DORSAl AND
                                                                                                    CLASIFICACIONETAPAS.POSICION='1';
        end if;
        return totalCarrerasGanadas;
    end numeroCarrerasGanadas;
        end ExamenJavierCampos;




-- 2.Realiza un procedimiento llamado listado muestre todos los equipos y el número de jugadores que
-- pertenecen a cada equipo con el siguiente formato (3 puntos)
-- Nombre: nombreEquipoNacionalidad: nacionalidad      Nombre del director: nombre
-- NombreCiclista1º    Fecha nacimiento
-- NombreCiclista2º    Fecha nacimiento
-- ----------------------------------------------------
-- NombreCiclistaN     Fecha nacimiento
-- Nombre: nombreEquipo    Nacionalidad: nacionalidad      Nombre del director: nombre

-- NombreCiclista1º    Fecha nacimiento
-- NombreCiclista2º    Fecha nacimiento
-- ----------------------------------------------------
-- NombreCiclistaN Fecha nacimiento

create or replace procedure listado is
    codigoEquipo number;
cursor datos is
select NOMBRE, NACIONALIDAD, NOMBREDIRECTOR, CODEQUIPO from EQUIPOS;

cursor ciclistas is
    select CICLISTAS.NOMBRE, CICLISTAS.FECHANACIMIENTO from CICLISTAS, EQUIPOS where CICLISTAS.CODEQUIPO=EQUIPOS.CODEQUIPO;

    begin
        for equipo in datos loop
            codigoEquipo:=equipo.CODEQUIPO;

            DBMS_OUTPUT.PUT_LINE('Nombre equipo: '||equipo.NOMBRE || ' Nacionalidad: '|| equipo.NACIONALIDAD || ' Nombre director: ' || equipo.NOMBREDIRECTOR);
                for ciclista in ciclistas loop
                    DBMS_OUTPUT.PUT_LINE('Nombre ciclista: ' || ciclista.NOMBRE || ' Fecha nacimiento: ' || ciclista.FECHANACIMIENTO);
                    end loop;
            DBMS_OUTPUT.PUT_LINE(' ');

            end loop;
    end;


call listado();



-- 2.Crear una función que devuelva el número de carreras que hań ganado los corredores de un equipo. 
-- Elnombre del equipo se le pasará por parámetro. Si  no existe el equipo deberá generar una excepción.

create or replace function numeroCarrerasGanadas(nombreEquipo varchar2) return number is
totalCarrerasGanadas number;
    aux number;
    begin
        select count(CODEQUIPO) into aux from EQUIPOS where NOMBRE=nombreEquipo;
        if aux =0 then
            RAISE_APPLICATION_ERROR(-20009, 'El equipo no existe');
        else
        select count(CLASIFICACIONETAPAS.DORSAL) into totalCarrerasGanadas from CLASIFICACIONETAPAS, CICLISTAS, EQUIPOS where EQUIPOS.NOMBRE=nombreEquipo and
                                                                                                    EQUIPOS.CODEQUIPO=CICLISTAS.CODEQUIPO and
                                                                                                    CICLISTAS.DORSAL=CLASIFICACIONETAPAS.DORSAl AND
                                                                                                    CLASIFICACIONETAPAS.POSICION='1';
        end if;
        return totalCarrerasGanadas;
    end;

    select numeroCarrerasGanadas('KAS') FROM DUAL;


    -- 3.Realiza un trigger que impida que haya más de cuatro ciclistas en un equipo. Si hay 4 no se podrán
    -- insertar más ciclistas por lo que deberá lanzar una excepción 
CREATE OR REPLACE TRIGGER noMasDeCuatro before insert on CICLISTAS for each row
declare
    numCicli number;

    begin
    select count(*) into numCicli from CICLISTAS where CODEQUIPO=:new.CODEQUIPO;
    if numCicli>=4 then
        RAISE_APPLICATION_ERROR(-20019, 'No puede haber mas de 4 ciclistas por equipo');
    end if;


    end;


      insert into CICLISTAS values (18, 'Antonio Campos', 'Española', 4, to_date('29/05/1998', 'dd-mm-yy'));
commit;


    
--     4.Crea una tabla llamada memoria con un único campo de tipo varchar llamado descripcion y realizar un
--     trigger o los trigger que creas necesario para registrar la pertenencia de un ciclista a un equipo. 
--     Debeguardar la siguiente información: (3 puntos)
-- ▪El jugador <nombreJugador> ha empezado a formar parte del equipo <NombreEquipo> el día<la fecha correspondiente>
-- ▪El jugador <nombreJugador> ha dejado de formar parte del equipo <NombreEquipo> el día <lafecha correspondie
 create table memoria(
        descripcion varchar2(900)
    );

--Este trigger introducira el mensaje de pertenecia a nuevos equipos
   create or replace trigger info after insert or delete or update on ciclistas for each row
    declare
         equipoNombre varchar2(200);
        equipoNombreDelete varchar2(200);

    begin
            select EQUIPOS.NOMBRE into equipoNombre from EQUIPOS  where EQUIPOS.CODEQUIPO=:new.codequipo;
            select EQUIPOS.NOMBRE into equipoNombreDelete from EQUIPOS  where EQUIPOS.CODEQUIPO=:old.codequipo;

         if updating ('CODEQUIPO') and :NEW.CODEQUIPO <> :old.CODEQUIPO then
            select EQUIPOS.NOMBRE into equipoNombre from EQUIPOS  where EQUIPOS.CODEQUIPO=:new.codequipo;

                 insert into memoria values ('El jugador ' || :OLD.nombre || ' ha empezado a formar parte del equipo ' || equipoNombre || ' el dia ' || sysdate);


        end if;

        if inserting then
            insert into memoria values ('El jugador ' || :new.nombre || ' ha empezado a formar parte del equipo ' || equipoNombre || ' el dia ' || sysdate);
        end if;
    end;








--este Trigger introducirá el mensaje cuando el jugador deja de formar parte de un equipo
create or replace trigger infoDelete after  delete or update on ciclistas for each row
    declare
        equipoNombreDelete varchar2(200);

    begin
            select EQUIPOS.NOMBRE into equipoNombreDelete from EQUIPOS  where EQUIPOS.CODEQUIPO=:old.codequipo;
        --Cuando se modifique el equipo si el codigo nuevo es distinto al viejo, se introducira la informacion de que ha dejado de formar parte del equipo
         if updating ('CODEQUIPO') and :NEW.CODEQUIPO <> :old.CODEQUIPO then
            select EQUIPOS.NOMBRE into equipoNombreDelete from EQUIPOS  where EQUIPOS.CODEQUIPO=:old.codequipo;


            insert into memoria values ('El jugador ' || :OLD.nombre || ' ha dejado de formar parte del equipo ' || equipoNombreDelete || ' el dia ' || sysdate);


        end if;
        --Si se borra un ciclista automaticamente dejará de formar parte del equipo
        if deleting then
            insert into memoria values ('El jugador ' || :old.nombre || ' ha dejado de formar parte del equipo ' || equipoNombreDelete || ' el dia ' || sysdate);
        end if;
    end;


    --Asi compruebo que los triggers funcionan
        insert into CICLISTAS values (17, 'Javier Campos', 'Española', 1, to_date('29/05/1998', 'dd-mm-yy'));
commit;

delete from CICLISTAS where DORSAL=17;
commit;

UPDATE CICLISTAS SET CODEQUIPO=6 WHERE DORSAL=17;
COMMIT;