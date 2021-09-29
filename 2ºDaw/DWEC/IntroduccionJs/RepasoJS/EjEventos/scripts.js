let box = document.getElementById("box");
// Cuando el ratón entre dentro de la caja, se cambiará el color a verde.
box.addEventListener("mouseenter", ()=>{box.classList.replace("box", "boxGreen")});

// Cuando el ratón salga de la caja el color deberá cambiar a rojo.
box.addEventListener("mouseleave", ()=>{box.classList.replace("boxGreen", "box")});

// Cuando pulsemos el botón izquierdo del ratón estando situados sobre la caja, 
// aparecerá por consola el mensaje “Has pulsado la caja.
box.addEventListener("mousedown", ()=>{console.log("Has pulsado la caja")});

// Al soltar el botón izquierdo del ratón en la caja, aparecerá por consola el mensaje 
// ”Has soltado el botón izquierdo dentro de la caja”.
box.addEventListener("mouseup", ()=>{console.log("Has soltado el botón izquierdo dentro de la caja")});


// Ejercicio2
let input = document.getElementById("input");

// Al pulsar una tecla deberá aparecer el mensaje por consola “Has pulsado una 
// tecla”

input.addEventListener("keydown", ()=>{console.log("Has pulsado una tecla")});

// Al soltar la tecla deberá aparecer el mensaje por consola “Has soltado una 
// tecla”
input.addEventListener("keyup", ()=>{console.log("Has soltado una tecla")});

//Al pulsar una tecla mostrara el mensaje "Has pulsado la tecla + el nombre de la tecla"
input.addEventListener("keydown", teclaPulsada);
function teclaPulsada ( valor){
    let teclaPresionada = valor.key;
    console.log("Has pulsado la tecla = "+  teclaPresionada);
}

//Al soltar una tecla mostrara el mensaje "Has pulsado la tecla + el nombre de la tecla"
input.addEventListener("keyup", teclaPulsada);
function teclaPulsada ( valor){
    let teclaPresionada = valor.key;
    console.log("Has soltado la tecla = "+  teclaPresionada);
}


// //Crea un formulario con un input de tipo texto y un botón “Enviar”. Al pulsar el 
// botón. Crea un evento para que al soltar una tecla se lance una función que vaya 
// mostrando por consola todo lo que se escribe en el input
let texto = document.getElementById("texto");
let boton = document.getElementById("boton");
boton.addEventListener("click", mostrarPorConsola);
texto.addEventListener("keyup", teclasPulsada);

function mostrarPorConsola(){
    console.log(texto.value);
}

function teclasPulsada(valor){
    let teclaPresionada = valor.key;
    console.log(teclaPresionada);
}