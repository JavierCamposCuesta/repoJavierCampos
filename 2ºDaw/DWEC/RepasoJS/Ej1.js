let aplicar=document.getElementById("aplicar");
aplicar.addEventListener("click", aplicarCambios);

function aplicarCambios(){
    let equipo = document.getElementById("equipo").value;
    let posicion = document.getElementById("posicion").value;
    let puntos = document.getElementById("puntos").value;

    let tabla = document.getElementById("tabla");



    
   let fila= tabla.getElementsByTagName("tr")[posicion];
   let colum1= fila.getElementsByTagName("td")[1];
   let colum2= fila.getElementsByTagName("td")[2];

   colum1.innerHTML=equipo;
   colum2.innerHTML=puntos;




}