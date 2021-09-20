-- 1.Escribe unprocedimiento que muestre el número de empleados y el salariomínimo, máximo y medio del departamento de FINANZAS. 
-- Debe hacerse uso decursores implícitos, es decir utilizar SELECT ... INTO.

create or replace procedure datosEmpleados is
numeroEmpleados empleados.numem%type;
salarioMaximo empleados.SALAR%type;
salarioMinimo empleados.SALAR%type;
mediaSalario empleados.SALAR%type;
    BEGIN
        select count(NUMDE),max(SALAR), min(SALAR), avg(SALAR) 
        into numeroEmpleados, salarioMaximo, salarioMinimo, mediaSalario from EMPLEADOS;
       

        DBMS_OUTPUT.PUT_LINE('Numero de empleados: ' || numeroEmpleados);
        DBMS_OUTPUT.PUT_LINE('Salario maximo: ' || salarioMaximo);
        DBMS_OUTPUT.PUT_LINE('Salario minimo: ' || salarioMinimo);
        DBMS_OUTPUT.PUT_LINE('Media del salario: ' || mediaSalario);
    end;


call datosEmpleados();

-- 2.Escribe un procedimiento que suba un 10% el salario a los EMPLEADOS conmás de 2 hijos y que ganen menos de 2000 €. 
-- Para cada empleado se mostrar por pantalla el código de empleado, nombre, salario anterior y final. Utiliza un cursorexplícito. 
-- La transacción no puede quedarsea medias. Si por  cualquier  razón  no  esposible  actualizar  todos  estos  salarios, 
--  debe deshacerse el trabajo a la situacióninicial.

create or replace procedure subirSalario is
cursor datos is
select * from EMPLEADOS;
    begin
        for datosEmpleados in datos
        loop
            if(datosEmpleados.NUMHI>=2 and datosEmpleados.SALAR<2000) then


            DBMS_OUTPUT.PUT_LINE('codigo: ' || datosEmpleados.NUMEM);
            DBMS_OUTPUT.PUT_LINE('nombre: ' || datosEmpleados.NOMEM);
            DBMS_OUTPUT.PUT_LINE('salario anterior: ' || datosEmpleados.SALAR);
            DBMS_OUTPUT.PUT_LINE('salario nuevo: ' || datosEmpleados.SALAR*1.10);

            update EMPLEADOS set SALAR=SALAR*1.10 where empleados.NUMEM=datosEmpleados.NUMEM;
            end if;


            end loop;
    end;


-- 3.Escribe   un   procedimiento   que   reciba   dos   parámetros   (número   dedepartamento, hijos). Deber. crearse un 
-- cursor explícito al que se le pasarán estosparámetros y que mostrar. los datos de los empleados que pertenezcan al
-- departamento y con el número de hijos indicados. Al final se indicar. el número deempleados obtenidos.
create or replace procedure empleadoDepartamento(numeroDepartamento EMPLEADOS.NUMDE%type, hijos EMPLEADOS.NUMHI%type ) is
cursor datos is
select * from EMPLEADOS where NUMHI=hijos and NUMDE=numeroDepartamento;
    begin
        for i in datos loop
            DBMS_OUTPUT.PUT_LINE('codigo departamento: ' || i.NUMDE  ||'|'|| 'numero empleado: ' || i.NUMEM ||'|'|| 'nombre: ' 
            || i.NOMEM ||'|'|| 'salario: '|| i.SALAR ||'|'|| 'numero hijos: ' ||'|'|| i.NUMHI);

            end loop;
    end;

    call EMPLEADODEPARTAMENTO(111, 2);

-- 4.Escribe un procedimiento con un parámetro para el nombre de empleado,que nos muestrela edad de dicho empleado en años, meses y días
create OR REPLACE procedure nacimientoEmpleado(nombre EMPLEADOS.NOMEM%type) is
    cursor edad is
        select EMPLEADOS.FECNA
        from EMPLEADOS
        where EMPLEADOS.NOMEM = nombre;
    numeroDias       number;
    numeroDiasRESULT number;
    numeroMeses      number;
    numeroYear       number;
begin

    for i in edad
        loop
            numeroDias := TRUNC(sysdate - i.FECNA);
            numeroYear := TRUNC(numeroDias / 365);
            numeroMeses := trunc(MOD(numeroDias, 365) / 30.4167);
            numeroDiasRESULT := round(mod(MOD(numeroDias, 365), 30.4167)-TRUNC(numeroYear/4));

            DBMS_OUTPUT.PUT_LINE('Dia: ' || numeroDiasRESULT || '- Mes: ' || numeroMeses
                                     || '- Año: ' || numeroYear);

        end loop;
end;
/