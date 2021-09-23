document.getElementById("enlace").addEventListener("click", mostrarTexto);
function mostrarTexto(){
    let modificar = document.querySelector("span.oculto");
    modificar.classList.replace("oculto", "visible");

    let ocultar = document.getElementById("enlace");
    ocultar.classList.add("oculto");
}