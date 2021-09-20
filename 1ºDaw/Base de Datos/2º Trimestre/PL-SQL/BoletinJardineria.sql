
-- Boletín Jardinería
-- 1. Mostrar ‘Hola mundo’ por pantalla.

BEGIN
	 DBMS_OUTPUT.PUT_LINE ('Hola Mundo');
END;
/

-- 2. Declarar una variable numéricay mostrar si es mayor de 10 o no.
declare numero number;
BEGIN
	 numero := 2;
	 if numero>10 then
	     DBMS_OUTPUT.PUT_LINE ('El numero '|| numero ||' es mayor que 10');
	elsif numero <10 then
	     DBMS_OUTPUT.PUT_LINE ('El numero ' || numero ||' es menor que 10');

	else
        DBMS_OUTPUT.PUT_LINE ('El numero ' || numero ||' es igual que 10');
    end if;
END;
/
-- 3. Declarar una variable numéricay pedir su valor y mostrarlo.
CREATE OR REPLACE PROCEDURE DUMMY.valorIntroducido() is
valor number(4) := &valor;
begin
    DBMS_OUTPUT.PUT_LINE(valor);
end;

call valorIntroducido();

-- 4. Mostrar los númerosdel 1 al 100 con un while.
declare
    i number:=1;
begin
    while i<=100
    loop
        DBMS_OUTPUT.PUT_LINE (i);
        i:=i+1;
     end loop;

end;

-- 5. Mostrar los numeros del 1 al 100 con un for.

begin
    for i in 1..100
    loop
        DBMS_OUTPUT.PUT_LINE (i);
     end loop;

end;

-- 6. Mostrar los númerosdel 1 al 100 con un loop.

declare
  i number(8) := 1;
begin

  loop
    DBMS_OUTPUT.PUT_LINE(i);
    exit when i=100;
    i := i+1;
  end loop;

end;
/

-- 7. Mostrar el nombre de un cliente dado su código.
create or replace procedure nombreCliente (codigo number) is
    nombre varchar2(100);
begin
    
    select NOMBRECLIENTE into nombre from CLIENTES where CLIENTES.CODIGOCLIENTE = codigo;
    DBMS_OUTPUT.PUT_LINE (nombre);
end;

call nombreCliente(1);

-- 8. Mostrar el precioVenta y la gama de un producto dado su código.
create or replace procedure precioVenta_Gama (codigo varchar2) is
    precio number(6);
    gama1 varchar2(100);
begin

    select PRECIOVENTA, GAMA into precio, gama1 from PRODUCTOS where PRODUCTOS.CODIGOPRODUCTO = codigo;
    DBMS_OUTPUT.PUT_LINE ('El precio del producto es: '|| precio || ' y la gama es: ' || gama1);
end;

call precioVenta_Gama('30310');

-- 9.  Mostrar  toda  la  informacion  de  un  pedido  dado  su código(fechaEsperada, fechaEntrega, fechapedido, estado, comentarios)
create or replace procedure detallesPedido (codigo varchar2) is
    fechaEsperada1 date;
    fechaEntrega1 date;
    estado1 varchar2(50);
    comentarios1 varchar2(50);
begin

    select FECHAESPERADA, FECHAENTREGA, ESTADO, COMENTARIOS into fechaEsperada1, fechaEntrega1, estado1, comentarios1 
    from PEDIDOS where PEDIDOS.CODIGOPEDIDO = codigo;
    DBMS_OUTPUT.PUT_LINE ('La fecha esperada es: ' || fechaEsperada1 || ' , la fecha de entrega: ' 
    || fechaEntrega1 || ' ,  el estado: ' || estado1 || ' , los comentarios: ' || comentarios1);
end;

call detallesPedido(1);

-- 10. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el códigopor parámetro.
create or replace function sumaPagos(codigo number) return number is
total number(6);
begin
    select sum(CANTIDAD) into total from PAGOS where pagos.CODIGOCLIENTE=codigo;
    return total;
end;

select sumaPagos(1) from dual;

-- 11.  Realizar  un  método  o  procedimiento  que  muestre  el  total  en euros de un pedido, pásaleel códigopor parámetro.
create or replace  procedure totalPedido(codigo number) is
total number(5);
    begin
        select sum(CANTIDAD * PRECIOUNIDAD) into total from DETALLEPEDIDOS where DETALLEPEDIDOS.CODIGOPEDIDO=codigo;
            DBMS_OUTPUT.PUT_LINE ('El total del pedido es: ' || total);

    end;

call TOTALPEDIDO(2);

-- 12. Mostrar el nombre de un cliente dado su código. Controla en caso de que no se encuentre, mostrando un mensaje,por ejemplo.
create or replace  procedure nombreCliente(codigo number) is
nombre varchar2(50):='';
maximo number(6);
minimo number(6);

codigoNoValido Exception ;

    begin
        select max(CODIGOCLIENTE) into maximo from CLIENTES;
        select min(CODIGOCLIENTE) into minimo from CLIENTES;

        if codigo >maximo or codigo < minimo then
             raise codigoNoValido;
        else
            select NOMBRECLIENTE into nombre from CLIENTES where CLIENTES.CODIGOCLIENTE=codigo;
            DBMS_OUTPUT.PUT_LINE (nombre);
        end if;
    Exception
        WHEN codigoNoValido then
        DBMS_OUTPUT.PUT_LINE ('El codigo no pertenece a ningún cliente');

    end;

    call nombreCliente(1);
    call nombreCliente(50);

-- 13. Realizar una función que me devuelva la suma de pagos que ha realizado. Pasa el codigo por parametro. Controla en caso de que 
-- no se encuentre, en ese caso devuelve un -1.
create or replace function sumaPagos(codigo number) return number is
suma NUMBER(6):=0;

codigoNoValido Exception ;

    begin
       
        select sum(CANTIDAD) into suma from PAGOS where PAGOS.CODIGOCLIENTE=codigo;
        if suma is null then
             raise codigoNoValido;
        end if;


    RETURN SUMA;
        Exception
        WHEN codigoNoValido then
        suma:= -1;
        return suma;



    end;


select SUMAPAGOS(1) from dual;

-----------------------

create or replace procedure totalPagos1(cod number) is
total pagos.cantidad%type;
    begin
        select sum(cantidad) into total from PAGOS where CODIGOCLIENTE=cod;
        DBMS_OUTPUT.PUT_LINE(total);

        EXCEPTION
        when no_data_found then
        DBMS_OUTPUT.PUT_LINE(-1);
    end;

-- 14.  Realizar  un  método  o  procedimiento  que  muestre  el  total  en euros de un pedido, pásaleel códigopor parámetro. 
-- Controla en caso de que no se encuentre, en ese caso devuelve un 0. Pásaleotro parámetro,  si  supera  ese  limite,  lanzaremos  
-- una excepciónpropia y devolveremos un 0.&
CREATE OR REPLACE PROCEDURE TOTALSUMAPEDIDO(CODIGO NUMBER, LIMITE NUMBER) IS
    RESULTADO NUMBER;
    MAXIMO NUMBER;
    MINIMO NUMBER;

    SUPERADO_LIMITE EXCEPTION;

    BEGIN
        SELECT MAX(CODIGOCLIENTE), min(CODIGOCLIENTE)  INTO MAXIMO, MINIMO FROM PAGOS;

        IF CODIGO<MINIMO OR CODIGO>MAXIMO THEN
            RESULTADO:=0;
            ELSE



SELECT SUM(CANTIDAD*DETALLEPEDIDOS.PRECIOUNIDAD) INTO RESULTADO FROM DETALLEPEDIDOS
WHERE CODIGOPEDIDO=CODIGO;

END IF;

IF RESULTADO<LIMITE THEN

    DBMS_OUTPUT.PUT_LINE('LA SUMA ES '|| RESULTADO);



ELSE
    RAISE SUPERADO_LIMITE;


END IF;

EXCEPTION
    WHEN SUPERADO_LIMITE THEN
      DBMS_OUTPUT.PUT_LINE ('HAS SUPERADO EL LIMITE-ERROR');


END;



CALL TOTALSUMAPEDIDO(1,10000);


15. Crea una función a la que le pasaremos como parámetros de entrada:  MATRICULA,  NUEVO_PRECIO_COMPRA.  la  función modificara 
los datos del coche que tenga la matricula introducida actualizando el precio_compra de la siguiente forma:
-Si   precio_compra  es   nulo   hacer   un   update   en   el   campo precio_compra asignándole el valor de nuevo_precio_compra
-Si no hacer un update en el campo precio_compra asignándole el valor de precio_compra+(precio_compra-nuevo_precio_compra).
La  función  devolverá  el  numero  de  filas  actualizadas  crea  un bloque  anónimo  que  ejecute  la  función  anterior  y  muestre  
el resultado devuelto por la función.

create or replace function modificarPrecioCompra(matricula) return number is

create or replace function nuevoPrecioCoche (
      v_matricula COCHE.MATRICULA%type,
      v_nuevoPrecio COCHE.PRECIOCOMPRA%type)
return number
as
  v_nuevoPrecio COCHE.PRECIOCOMPRA%type;
begin

  select PRECIOCOMPRA into v_nuevoPrecio
  from coche where matricula = v_matricula;

  if v_nuevoPrecio is null then
    update coche
    set PRECIOCOMPRA = v_nuevoPrecio
    where matricula = v_matricula;
  else
    update coche
    set PRECIOCOMPRA = PRECIOCOMPRA+(PRECIOCOMPRA-v_nuevoPrecio)
    where matricula = v_matricula;
  end if;

  return SQL%ROWCOUNT;

end;
/
-- 16.   Crea   procedimiento   que   reciba   como   parámetros   de entrada:P_ID_MARCA,P_NUMERO_COCHES.  Utiliza  un  bucle para 
-- insertar N registros nuevos en la tabla COCHE. El numero de registros    a    insertar    viene    indicado    por    el    
-- parámetro P_NUMEROS_COCHES(CONTADOR) y el bucle empezará en 1, los datos a insertar serán:
-- -matricula=’A00’||CONTADOR
-- -DESCRIPCION=p_id_marca-id_marca=p_id_marca
-- -precio_compra=nulo
-- Controlar excepción para cuando exista algún coche en la BBDD y se viole la pk.


-- 17.Crea un procedimiento al que le pasaremos el dni_cliente y la matricula. El procedimiento deberá controlar en las ventas de 
-- los coches(tabla vende) los siguientes supuestos:-.Si no existe un registro con ese dni_cliente y esa matricula saltara a la 
-- zona de excepciones y mostrara un mensaje “no existe la venta introducida”–Si existe la venta introducida:
-- I. mostrara el precio antiguo ||II. actualizara el precio subiendo 1000 eurosIII.devolverá     en     un     parámetro     
-- de     salida     del procedimiento(ps_nuevo_precio)   el   precio   nuevo   tras   la actualización   crea   un   bloque  
--  anónimo   que   llame   al procedimiento  anterior  y  muestre  el  precio  nuevo  devuelto por el procedimiento.
-- 18. Crear un cursor para ver todos los clientes que no hayan hecho pagos. Hazlo con un loop.
-- 19. Crear un cursor para ver todos los clientes que no hayan hecho pagos. Hazlo con un for.
