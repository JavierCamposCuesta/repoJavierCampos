//2.-Crea  una  página  web  que  tenga  un  listado  de  tipo  <ul>  con  un  <li>  de  
//     muestra.Introduce  un  botón  en  la  página  que,  cuando  lo  pulses,  te  muestre  
//     un  prompt  para  que  el usuario introduzca un texto.Una  vez  cerrado  el  prompt  
//     el  valor  se  añadirá  como  un  nuevo  <li>  a  la  lista  creada.Añade  dos  
//     botones  más  con  texto  “Borrar  primer  li”  y  “Borrar  último  li”  de  modo  
//     que  cuando pulses  el  primer  botón  borre  el  primer  elemento  de  la  lista  
//     y  cuando  pulses  el  último  borre  el último elemento de la lista.

let addElemento1 = document.getElementById("addElemento");
addElemento1.addEventListener("click", addElemento);

let borrarPrimero = document.getElementById("borrarPrimero");
borrarPrimero.addEventListener("click", borrarPrimerElemento);

let borrarUltimo = document.getElementById("borrarUltimo");
borrarUltimo.addEventListener("click", borrarUltimoElemento);

let addElementoPosicion = document.getElementById("posicion");
addElementoPosicion.addEventListener("click", addElementoPosicion1);



function addElemento(){
    let texto = prompt('Introduce el nuevo elemento');
    let posicion = prompt('Introduce la posicion');
    
    let lista = document.getElementById("lista");
    let nuevoItem = document.createElement("li");
    let nuevoTexto = document.createTextNode(texto);
    nuevoItem.appendChild(nuevoTexto);
    
    
    if(posicion === "" || posicion > lista.getElementsByTagName("li").length){
        lista.appendChild(nuevoItem);
    }

    else{
        lista.insertBefore(nuevoItem, lista.getElementsByTagName("li")[posicion-1]);
    }

    // else 
    // creamos el elemento en la posicion
    // elementoPosicion = lista coge el elemento de la posicion con lista.getElementsByTagName
    //  lista.insertBefore(elementoNuevo, elementoPosicion) ist.insertBefore(newItem, list.childNodes[2-1]);
}



function borrarPrimerElemento(){
    let lista= document.getElementById("lista");
    let primerElemento=lista.getElementsByTagName("li")[0];
    lista.removeChild(primerElemento);
}

function borrarUltimoElemento(){
    let lista= document.getElementById("lista");
    let sizeLista = lista.getElementsByTagName("li").length;
    let ultimoElemento=lista.getElementsByTagName("li")[sizeLista-1];
    lista.removeChild(ultimoElemento);
}