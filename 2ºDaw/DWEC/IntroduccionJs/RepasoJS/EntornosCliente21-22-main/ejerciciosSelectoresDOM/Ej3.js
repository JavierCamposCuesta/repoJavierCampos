document.getElementById("boton").addEventListener("click", colorear);

function colorear(){
    let fila =parseInt( document.getElementById("fila").value);
    let columna = parseInt( document.getElementById("columna").value);
    
    let selectorFila = document.getElementsByTagName("tr")[fila-1];
    let selectorColumna = selectorFila.getElementsByTagName("td")[columna-1];
    
    selectorColumna.classList.add("color")
    
}