<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Anuncios de coches</title>
</head>
<body>
	<h1>Modelos disponibles</h1>
	<form action="Anuncio.jsp" method="get">
		<div>
		<label>Indique la marca</label>
        <input type="text" id="nombre" name="marca">
		</div>
		<div>
		<label>Indique el modelo</label>
        <input type="text" id="modelo" name="modelo">
		</div>
		<div>
		<label>Indique los kilometros</label>
        <input type="number" id="kilometros" name="kilometros">
		</div>
		<div>
		<label>Indique el precio</label>
        <input type="number" id="precio" name="precio">
		</div>
		<div>
		<label>Indique el color</label>
        <input type="text" id="color" name="color">
		</div>
	</form>
<a href="Anuncio.jsp">Ir al anuncio</a>
</body>
</html>