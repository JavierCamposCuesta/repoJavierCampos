    1. Añade un campo en la tabla profesor para almacenar las asignaturas que imparte cada uno. Rellena este campo con los datos existentes.
       alter table PROFESOR
       add (imparte number(2));
       
       update PROFESOR p
       set imparte =
           (select count(*)
           from ASIGNATURA a
           where a.idprofesor = p.idprofesor);
       
    2. Crea una nueva tabla en la que guardaremos el nombre del profesor y el número de alumnos que tiene cada profesor. Rellena la tabla con los datos existentes.
       create table PROFESOR_ALUMNO(
       profesor varchar2(20),
       num_alumnos number (2),
       primary key (profesor)
       );
       
       insert into PROFESOR_ALUMNO (profesor, num_alumnos)
       select per.nombre||' '||per.apellido, count (aa.idalumno)
       from PERSONA per, PROFESOR p, ASIGNATURA a, ALUMNO_ASIGNATURA aa
       where per.dni = p.dni
       and p.idprofesor = a.idprofesor
       and a.idasignatura = aa.idasignatura
       group by per.nombre||' '||per.apellido;
       
    3. Crea un nuevo campo en la tabla asignatura para guardar el nombre de la titulación a la que pertenece. Rellena el campo con los datos existentes.
       alter table ASIGNATURA
       add (titulacion varchar2(20));
       
       update ASIGNATURA a
       set titulacion = (
           select t.nombre
           from TITULACION t
           where a.idtitulacion = t.idtitulacion);
       
    4. Borra las personas que no sean ni alumnos ni profesores.
       delete from PERSONA per
       where (per.dni not in
           (select dni
           from ALUMNO) and 
           per.dni not in 
           (select dni
           from PROFESOR));
       
    5. Añade un nuevo campo en la tabla titulación para guardar el número de asignaturas que tiene cada titulación. Rellena el campo con los datos existentes.
       alter table TITULACION
       add (num_asignaturas number (2));
       
       update TITULACION t
       set num_asignaturas = (
           select count (*)
           from ASIGNATURA a
           where a.idtitulacion = t.idtitulacion);
       
    6. Crea una nueva tabla para guardar el nombre del alumno, junto con el total que tiene que pagar por su matrícula. Recuerda que por cada repetición hay que subirle un 10%.  Rellena la tabla con los datos existentes
       create table PAGOS (
       alumno varchar2(50),
       pagado number (6),
       primary key (alumno)
       );
       
       insert into PAGOS (alumno, pagado)
       select p.nombre||' '||p.apellido, sum(asi.costebasico+asi.costebasico+(aa.numeromatricula-1)*0.1)
       from PERSONA p, ALUMNO a, ALUMNO_ASIGNATURA aa, ASIGNATURA asi
       where p.dni = a.dni
       and a.idalumno = aa.idalumno
       and aa.idasignatura = asi.idasignatura
       group by p.nombre||' '||p.apellido;

    7. Añade un nuevo campo en la tabla alumnos para almacenar el número total de créditos del que está matriculado. Rellena el campo con los datos existentes.
       alter table ALUMNO
       add (creditos number(3));
       
       update ALUMNO al
       set creditos = (
           select sum(a.creditos)
           from ALUMNO_ASIGNATURA aa, ASIGNATURA a
           where aa.idasignatura = a.idasignatura 
           and al.idalumno = aa.idalumno);
       
    8. Borra las titulaciones que no tengan ninguna asignatura
       delete from TITULACION
       where idtitulacion not in (
           select idtitulacion
           from ASIGNATURA);
       
    9. Crea una tabla profesores completas, en ellas que aparecerán el nombre, apellido, ciudad, teléfono y el número de titulaciones en las que da clase.  Rellena la tabla con los datos existentes
       create table PROFESORES(
       nombre varchar2 (30),
       apellido varchar2 (30),
       ciudad varchar2 (30),
       telefono varchar2 (10),
       num_titulaciones number (2),
       primary key (nombre, apellido)
       );
       
       insert into PROFESORES
       select p.nombre, p.apellido, p.ciudad, p.telefono, count(distinct(a.idtitulacion))
       from PERSONA p, PROFESOR pro, ASIGNATURA a
       where p.dni = pro.dni
       and pro.idprofesor = a.idprofesor
       group by p.nombre, p.apellido, p.ciudad, p.telefono;
       

    10. Crea un campo en la tabla persona llamado ejer10 en el que se almacenará las dos primeras letras del nombre, un número que identificará donde aparece una “a” dentro del nombre, junto con el día de la fecha de nacimiento.
       alter table PERSONA
       add (ejer10 varchar2(6));
       
       update PERSONA p
       set ejer10 = (
       select substr (nombre, 1, 2)||instr (nombre, 'a')||to_char (fecha_nacimiento, 'dd')
       from PERSONA per
       where p.dni = per.dni);