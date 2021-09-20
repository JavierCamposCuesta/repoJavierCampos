let enlace = document.getElementsByTagName("a");
for(i=0; i<document.getElementsByTagName("a").length;i++){
    enlace[i].addEventListener("click", modificarEnlace);
}





function modificarEnlace(event){
let enlace=event.currentTarget;
parrafo=enlace.parentElement.getElementsByTagName(enlace);


if(parrafo.hidden){
    parrafo.hidden=false;
    enlace.textContent("Ocultar contenido");
}
else{
    parrafo.hidden=true;
    enlace.textContent("Mostrar contenido");
}
}