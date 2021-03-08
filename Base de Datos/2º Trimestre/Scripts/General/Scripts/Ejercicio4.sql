        1. Número de clientes que tienen alguna factura con IVA 16%.
        SELECT COUNT(FACTURAS.CODCLI) FROM CLIENTES ,FACTURAS WHERE CLIENTES.CODCLI = FACTURAS.CODCLI AND FACTURAS.IVA='16'
        
        2. Número de clientes que no tienen ninguna factura con un 16% de IVA.
        SELEC COUNT (DISTINCT F2.CODCLI) AS NUM_CLIENTES FROM FACTURAS F2
        WHERE F2.IVA NOT IN (SELECT F.IVA FROM FACTURAS F WHERE F.IVA <>16 OR F.IVA IS NULL);


        SELECT COUNT(F.CODCLI) AS NUM_CLIENTES FROM FACTURAS f
        WHERE F.IVA IN (SELECT F.IVA FROM FACTURAS f WHERE F.IVA <> 16 OR F.IVA IS NULL);  
        
        3. Número de clientes que en todas sus facturas tienen un 16% de IVA (los clientes deben tener 
                al menos una factura).
        SELECT COUNT(F2.CODCLI) AS NUMERO_CLIENTES FROM FACTURAS f2 WHERE F2.CODCLI IN 
        (SELECT F.CODCLI FROM FACTURAS f WHERE F.IVA =16 HAVING  COUNT(F.CODFAC)>0 GROUP BY F.CODCLI );  
        
        4. Fecha de la factura con mayor importe (sin tener en cuenta descuentos ni impuestos).
        SELECT FACTURAS.FECHA FROM FACTURAS, LINEAS_FAC WHERE FACTURAS.CODFAC=LINEAS_FAC.CODFAC 
        AND (LINEAS_FAC.PRECIO * LINEAS_FAC.CANT) = (SELECT MAX(LINEAS_FAC.PRECIO * LINEAS_FAC.CANT)  
                FROM FACTURAS, LINEAS_FAC WHERE LINEAS_FAC.CODFAC = FACTURAS.CODFAC)


        SELECT F2.FECHA FROM LINEAS_FAC lf2 , FACTURAS f2 WHERE LF2.CODFAC = F2.CODFAC 
        GROUP BY F2.FECHA HAVING SUM(LF2.CANT*LF2.PRECIO)IN 
        (SELECT MAX(SUM(LF.CANT*LF.PRECIO)) FROM LINEAS_FAC lf , FACTURAS f 
        WHERE LF.CODFAC =F.CODFAC GROUP BY F.FECHA); 

        5. Número de pueblos en los que no tenemos clientes.
        SELECT COUNT(*) FROM PUEBLOS p WHERE P.CODPUE NOT IN (SELECT C.CODPUE FROM CLIENTES c); 

        6. Número de artículos cuyo stock supera las 20 unidades, con precio superior a 15 euros y de los 
        que no hay ninguna factura 
        en el último trimestre del año pasado.
        SELECT COUNT(*) FROM ARTICULOS a WHERE A.STOCK >20 AND A.PRECIO >15 AND A.CODART NOT IN 
        (SELECT LF.CODART FROM LINEAS_FAC lf , FACTURAS f 
        WHERE LF.CODFAC =F.CODFAC AND EXTRACT (MONTH FROM F.FECHA)>=10 
        AND EXTRACT  (YEAR FROM F.FECHA)= EXTRACT (YEAR FROM SYSDATE)-1);

        7. Obtener el número de clientes que en todas las facturas del año pasado han pagado IVA (no se ha 
                pagado IVA si es cero o nulo).
        SELECT COUNT(*) FROM FACTURAS f2 WHERE F2.CODCLI IN (SELECT F.CODCLI FROM FACTURAS f 
        WHERE F.IVA <>0 AND F.IVA IS NOT NULL AND EXTRACT (YEAR FROM F.FECHA)=EXTRACT (YEAR FROM SYSDATE)-1); 

        8. Clientes (código y nombre) que fueron preferentes durante el mes de noviembre del año pasado y 
        que en diciembre de ese mismo año no 
        tienen ninguna factura. Son clientes preferentes de un mes aquellos que han solicitado más de 60,50 
        euros en facturas durante ese 
        mes, sin tener en cuenta descuentos ni impuestos.
        SELECT c.CODCLI , c.NOMBRE FROM FACTURAS f , CLIENTES c WHERE f.CODCLI =c.CODCLI AND F.CODCLI 
        IN (SELECT F2.CODCLI FROM FACTURAS f2, LINEAS_FAC lf WHERE F2.CODFAC =LF.CODFAC AND EXTRACT(MONTH FROM F2.FECHA)=11 
        AND EXTRACT (YEAR FROM F2.FECHA)=EXTRACT(YEAR FROM SYSDATE)-1 HAVING SUM(LF.CANT*LF.PRECIO)>60.5 GROUP BY F2.CODCLI )
        AND f.CODCLI 
        IN (SELECT F3.CODCLI FROM FACTURAS f3, LINEAS_FAC lf3 WHERE F3.CODFAC =LF3.CODFAC AND EXTRACT(MONTH FROM F3.FECHA)=11 
        AND EXTRACT (YEAR FROM F3.FECHA)=EXTRACT(YEAR FROM SYSDATE)-1 HAVING SUM(LF3.CANT*LF3.PRECIO)>60.5 GROUP BY F3.CODCLI )

        9. Código, descripción y precio de los diez artículos más caros.
        SELECT A.CODART , A.DESCRIP , A.PRECIO FROM ARTICULOS a ORDER BY A.PRECIO DESC FETCH FIRST 10 ROWS ONLY; 

        10. Nombre de la provincia con mayor número de clientes.
        SELECT P.NOMBRE FROM PROVINCIAS p , PUEBLOS p2 , CLIENTES c 
        WHERE P.CODPRO =P2.CODPRO  AND  P2.CODPUE =C.CODPUE 
        GROUP BY P.CODPRO , P.NOMBRE HAVING COUNT(C.CODCLI)= 
        (SELECT MAX(COUNT(C2.CODCLI)) FROM CLIENTES c2, PUEBLOS p3, PROVINCIAS p4 
                WHERE C2.CODPUE=P3.CODPUE AND P3.CODPRO=P2.CODPRO GROUP BY P2.CODPRO); 

        11. Código y descripción de los artículos cuyo precio es mayor de 90,15 euros y se han vendido menos 
        de 10 unidades (o ninguna) durante el año pasado.
        SELECT DISTINCT a.CODART , a.DESCRIP FROM ARTICULOS a , LINEAS_FAC lf
        WHERE A.PRECIO >90.15 AND A.CODART IN 
        (SELECT LF.CODART FROM LINEAS_FAC lf2, FACTURAS f WHERE LF.CODFAC=F.CODFAC 
        AND EXTRACT(YEAR FROM F.FECHA)= EXTRACT(YEAR FROM SYSDATE)-1 HAVING SUM(LF.CANT)<10
        GROUP BY LF.CODART )

        12. Código y descripción de los artículos cuyo precio es más de tres mil veces mayor que el precio 
        mínimo de cualquier artículo.
        SELECT a.CODART , a.DESCRIP , a.PRECIO FROM ARTICULOS a WHERE A.PRECIO >
        (SELECT MIN(A2.PRECIO) FROM ARTICULOS a2)*3000;

        13. Nombre del cliente con mayor facturación.
        SELECT C.NOMBRE FROM CLIENTES c , LINEAS_FAC lf , FACTURAS f WHERE F.CODFAC = LF.CODFAC 
        AND C.CODCLI =F.CODCLI GROUP BY C.NOMBRE HAVING SUM(LF.CANT*LF.PRECIO)=
        (SELECT MAX(SUM(LF2.CANT*LF2.PRECIO)) FROM LINEAS_FAC lf2, FACTURAS f2 
        WHERE LF2.CODFAC=F2.CODFAC GROUP BY F2.CODCLI)

        14. Código y descripción de aquellos artículos con un precio superior a la media y que hayan sido 
        comprados por más de 5 clientes.
        SELECT DISTINCT A.CODART , A.DESCRIP , A.PRECIO FROM ARTICULOS a 
        WHERE A.PRECIO > (SELECT AVG(A2.PRECIO) FROM ARTICULOS a2) AND A.CODART 
        IN (SELECT LF.CODART FROM LINEAS_FAC lf HAVING COUNT(LF.CODART)<5 GROUP BY LF.CODART)