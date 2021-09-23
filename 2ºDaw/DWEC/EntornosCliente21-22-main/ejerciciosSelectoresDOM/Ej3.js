document.getElementById("boton").addEventListener("click", colorear);
function colorear(){
    
    let fila =parseInt( document.getElementById("fila").value);
    let columna = parseInt( document.getElementById("columna").value);
    
    let selector = `tr:nth-child(${fila}) td:nth-child(${columna})`;
    console.log(selector+"hoihgf");
    let filaPintar = document.querySelector(selector);
}