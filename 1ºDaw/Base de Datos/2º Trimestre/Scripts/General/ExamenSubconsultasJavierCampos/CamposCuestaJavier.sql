1. Número de clientes que tienen alguna factura distinta a IVA 16%.(0,5 Puntos)
SELECT COUNT(FACTURAS.CODCLI) FROM CLIENTES ,FACTURAS WHERE CLIENTES.CODCLI = FACTURAS.CODCLI AND FACTURAS.IVA!='16'
--En este caso no tendremos en cuenta cuando los ivas son nulos

2.Número  de  clientes  que  en  todas  sus  facturas  tienen  un  16%  de  IVA  (los  clientes deben tener al menos una factura).(0,5 Puntos)
SELECT COUNT(F2.CODCLI) AS NUMERO_CLIENTES FROM FACTURAS f2 WHERE F2.CODCLI IN 
(SELECT F.CODCLI FROM FACTURAS f WHERE F.IVA =16 HAVING  COUNT(F.CODFAC)>0 GROUP BY F.CODCLI );  
--Para ver que al menos tengan una factura lo que hago es que la cantidad de codigos de facturas tiene que ser mayor que 0

3.Fecha de la factura con menorimporte (sin tener en cuenta descuentos ni impuestos).(0,5 Puntos)
SELECT FACTURAS.FECHA FROM FACTURAS, LINEAS_FAC WHERE FACTURAS.CODFAC=LINEAS_FAC.CODFAC GROUP BY FACTURAS.FECHA
HAVING = (SELECT MIN(SUM(LINEAS_FAC.PRECIO * LINEAS_FAC.CANT))  
FROM FACTURAS, LINEAS_FAC WHERE LINEAS_FAC.CODFAC = FACTURAS.CODFAC)

4.Número de pueblos en los que no tenemos clientes.(0,5 Puntos)
SELECT COUNT(p.CODPUE) FROM PUEBLOS p WHERE P.CODPUE NOT IN (SELECT C.CODPUE FROM CLIENTES c); 
--Este ejercicio simplemente tenemos que buscar los pueblos donde hay clientes y hacer una select para que no coja estos pueblos

5.Número  de  artículos  cuyo  stock  supera  las 10unidades,  con  precio  superior  a 35euros y de los que no hay ninguna factura en el segundotrimestre 
del año pasado.(0,5 Puntos)
SELECT COUNT(*) FROM ARTICULOS a WHERE A.STOCK >10 AND A.PRECIO >35 AND A.CODART NOT IN 
(SELECT LF.CODART FROM LINEAS_FAC lf , FACTURAS f 
WHERE LF.CODFAC =F.CODFAC AND EXTRACT (MONTH FROM F.FECHA)>3 AND EXTRACT (MONTH FROM F.FECHA)<7 
AND EXTRACT  (YEAR FROM F.FECHA)= EXTRACT (YEAR FROM SYSDATE)-1);

/*Para hacer la restriccion de que no sea del año pasado también podria hacerlo directamente igualando el EXTRACT (MONTH FROM F.FECHA)=2020,
pero si lo hiciese de esta forma no podría utilizar esta forma año tras año, es decir, tendría que ir modificando el año,
por eso veo más lógico calcular el año anterior con SYSDATE -1, así el o que viene también se podrá utilizar esta mismo consulta*/ 

6.Obtener el número de clientes que en todas las facturas del año pasado no han pagado IVA (no se ha pagado IVA si es cero o nulo).(0,75 Puntos)
SELECT COUNT(*) FROM FACTURAS f2 WHERE F2.CODCLI IN (SELECT F.CODCLI FROM FACTURAS f 
WHERE (F.IVA =0 OR F.IVA IS NULL) AND EXTRACT (YEAR FROM F.FECHA)=EXTRACT (YEAR FROM SYSDATE)-1);


7.Clientes (código y nombre) que fueron preferentes durante el mes de juniodehace dos  años y  que  en septiembrede  ese  mismo  año  no  tienen  ninguna  factura.  
Son clientes  preferentes  de  un  mes  aquellos  que  han  solicitado  más  de 300euros  en facturas durante ese mes, sin tener en cuenta descuentos ni impuestos.(0,75 Puntos)
SELECT c.CODCLI , c.NOMBRE FROM FACTURAS f , CLIENTES c WHERE f.CODCLI =c.CODCLI AND F.CODCLI 
IN (SELECT F2.CODCLI FROM FACTURAS f2, LINEAS_FAC lf WHERE F2.CODFAC =LF.CODFAC AND EXTRACT(MONTH FROM F2.FECHA)=06 
AND EXTRACT (YEAR FROM F2.FECHA)=EXTRACT(YEAR FROM SYSDATE)-2 HAVING SUM(LF.CANT*LF.PRECIO)>300 GROUP BY F2.CODCLI )
AND f.CODCLI 
NOT IN (SELECT F3.CODCLI FROM FACTURAS f3, LINEAS_FAC lf3 WHERE F3.CODFAC =LF3.CODFAC AND EXTRACT(MONTH FROM F3.FECHA)=09 
AND EXTRACT (YEAR FROM F3.FECHA)=EXTRACT(YEAR FROM SYSDATE))

--Para que no salgan los clientes con facturas en septiembre de este año lo que hago es buscar las facturas con esa fecha y posteriormente decir que el codigo cliente no se encuentre en esa select

8.Nombre de la provincia con mayor número de clientes.(0,75 Puntos)
SELECT P.NOMBRE FROM PROVINCIAS p , PUEBLOS p2 , CLIENTES c 
WHERE P.CODPRO =P2.CODPRO  AND  P2.CODPUE =C.CODPUE 
GROUP BY P.NOMBRE ,p.CODPRO HAVING COUNT(C.CODCLI)= 
(SELECT MAX(COUNT(C2.CODCLI)) FROM CLIENTES c2, PUEBLOS p3, PROVINCIAS p4
WHERE C2.CODPUE=P3.CODPUE AND P3.CODPRO=P4.CODPRO GROUP BY p4.CODPRO); 


9.Nombre del cliente con menorfacturación.(0,75 Puntos)
SELECT C.NOMBRE FROM CLIENTES c , LINEAS_FAC lf , FACTURAS f WHERE F.CODFAC = LF.CODFAC 
AND C.CODCLI =F.CODCLI GROUP BY C.NOMBRE HAVING SUM(LF.CANT*LF.PRECIO)=
(SELECT MIN(SUM(LF2.CANT*LF2.PRECIO)) FROM LINEAS_FAC lf2, FACTURAS f2 
WHERE LF2.CODFAC=F2.CODFAC GROUP BY F2.CODCLI)

10.Código  y  descripción  de  aquellos  artículos  con  un  precio inferiora  la  media  y  que hayan sido comprados por menos de 5clientes.(0,75 Puntos)
SELECT DISTINCT A.CODART , A.DESCRIP FROM ARTICULOS a 
WHERE A.PRECIO < (SELECT AVG(A2.PRECIO) FROM ARTICULOS a2) AND A.CODART 
IN (SELECT LF.CODART FROM LINEAS_FAC lf HAVING COUNT(LF.CODART)<5 GROUP BY LF.CODART)


11.Vamos  a  crear  una  nueva  tabla  en  la  que  tengamos  el  nombre  del  cliente  y  todo  lo gastado por cada cliente, pero sólo para aquellos clientes que hayan tenido tres o más facturas.  
Por  lo  que  vamos  a  crear  la  tabla  y  rellenarlas  con  los  datos  adecuados.(0,75 Puntos)
CREATE TABLE GASTO_CLIENTE AS(
SELECT C.NOMBRE , SUM(LF.CANT*LF.PRECIO) AS TOTAL_GASTADO FROM CLIENTES c , FACTURAS f , LINEAS_FAC lf 
WHERE C.CODCLI=F.CODCLI AND F.CODFAC=LF.CODFAC HAVING COUNT(F.CODFAC)>=3 GROUP BY C.NOMBRE) 

12.Vamos  a  añadir  en  provincias  un  nuevo  campo  en  el  que  guardaremos  el  número  de pueblos que tiene cada provincia.Rellena el nuevo campo de la tabla. (0,75 Puntos)
ALTER TABLE PROVINCIAS ADD NUMERO_PUEBLOS NUMBER(9);
--Primero tenemos que añadir una nueva columna a la tabla, a esta columna la vamos a llamar NUMERO_PUEBLOS

UPDATE PROVINCIAS P1 SET NUMERO_PUEBLOS =(SELECT COUNT(P.CODPRO) AS NUM_PUEBLOS
FROM PUEBLOS p , PROVINCIAS p2 WHERE P.CODPRO=P2.CODPRO AND P1.CODPRO=P2.CODPRO
GROUP BY P2.CODPRO)
--Posteriormente modificamos la nueva columna que hemos añadido introduciendole el número de pueblos que tiene cada una de las provincias


13.Borra los artículos que no se han vendido nunca.(0,75 Puntos)
DELETE FROM ARTICULOS a WHERE CODART NOT IN (SELECT DISTINCT LF.CODART FROM LINEAS_FAC lf)   
--Para esto simplementes tenemos que eliminar de la tabla articulos los articulos cuyo codigo no está registrado en la tabla LINEAS_FAC, al no encontrarse los codigos en esta tabla quiere decir que nunca se han vendido

14.Añade dos campos a facturas, en el que se guardará el total de la factura, y el total con iva (recuerda que antes de calcular el iva hay que calcularle el descuento) de cada factura.  
Estos  campos  no  podrán  tener  valores  nulos.  Rellena  los  campos  con  los valores que tenemos en la base de datos.(0,75 Puntos)
--Lo primero que tendremos que hacer será añadir las dos nuevas columnas que nos pide, a las cuales llamaré TOTAL_SIN_IVA Y TOTAL_CON_IVA
ALTER TABLE FACTURAS ADD TOTAL_SIN_IVA NUMBER(9);
ALTER TABLE FACTURAS ADD TOTAL_CON_IVA NUMBER(9);  

/*POSTERIORMENTE VAMOS A AÑADIR EN LA COLUMNA TOTAL_SIN_IVA LOS CORRESPONDIENTES DATOS.
Para ello, simpletente tenemos que añadir la selección resultante de sumar la cantitad de articulos por el precio de que tienen, haciendo los join correspondientes.
Esto lo hago de la siguiente forma */
UPDATE FACTURAS F2 SET F2.TOTAL_SIN_IVA = (SELECT SUM(LF.CANT*LF.PRECIO) AS TOTAL_SIN_IVA FROM FACTURAS f, LINEAS_FAC lf WHERE F.CODFAC=LF.CODFAC
AND F.CODFAC = F2.CODFAC GROUP BY LF.CODFAC );

/*Por último lo último que nos falta es calcularle el iva a la columna anterior incluyendo los descuentos que se hayan aplicado.
Para hacer esto simplemente tenemos que coger la columna anterior, en la cual tenemos el preico sin iva, restarles los descuentos, que en el caso
de que no hayan, es decir, sean nulos, le vamos a indicar que los tome como 0. Una vez hecho esto tenemos que sumarle el iva, por lo que 
el resultado anterior lo multiplicamos por el iva entre 100 +1, al igual que antes, si el iva es nulo lo tomaremos como 0,
así al multiplicar el precio por el iva se estará multiplicando por 1 y el resultado no se modificará. Lo hago de la siguiente forma*/

UPDATE FACTURAS F1 SET F1.TOTAL_CON_IVA =(SELECT(F2.TOTAL_SIN_IVA -NVL(F2.DTO,0))*((NVL(F2.IVA,0)/100)+1) AS TOTAL_CON_IVA
FROM FACTURAS F2 WHERE F2.CODFAC =F1.CODFAC );


15.Vamos  a  añadir  en  pueblos  un  nuevo  campo  en  el  que  guardaremos  el  número  de clientes  que  tiene  cada  pueblo.  Rellena  el  nuevo  campo  de  la  tabla  con  los  
valores apropiados.(0,75 Puntos)
--lo primero que haremos será añadir una nueva columna llamada NUMERO_CLIENTE
ALTER TABLE PUEBLOS ADD NUMERO_CLIENTE NUMBER(9);

--Posteriormente vamos a rellenar esta columna con el resultante de buscar el numero de clientes que tiene cada pueblo, lo haré de la siguiente forma
UPDATE PUEBLOS p1 SET p1.NUMERO_CLIENTE = 
(SELECT COUNT(C.CODCLI) FROM CLIENTES c, PUEBLOS p WHERE P.CODPUE=C.CODPUE AND P.CODPUE=P1.CODPUE GROUP BY P.CODPUE)