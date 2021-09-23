

document.getElementById("add").addEventListener("click", functionAdd);

document.getElementById("delete").addEventListener("click", functionDelete);



let elemento = document.getElementById("nuevoElemento").value;
let posicion = parseInt(document.getElementById("posicionElemento").value);

function functionAdd(){

    // Otra forma

//     let lista = document.getElementById("lista");
//     let nuevoItem = document.createElement("li");
//    let liPosicion = document.getElementsByTagName("li")[posicion-1];

//    nuevoItem.innerHTML=elemento;
//    lista.insertBefore(nuevoItem, liPosicion);

let lista = document.getElementById("lista");
let nuevoItem = document.createElement("li");
let nuevoTexto = document.createTextNode(elemento);
nuevoItem.appendChild(nuevoTexto);


if(posicion === "" || posicion > lista.getElementsByTagName("li").length){
    lista.appendChild(nuevoItem);
}

else{
    lista.insertBefore(nuevoItem, lista.getElementsByTagName("li")[posicion-1]);
}
   
}


 function functionDelete(){
    let lista = document.getElementById("lista");
    lista.removeChild(document.getElementsByTagName("li")[posicion-1]);
document.querySelector
  }


