let aplicar = document.getElementById("aplicar");
aplicar.addEventListener("click", aplicarCambios);

function aplicarCambios(){
    let posicion = document.getElementById("posicion");
    let equipo = document.getElementById("equipo");
    let puntos = document.getElementById("puntos");

    let tabla = document.getElementById("tabla");

    let viejoNodo = tabla.getElementsByTagName("td")[posicion];
    let nuevoNodo = tabla.getElementsByTagName("tr");
    nuevoNodo.appendChild(document.createTextNode("dsdsfdsf"));
    tabla.replaceChild(viejoNodo, nuevoNodo);
    
    
}