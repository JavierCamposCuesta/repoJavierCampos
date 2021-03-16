
    1. Mostrar el identificador de los alumnos matriculados en cualquier asignatura excepto la '150212' y la '130113'.
    SELECT DISTINCT A.IDALUMNO FROM ALUMNO_ASIGNATURA a WHERE A.IDASIGNATURA <>'150212' AND A.IDASIGNATURA <> '130113';

    2. Mostrar el nombre de las asignaturas que tienen más créditos que "Seguridad Vial". 
    SELECT A2.NOMBRE FROM ASIGNATURA a2 WHERE A2.CREDITOS > 
    (SELECT A.CREDITOS FROM ASIGNATURA a WHERE A.NOMBRE = 'Seguridad Vial')

    3. Obtener el Id de los alumnos matriculados en las asignaturas "150212" y "130113" a la vez. 

SELECT DISTINCT AA2.IDALUMNO FROM ALUMNO_ASIGNATURA aa2 WHERE AA2.IDALUMNO IN 
(SELECT AA.IDALUMNO FROM ALUMNO_ASIGNATURA aa WHERE IDASIGNATURA = '130113') AND AA2.IDALUMNO IN
(SELECT AA.IDALUMNO FROM ALUMNO_ASIGNATURA aa WHERE IDASIGNATURA = '150212')

    4. Mostrar el Id de los alumnos matriculados en las asignatura "150212" ó "130113", en una o en otra pero no en ambas a la vez. 
SELECT DISTINCT AA3.IDALUMNO FROM ALUMNO_ASIGNATURA aa3 WHERE AA3.IDASIGNATURA = '150212' OR AA3.IDASIGNATURA = '130113' AND AA3.IDALUMNO NOT IN
(SELECT DISTINCT AA2.IDALUMNO FROM ALUMNO_ASIGNATURA aa2 WHERE AA2.IDALUMNO IN 
(SELECT AA.IDALUMNO FROM ALUMNO_ASIGNATURA aa WHERE IDASIGNATURA = '130113') AND AA2.IDALUMNO IN
(SELECT AA.IDALUMNO FROM ALUMNO_ASIGNATURA aa WHERE IDASIGNATURA = '150212'))


    5. Mostrar el nombre de las asignaturas de la titulación "130110" cuyos costes básicos sobrepasen el coste básico promedio por asignatura en esa titulación.
SELECT A2.NOMBRE FROM ASIGNATURA a2 WHERE A2.IDASIGNATURA = '130110' AND A2.COSTEBASICO >
(SELECT AVG(A.COSTEBASICO) FROM ASIGNATURA a WHERE A.IDASIGNATURA = '130110') 


    6. Mostrar el identificador de los alumnos matriculados en cualquier asignatura excepto la "150212" y la "130113"
SELECT  DISTINCT AA.IDALUMNO FROM ALUMNO_ASIGNATURA aa WHERE AA.IDASIGNATURA <> '150212' AND AA.IDASIGNATURA <> '130113';

    7. Mostrar el Id de los alumnos matriculados en la asignatura "150212" pero no en la "130113". 
SELECT AA3.IDALUMNO FROM ALUMNO_ASIGNATURA aa3 WHERE AA3.IDASIGNATURA = '150212' AND AA3.IDALUMNO 
 NOT IN 
(SELECT AA2.IDALUMNO FROM ALUMNO_ASIGNATURA aa2 WHERE AA2.IDASIGNATURA = '130113')

    8. Mostrar el nombre de las asignaturas que tienen más créditos que "Seguridad Vial". 
   SELECT A2.NOMBRE FROM ASIGNATURA a2 WHERE A2.CREDITOS > 
    (SELECT A.CREDITOS FROM ASIGNATURA a WHERE A.NOMBRE = 'Seguridad Vial')

    9. Mostrar las personas que no son ni profesores ni alumnos.
SELECT p2.NOMBRE FROM PERSONA p2 WHERE p2.DNI NOT IN 
(SELECT P.IDPROFESOR FROM PROFESOR p)  AND p2.DNI  NOT IN 
(SELECT a.IDALUMNO FROM ALUMNO a)

    10. Mostrar el nombre de las asignaturas que tengan más créditos. 
SELECT a2.NOMBRE FROM ASIGNATURA a2 WHERE a2.CREDITOS =(
SELECT MAX(a.CREDITOS) FROM ASIGNATURA a )

    11. Lista de asignaturas en las que no se ha matriculado nadie. 
SELECT a2.NOMBRE FROM ASIGNATURA a2 WHERE a2.IDASIGNATURA NOT IN 
(SELECT aa.IDASIGNATURA FROM ALUMNO_ASIGNATURA aa )

    12. Ciudades en las que vive algún profesor y también algún alumno. 
    SELECT p3.CIUDAD FROM PERSONA p3 WHERE p3.DNI in
(SELECT p2.DNI FROM PROFESOR p2) AND p3.DNI in
(SELECT a2.DNI FROM ALUMNO a2)