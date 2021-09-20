





function addElemento(){
    let listaCompleta = document.getElementById("listaCompra");
    let inputUsuario=document.getElementById("inputUsuario");
    let inputNuevoElemento = document.createTextNode(inputUsuario.value);
    let nuevoElemento = document.createElement("li");

    nuevoElemento.appendChild(inputNuevoElemento);
    listaCompleta.appendChild(nuevoElemento);

}



function eliminarElemento(){
    let listaCompleta = document.getElementById('listaCompra');
    let elemento = listaCompleta.childNodes[0];
    listaCompleta.removeChild(elemento);
}
