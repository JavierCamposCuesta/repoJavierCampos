-- 1.Crear un procedimiento que en la tabla emp incremente el salario el 10% a los empleados que
-- tengan una comisión superior al 5% del salario. 
create or replace procedure incrementarSalario is
cursor empleados is
    select EMPNO from EMP where COMM is not null and SAL*0.05<COMM;
    begin
        for emple in empleados
        loop
            update EMP set SAL= SAL*1.1 where emp.EMPNO=emple.EMPNO;

            end loop;
    end;
    commit;



-- 2.Realiza un procedimiento MostrarMejoresVendedores que muestre los nombres de los dos
-- vendedores/as con más comisiones.
create or replace procedure mostrarMejoresVendedores is
    i number:=0;
cursor vendedores is
select ENAME, COMM from EMP where COMM is not null order by COMM desc ;
    begin
    for vendedor in vendedores
        loop
        exit when i>=2;
        DBMS_OUTPUT.PUT_LINE (vendedor.ENAME);

        i:=i+1;


            end loop;
    end;

-- 3.Realiza un procedimiento MostrarsodaelpmE que reciba el nombre de un departamento al
-- revés y muestre los nombres de los empleados de ese departamento. 

--Esta forma es menos correcta
create or replace procedure MostrarsodaelpmE(departamentoInverso VARCHAR2) IS
nombreDepartamento varchar2(100):='';
    cursor c1 is
    select emp.ENAME from EMP, DEPT where DEPT.DNAME=nombreDepartamento and dept.DEPTNO=EMP.DEPTNO;
    begin
        for i in reverse  1..length(departamentoInverso)
        loop
            nombreDepartamento:=concat(nombreDepartamento, SUBSTR(departamentoInverso, i, 1));
        end loop;
       


        for empleado in c1
        loop
            DBMS_OUTPUT.PUT_LINE (empleado.ENAME);

            end loop;



    end;

CALL MOSTRARSODAELPME('SELAS')



--La forma mas correcta de hacerlo es esta
create or replace procedure DUMMY.MostrarsodaelpmE(departamentoInverso VARCHAR2) IS

    cursor c1 is
   select emp.ENAME from EMP, DEPT where REVERSE(DEPT.DNAME)=departamentoInverso and dept.DEPTNO=EMP.DEPTNO;
    begin
       

        for empleado in c1
        loop
            DBMS_OUTPUT.PUT_LINE (empleado.ENAME);

            end loop;
    end;

CALL MOSTRARSODAELPME('SELAS');





-- 4.Realiza un procedimiento RecortarSueldos que recorte el sueldo un 20% a los empleados
-- cuyo nombre empiece por la letra que recibe como parámetro. Trata las excepciones que
-- consideres necesarias.
CREATE OR REPLACE PROCEDURE recortarSueldo(caracter varchar2) is
    caracterNoValido Exception ;
    noEsLetra Exception ;
    noExisteEmpleado Exception ;
    numeroEmpleados number;
cursor c1 is
select EMPNO from EMP where ENAME like concat(upper(caracter), '%');
    begin

        if length(caracter) <>1 or caracter is null then
            raise caracterNoValido;
        end if;

         if ascii(upper(caracter)) not between 65 and 90 then
            raise noEsLetra;
        end if;

        select count(*) into numeroEmpleados from EMP where ENAME like concat(upper(caracter), '%');

        if numeroEmpleados=0 then
            raise noExisteEmpleado;
        end if;



            update EMP set SAL= sal/1.2 where ENAME like concat(upper(caracter), '%');
            DBMS_OUTPUT.PUT_LINE ('Modificado correctamente');

        EXCEPTION
    WHEN caracterNoValido THEN
      DBMS_OUTPUT.PUT_LINE ('Tiene que ser un solo caracter');

     WHEN noEsLetra THEN
      DBMS_OUTPUT.PUT_LINE ('El caracter tiene que ser una letra');


    WHEN noExisteEmpleado THEN
      DBMS_OUTPUT.PUT_LINE ('No existe empleado');
    end;

    call recortarSueldo('a');
commit;









-- 5.Realiza un procedimiento BorrarBecarios que borre a los dos empleados más nuevos de cada
-- departamento.
create or replace procedure borrarBecario IS
    cursor cDepartamento is select DEPTNO from DEPT;

        numeroDpto dept.deptno%TYPE;

    cursor c1 is
   select EMPNO from EMP where DEPTNO = numeroDpto order by HIREDATE desc ;
        cont number:=0;
        numeroEmple emp.empno%type ;
    begin
        for departamento in cDepartamento loop
            numeroDpto := departamento.DEPTNO;


       open c1;
       fetch c1 into numeroEmple;
        if c1%found then
            delete from emp where EMPNO=numeroEmple;
        end if;


       fetch c1 into numeroEmple;
       if c1%found then
            delete from EMP where EMPNO=numeroEmple;
        end if;

            close c1;
end loop;
    end;

call borrarBecario();
commit ;







--trigger


create or replace trigger antesEmpleado  before insert on emp
    for each row
    begin
        :new.ename := upper(:new.ename);
        :new.sal := 0;
    end;
    
    insert into EMP (EMPNO, ENAME, sal ) values (9999, 'javier', 888);


--crear una nueva columna para almacenar el numero de empleados en cada departamento

alter table dept add numEmpleados number(2);

update dept set numEmpleados = select count(*) from emp where emp.deptno = dept.deptno

--Para que se vaya actualizando el campo anterior creamos un trigger de despues para que lo haga automaticamente

create or replace trigger insertaEmple before insert on emp 
for each row
begin
    update dept set numEmpleados = numEmpleadps +1 where deptno = :new.deptno;
end;

--Para que cuando borres en esa tabla tambien se modifique hacemos lo siguiente
create or replace trigger insertaEmple before insert on emp 
for each row

BEGIN
	IF inserting THEN 
    	update dept set numEmpleados = numEmpleadps +1 where deptno = :new.deptno;
    ELSIF deleting THEN 
    	update dept set numEmpleados = numEmpleadps -1 where deptno = :old.deptno;
    ELSIF
    	if(:NEW.deptno <> :OLD.deptno)
    		UPDATE dept SET NUMEMPLEADOS = NUMEMPLEADOS +1 WHERE DEPTNO = :NEW.deptno;
    		update dept set numEmpleados = numEmpleadps -1 where deptno = :old.deptno;
    	END IF;
    END IF;
end;