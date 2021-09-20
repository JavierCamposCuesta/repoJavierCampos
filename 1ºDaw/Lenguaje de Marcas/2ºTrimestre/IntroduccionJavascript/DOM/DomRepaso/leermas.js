let enlace = document.getElementById('enlace1');
enlace.addEventListener("click", modificarEnlace);

function modificarEnlace(){
    let textoOculto = document.getElementById("texto");
    textoOculto.classList.replace('oculto', 'visible');

    let enlace = document.getElementById("enlace1");
    enlace.classList.add('oculto');

}