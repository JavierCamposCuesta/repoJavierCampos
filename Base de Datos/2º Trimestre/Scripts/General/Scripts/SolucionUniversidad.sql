    1. Mostrar el identificador de los alumnos matriculados en cualquier asignatura excepto la '150212' y la '130113'.
select distinct(idalumno)
from alumno_asignatura
where idalumno not in(select idalumno from alumno_asignatura
			where idasignatura = 150212 or idasignatura = 130113);


    2. Nombre de las asignaturas que tienen más créditos que "Seguridad Vial". 
SELECT Nombre 
FROM asignatura 
WHERE Creditos > (select Creditos from asignatura where Nombre = 'Seguridad Vial');

    3. Id de los alumnos matriculados en las asignaturas "150212" y "130113" a la vez. 

select distinct(idalumno)
from alumno_asignatura
where idalumno in (select idalumno from alumno_asignatura where idasignatura=150212)
And idalumno in (select idalumno from alumno_asignatura where idasignatura=130113);

    4. Id de los alumnos matriculados en las asignatura "150212" ó "130113", en una o en otra pero no en ambas a la vez. 

select distinct(idalumno)
from alumno_asignatura
where (idasignatura = 130113 and idalumno not in
(select idalumno from alumno_asignatura where idasignatura=150212))
Or
(idasignatura = 150212 and idalumno not in
(select idalumno from alumno_asignatura where idasignatura=130113));

    5. Nombre de las asignaturas de la titulación "130110" cuyos costes básicos sobrepasen el coste básico promedio por asignatura en esa titulación.

select nombre
from asignatura a
where costebasico>=(select avg(a.costebasico) from asignatura a
				where idtitulacion='130110')
	   and idtitulacion='130110';

    6. Mostrar el identificador de los alumnos matriculados en cualquier asignatura excepto la "150212" y la "130113". (Es el ejemplo 19).

SELECT distinct(idalumno)
from alumno_asignatura
where  idalumno not in(SELECT idalumno
from alumno_asignatura
where  idasignatura in('150212','130113'));

    7. Id de los alumnos matriculados en la asignatura "150212" pero no en la "130113". 

select idalumno
from alumno_asignatura
where idasignatura = '150212'
	and idalumno not in(SELECT idalumno
			from alumno_asignatura
			where  idasignatura = 130113);

        8. Nombre de las asignaturas que tienen más créditos que "Seguridad Vial". 

select distinct(nombre)
from asignatura
where creditos>(select creditos
            from asignatura
            where ltrim(lower(nombre))='seguridad vial');

    9. Mostrar las personas que no son ni profesores ni alumnos.

select * from persona
where dni not in(select dni from alumno )
    and dni not in(select dni from profesor);

    10. Nombre de las asignaturas que tengan más créditos. 

select  nombre
from asignatura
where creditos = (select max(creditos)
                from asignatura);

    11. Lista de asignaturas en las que no se ha matriculado nadie. 

select nombre
from asignatura a
where idasignatura not  in(select idasignatura
              from alumno_asignatura);

    12. Ciudades en las que vive algún profesor y también algún alumno. 

select distinct(p.ciudad)
from persona p, persona p1
where  p.dni in(select dni from alumno)
or p1.dni in(select dni from profesor)
and p.ciudad=p1.ciudad
and p.dni>p1.dni