Ejercicios:
    1. Descuento medio aplicado en las facturas.
    SELECT AVG(DTO) FROM FACTURAS f ;
   
    2. Descuento medio aplicado en las facturas sin considerar los valores nulos.
    SELECT AVG(DTO) FROM FACTURAS WHERE DTO IS NOT NULL  ;
   
    3. Descuento medio aplicado en las facturas considerando los valores nulos 
    como cero.
    SELECT AVG(NVL(DTO,0)) FROM FACTURAS   ;
    
    4. Número de facturas.
    SELECT COUNT(*) FROM FACTURAS   ;
    
    5. Número de pueblos de la Comunidad de Valencia.
    SELECT COUNT(*) FROM PROVINCIAS  , PUEBLOS   WHERE PROVINCIAS.NOMBRE = 'VALENCIA' AND PROVINCIAS.CODPRO =PUEBLOS.CODPRO  ;
    
    6. Importe total de los artículos que tenemos en el almacén. 
    Este importe se calcula sumando el producto de las unidades en 
    stock por el precio de cada unidad
     SELECT SUM(PRECIO*STOCK) FROM ARTICULOS a  ;  
    
    7. Número de pueblos en los que residen clientes cuyo código postal
     empieza por ‘12’.
    SELECT COUNT(DISTINCT CODPUE) FROM  PUEBLOS p , CLIENTES c WHERE P.CODPUE = C.CODPUE AND C.CODPOSTAL LIKE ('12%'); 
    
    8. Valores máximo y mínimo del stock de los artículos cuyo precio
     oscila entre 9 y 12 € y diferencia entre ambos valores
     SELECT MAX(STOCK), MIN(STOCK), MAX(STOCK)-MIN(STOCK) FROM ARTICULOS a   WHERE A.PRECIO >=9 AND A.PRECIO <=12;

    9. Precio medio de los artículos cuyo stock supera las 10 unidades.
    SELECT AVG(PRECIO) FROM ARTICULOS a WHERE STOCK >10; 

    10. Fecha de la primera y la última factura del cliente con código 210.

    SELECT MIN(FECHA), MAX(FECHA) FROM FACTURAS WHERE CODCLI=210;

    11. Número de artículos cuyo stock es nulo.
    SELECT COUNT(*) FROM ARTICULOS a WHERE STOCK IS NULL; 

    12. Número de líneas cuyo descuento es nulo (con un decimal)
    SELECT TRUNC(COUNT(*), 1)  FROM LINEAS_FAC lf WHERE DTO IS NULL;

    13. Obtener cuántas facturas tiene cada clientCOe.
    SELECT COUNT(CODFAC), C.NOMBRE FROM FACTURAS f  , CLIENTES c WHERE F.CODCLI =C.CODCLI GROUP BY C.NOMBRE
    
    14. Obtener cuántas facturas tiene cada cliente, pero sólo si tiene dos o más  
    acturas.
    SELECT COUNT(f.CODFAC) AS CONTADOR, C.NOMBRE FROM FACTURAS f  , CLIENTES c WHERE F.CODCLI =C.CODCLI GROUP BY C.NOMBRE HAVING COUNT(f.CODFAC)>=2 ;
   
    
    15. Importe de la facturación (suma del producto de la cantidad por el precio 
        de las líneas de factura) de los  artículos
    SELECT SUM(a.STOCK*lf.PRECIO) FROM ARTICULOS a , LINEAS_FAC lf 

    16. Importe de la facturación (suma del producto de la cantidad por el precio 
        de las líneas de factura) de aquellos artículos cuyo código contiene la letra “A” 
    (bien mayúscula o minúscula).
    SELECT SUM(a.STOCK*lf.PRECIO) FROM ARTICULOS a , LINEAS_FAC lf WHERE UPPER(a.DESCRIP)  LIKE ('%A%');
    
    17. Número de facturas para cada fecha, junto con la fecha
    SELECT COUNT(CODFAC) , FECHA FROM FACTURAS f GROUP BY f.FECHA 

    18. Obtener el número de clientes del pueblo junto con el nombre del pueblo 
    mostrando primero los pueblos que más clientes tengan.
    SELECT COUNT(c2.NOMBRE) AS NUM_CLIENTE, p.NOMBRE FROM CLIENTES c2 , PUEBLOS p WHERE c2.CODPUE = p.CODPUE GROUP BY p.NOMBRE ORDER BY NUM_CLIENTE DESC;

    19. Obtener el número de clientes del pueblo junto con el nombre del 
    pueblo mostrando primero los pueblos que más clientes tengan, 
    siempre y cuando tengan más de dos clientes.
    SELECT COUNT(c2.NOMBRE) AS CONTADOR , p.NOMBRE FROM CLIENTES c2 , PUEBLOS p WHERE c2.CODPUE = p.CODPUE  GROUP BY p.NOMBRE HAVING COUNT(c2.NOMBRE)>=2 ORDER BY CONTADOR DESC    

    20. Cantidades totales vendidas para cada artículo cuyo código 
    empieza por “P, mostrando también la descripción de dicho artículo.
    SELECT COUNT(CODART) , DESCRIP FROM ARTICULOS a WHERE DESCRIP LIKE ('P%') GROUP BY DESCRIP 

    21.-	Precio máximo y precio mínimo de venta (en líneas de facturas) 
    para cada artículo cuyo código empieza por “c”.
    SELECT MAX(lf.PRECIO), MIN(lf.PRECIO) FROM LINEAS_FAC lf WHERE   lf.CODART LIKE ('C%') GROUP BY CODFAC 
    22. Igual que el anterior pero mostrando también la diferencia entre 
    el precio máximo y mínimo.
    SELECT MAX(lf.PRECIO), MIN(lf.PRECIO),  MAX(lf.PRECIO)- MIN(lf.PRECIO) FROM LINEAS_FAC lf WHERE   lf.CODART LIKE ('C%') GROUP BY CODFAC 

    23. Nombre de aquellos artículos de los que se ha facturado más de 
    10000 euros.
    SELECT a.DESCRIP FROM ARTICULOS a , LINEAS_FAC lf WHERE lf.CANT * (lf.PRECIO-lf.DTO)>=10000 AND a.CODART = lf.CODART 

    24. Número de facturas de cada uno de los clientes cuyo código está 
    entre 150 y 300 (se debe mostrar este código), con cada IVA distinto que se les ha aplicado.
    SELECT DISTINCT f2.CODFAC , c.CODCLI ,  f2.IVA FROM FACTURAS f2 , CLIENTES c WHERE f2.CODCLI =c.CODCLI  AND c.CODCLI >=150 AND c.CODCLI <=300 GROUP BY CODCLI, IVA;
    
    25. Media del importe de las facturas, sin tener en cuenta impuestos 
    ni descuentos.
    SELECT AVG(CANT*PRECIO) FROM LINEAS_FAC lf 