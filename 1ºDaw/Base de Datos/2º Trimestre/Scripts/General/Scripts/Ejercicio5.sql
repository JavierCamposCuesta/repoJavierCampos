       
       
    1. Vamos a crear una nueva tabla en la que tengamos el nombre del cliente y todo lo gastado por cada cliente,
     por lo que vamos a crear la tabla y rellenarlas con los datos adecuados.
    CREATE TABLE GASTO_CLIENTE AS(
SELECT C.NOMBRE , SUM(LF.CANT*LF.PRECIO) AS TOTAL_GASTADO FROM CLIENTES c , FACTURAS f , LINEAS_FAC lf 
WHERE C.CODCLI=F.CODCLI AND F.CODFAC=LF.CODFAC GROUP BY C.NOMBRE) 

    2. Vamos a borrar la tabla anterior, y rellenar los datos, pero sólo para aquellos clientes que hayan tenido tres 
    o más facturas.
    DROP TABLE GASTO_CLIENTE;
    
    CREATE TABLE GASTO_CLIENTE AS(
    SELECT C.NOMBRE , SUM(LF.CANT*LF.PRECIO) AS TOTAL_GASTADO FROM CLIENTES c , FACTURAS f , LINEAS_FAC lf 
    WHERE C.CODCLI=F.CODCLI AND F.CODFAC=LF.CODFAC HAVING COUNT(F.CODFAC)>3 GROUP BY C.NOMBRE) 
       
    3. Vamos a añadir en provincias un nuevo campo en el que guardaremos el número de pueblos que tiene cada provincia, 
    Rellena el nuevo campo de la tabla
       
    ALTER TABLE PROVINCIAS ADD NUMERO_PUEBLOS NUMBER(3);

    UPDATE PROVINCIAS P1 SET NUMERO_PUEBLOS =(SELECT COUNT(P.CODPRO) AS NUM_PUEBLOS
    FROM PUEBLOS p , PROVINCIAS p2 WHERE P.CODPRO=P2.CODPRO AND P1.CODPRO=P2.CODPRO
    GROUP BY P2.CODPRO)
   
    4. Borra los artículos que no se han vendido nunca.
     DELETE FROM ARTICULOS a WHERE CODART NOT IN (SELECT DISTINCT LF.CODART FROM LINEAS_FAC lf)   


    5. Añade dos campos a  facturas, en el que se guardará el total de la factura, y el total con iva (recuerda que 
        antes de calcular el iva hay que calcularle el descuento) de cada factura. Estos campos no podrán tener valores 
    nulos. Rellena los campos con los valores que tenemos en la base de datos.
    
    ALTER TABLE FACTURAS ADD BASE NUMBER(6);
    ALTER TABLE FACTURAS ADD TOTAL NUMBER(6);   
    
    UPDATE FACTURAS F2 SET F2.BASE = (SELECT SUM(LF.CANT*LF.PRECIO) AS BASE FROM FACTURAS f, LINEAS_FAC lf WHERE F.CODFAC=LF.CODFAC
    AND F.CODFAC = F2.CODFAC GROUP BY LF.CODFAC );

    UPDATE FACTURAS F1 SET F1.TOTAL =(SELECT(F2.BASE -NVL(F2.DTO,0))*((NVL(F2.IVA,0)/100)+1) AS TOTAL
    FROM FACTURAS F2 WHERE F2.CODFAC =F1.CODFAC );

    6. Añade un nuevo campo en la tabla clientes, que se llame código que no acepte valores nulos, y rellena el 
    campo de forma que almacene la primera letra del nombre, la letra de en medio del nombre, y la última letra del nombre.
     Si el nombre tiene un número par de letras se tomará la siguiente, y si es impar justo la de en medio.
       
    7. Vamos a añadir en pueblos un nuevo campo en el que guardaremos el número de clientes que tiene cada pueblo. 
    Rellena el nuevo campo de la tabla con los valores apropiados.
       
    8. Borra las provincias que no tengan pueblos, pero sin usar el nuevo campo que hemos añadido anteriormente.
       
    9. Vamos a modificar los nombres de los clientes para que salgan bien, es decir nombre y apellido, 
    en vez de “apellido,nombre”.

    10. Crea una nueva tabla en la que almacenaremos la descripción del artículo y el precio de venta. 
    Rellena esos datos para aquellos artículos que sólo se han vendido con un precio igual al de venta.
       
    11. Añade un nuevo campo en facturas, en el que se almacenará el número total de artículos que se han 
    vendido en la factura.
       
    12. Añade un nuevo campo en lineas_fac en donde se almacenará el valor total de esa línea
       
    13. Añade un nuevo campo en la tabla artículo en el que se deberá poner un 0 si el artículo no se ha vendido nunca,
     un 1 si el artículo alguna vez se ha vendido con un precio inferior al  de venta actual, y un dos si el artículo se 
     ha vendido con un precio igual al de venta actual.
       
    14. Crea una nueva tabla en la que almacenaremos la descripción del artículo y el precio de venta. Rellena esos 
    datos para aquellos artículos que se han vendido con un precio igual al de venta, al menos tres veces.
Rellena todos los campos y tablas que has tenido que crear con los valores adecuados, y realiza los ejercicios 
con el número mínimo posible de sentencias sql.