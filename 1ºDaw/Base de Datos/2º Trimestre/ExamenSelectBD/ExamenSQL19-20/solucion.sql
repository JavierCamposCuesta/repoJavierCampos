1. Nombre y apellidos de las personas nacidas después del año 1979 ordenadas de más
jóvenes a más viejas.
SELECT NOMBRE , APELLIDOS FROM PERSONAS p WHERE FECHA_NACIMIENTO > '01-01-0080' ORDER BY FECHA_NACIMIENTO DESC

2. Código de los distintos caballos que han obtenido alguna vez un podio ordenados por el
código. (Para obtener un podio ha debido quedar en su posición final entre los 3
primeros). (0,25 puntos)
SELECT DISTINCT CODCABALLO FROM  PARTICIPACIONES p WHERE P.POSICIONFINAL <=3  ORDER BY CODCABALLO 

3. Obtener todos los atributos de las carreras cuyo premio sea mayor que 50000. (0,25
puntos)
SELECT * FROM  CARRERAS c WHERE IMPORTEPREMIO >5000

4. Obtener el nombre aquellos clientes (sin que salgan valores repetidos) que han
apostado por caballos, cuyo dueño se llama Jose o Inmaculada. (1 punto)
SELECT DISTINCT c.NOMBRE FROM  PERSONAS p , CLIENTES c, APUESTAS a, CABALLOS c2 WHERE C.DNI = A.DNICLIENTE AND A.CODCABALLO = c2.CODCABALLO AND C2.PROPIETARIO = P.CODIGO AND (P.NOMBRE LIKE ('Jose') OR P.NOMBRE LIKE ('Inmaculada'))

5. Obtener el nombre y el dni de todos los clientes que no sean ni británicos ni
escoceses (0,5 puntos)
SELECT NOMBRE ,DNI FROM CLIENTES c WHERE NACIONALIDAD !='Britanica' AND NACIONALIDAD !='Escocesa'

6. Obtener el código del propietario y el nombre de los caballos que hayan nacido en el
mes de noviembre o tengan un peso igual o superior a 260 ordenados por código de
propietario de mayor a menor y por el nombre alfabéticamente. (0,5 puntos)


7. Obtener nombres distintos de las personas que contengan una 'J' mayúscula y una 'e'
minúscula en su nombre. (0,5 puntos)
8. Obtener el código de los diferentes caballos que han ganado más de una carrera. (1 punto)
9. Mostrar el nombre del caballo o caballos que hayan ganado más carreras, es decir,
que hayan quedado primeros más veces. (1 punto)
No olvides que “hay que cuidar a Oracle”. Tus consultas deben ser óptimasI.E.S. Jacarandá
26/02/2020
Nombre ...............................................................................................................................................................................
10. Conseguir una consulta que muestre el nombre de los Jockey, junto con el número de
los distintos caballos que ha montado (no el número de veces que ha montado). Los
jockeys que más caballos distintos hayan montado deben salir primero, y a igualdad
de número se aplicará el orden alfabético de sus nombres (1 punto)
11. Obtener el nombre y apellidos de los jockey junto con el nombre del caballo que
montaban cuando ganaron una carrera. (0,5 puntos)
12. Obtener el nombre de la carrera, el nombre del cliente y el importe de la apuesta de
aquellas carreras en las que se ha superado el límite de la apuesta (0,5 puntos).
13. Obtener el nombre de los caballos que han quedado siempre primeros en todas las
carreras que han corrido (1 punto)
14. Para todas las carreras que se corrieron el 12 de Julio de 2009 mostrar el nombre
del caballo, el nombre del dueño, el nombre del jockey y el nombre de la carrera. Los
datos deben estar ordenados alfabéticamente por el nombre de la carrera y el
nombre del caballo; (1 punto)
15. Mostrar el nombre y la nacionalidad de aquellos clientes que hayan apostado más de
800 EUROS en total (0,5 puntos)