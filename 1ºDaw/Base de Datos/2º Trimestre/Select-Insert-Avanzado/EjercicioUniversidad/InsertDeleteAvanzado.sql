    1. Añade un campo en la tabla profesor para almacenar las asignaturas que imparte cada uno. 
    Rellena este campo con los datos existentes.
    ALTER TABLE PROFESOR ADD ASIGNATURA VARCHAR2(30);

    UPDATE PROFESOR P2 SET ASIGNATURA = (SELECT COUNT(*) FROM ASIGNATURA a WHERE A.IDPROFESOR =P2.IDPROFESOR  );



    2. Crea una nueva tabla en la que guardaremos el nombre del profesor y el número de alumnos que tiene cada profesor. 
    Rellena la tabla con los datos existentes.
    CREATE TABLE ALUMNOS_POR_PROFESOR(
    NOMBRE_PROFESOR VARCHAR2(30),
    NUMERO_ALUMNOS NUMBER(3)
    );   

    INSERT INTO ALUMNOS_POR_PROFESOR(NOMBRE_PROFESOR, NUMERO_ALUMNOS) SELECT P.NOMBRE, COUNT(aa.IDALUMNO) 
    FROM PERSONA p , PROFESOR p2, ASIGNATURA a , ALUMNO_ASIGNATURA aa 
    WHERE P.DNI =P2.DNI AND a.IDPROFESOR=p2.IDPROFESOR AND aa.IDASIGNATURA=a.IDASIGNATURA GROUP BY p.NOMBRE
    ; COMMIT;

    

    3. Crea un nuevo campo en la tabla asignatura para guardar el nombre de la titulación a la que pertenece. 
    Rellena el campo con los datos existentes.
    ALTER TABLE ASIGNATURA ADD TITULACION VARCHAR2(30);

    UPDATE ASIGNATURA A2 SET TITULACION = (SELECT T.NOMBRE FROM TITULACION t 
    WHERE A2.IDTITULACION = T.IDTITULACION) ;

    4. Borra las personas que no sean ni alumnos ni profesores.
    DELETE  FROM PERSONA p WHERE P.DNI NOT IN (SELECT A.DNI FROM ALUMNO a ) 
    AND P.DNI NOT IN (SELECT P2.DNI FROM PROFESOR p2);

    5. Añade un nuevo campo en la tabla titulación para guardar el número de asignaturas que tiene cada titulación. 
    Rellena el campo con los datos existentes.
    ALTER TABLE TITULACION ADD NUMERO_ASIGNATURA NUMBER(6);

    UPDATE TITULACION T SET NUMERO_ASIGNATURA = (SELECT COUNT(A.IDASIGNATURA) FROM ASIGNATURA a 
    WHERE A.IDTITULACION =T.IDTITULACION); 

    6. Crea una nueva tabla para guardar el nombre del alumno, junto con el total que tiene que pagar por su matrícula. 
    Recuerda que por cada repetición hay que subirle un 10%.  Rellena la tabla con los datos existentes
    CREATE TABLE PAGAR(
    NOMBRE_ALUMNO VARCHAR2(30),
    PAGO NUMBER(9)
    );

    INSERT INTO PAGOS(NOMBRE_ALUMNO, PAGO) SELECT p2.NOMBRE ,  SUM(a3.COSTEBASICO*(((aa.NUMEROMATRICULA-1)*0.1)+1)) 
    AS PAGO FROM ALUMNO a2 , ALUMNO_ASIGNATURA aa , PERSONA p2 , ASIGNATURA a3 
    WHERE p2.DNI = a2.DNI AND a2.IDALUMNO =aa.IDALUMNO AND aa.IDASIGNATURA =a3.IDASIGNATURA AND aa.NUMEROMATRICULA>=1  
    GROUP BY p2.NOMBRE, p2.DNI



    7. Añade un nuevo campo en la tabla alumnos para almacenar el número total de créditos del que está matriculado. 
    Rellena el campo con los datos existentes.
    ALTER TABLE ALUMNO ADD (
    TOTAL_CREDITOS NUMBER(9));  

    UPDATE  ALUMNO A3 SET TOTAL_CREDITOS = (SELECT SUM(A.CREDITOS) FROM ASIGNATURA a, ALUMNO_ASIGNATURA aa, ALUMNO a2
    WHERE A.IDASIGNATURA=AA.IDASIGNATURA AND AA.IDALUMNO=A2.IDALUMNO AND A3.IDALUMNO =A2.IDALUMNO GROUP BY A2.IDALUMNO )



    8. Borra las titulaciones que no tengan ninguna asignatura
    DELETE FROM TITULACION t WHERE T.IDTITULACION NOT IN (SELECT A.IDTITULACION FROM ASIGNATURA a) 

    9. Crea una tabla profesores completas, en ellas que aparecerán el nombre, apellido, ciudad, 
    teléfono y el número de titulaciones en las que da clase.  Rellena la tabla con los datos existentes
    CREATE TABLE PROFESOR_COMPLETA AS (SELECT P2.NOMBRE , P2.APELLIDO , P2.CIUDAD , P2.TELEFONO , COUNT(DISTINCT (A.IDTITULACION)) AS NUMERO_TITULACIONES 
    FROM PROFESOR p , PERSONA p2 , ASIGNATURA a WHERE P.DNI =P2.DNI AND P.IDPROFESOR = A.IDPROFESOR 
    GROUP BY P2.NOMBRE , P2.APELLIDO, P2.CIUDAD, P2.TELEFONO )   

    10. Crea un campo en la tabla persona llamado ejer10 en el que se almacenará las dos primeras letras del nombre, 
    un número que identificará donde aparece una “a” dentro del nombre, junto con el día de la fecha de nacimiento.
    ALTER TABLE PERSONA ADD EJER10 VARCHAR2(30);

    UPDATE PERSONA P2 SET EJER10 =(SELECT SUBSTR(NOMBRE, 1,2)|| instr (nombre, 'a')|| to_char (fecha_nacimiento, 'dd') AS CODIGO_PERSONA  
    FROM PERSONA p WHERE P2.DNI =P.DNI )
