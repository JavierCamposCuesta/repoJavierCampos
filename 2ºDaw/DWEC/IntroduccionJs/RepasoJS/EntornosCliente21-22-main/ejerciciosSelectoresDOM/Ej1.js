let numeroEnlaces = document.querySelectorAll("a").length;

document.write("El numero de enlaces es "+numeroEnlaces+"<br>");

let penultimoEnlace= document.querySelectorAll("a")[numeroEnlaces-2].getAttribute("tppabs");
document.write("El penultimo enlace es "+penultimoEnlace+"<br>");

let tercerPunto = document.querySelectorAll('a[tppabs="http://prueba/"').length;
document.write("El numero de enlace a  http://prueba/ es "+tercerPunto+"<br>");

let cuartoPunto = document.querySelectorAll('p:nth-child(3) a').length;
document.write("El numero de enlace del tercer parrafo es  "+cuartoPunto+"<br>");

