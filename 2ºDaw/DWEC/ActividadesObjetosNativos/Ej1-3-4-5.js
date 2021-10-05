// Actividad 1:  Crea un ejemplo de utilización del objeto window, tratando de mover y redimensionar la ventana de diferentes maneras. Prueba en 2 navegadores diferentes.
let nuevaVentana = document.getElementById("abrirVentana");
nuevaVentana.addEventListener("click", abrirNuevaVentana);

function abrirNuevaVentana(){
    window.open("http://127.0.0.1:5500/2%C2%BADaw/DWEC/ActividadesObjetosNativos/Ej1.html", "Ej1", "with=120, height=300");
    
}


let minimizar = document.getElementById("minimizar");
minimizar.addEventListener("click", fMinimizar);

function fMinimizar(){
    window.resizeTo(window.screen.availWidth / 2,
    window.screen.availHeight / 2)
};


let maximizar = document.getElementById("maximizar");
maximizar.addEventListener("click", fMaximizar);

function fMaximizar(){
    window.resizeTo(window.screen.availWidth,
    window.screen.availHeight)
};


let moverDerecha = document.getElementById("moverDerecha");
moverDerecha.addEventListener("click", ()=>{window.moveBy(300,0)});

let moverIzquierda = document.getElementById("moverIzquierda");
moverIzquierda.addEventListener("click", ()=>{window.moveBy(-300,0)});

let moverAbajo = document.getElementById("moverAbajo");
moverAbajo.addEventListener("click", ()=>{window.moveBy(0,300)});

let moverArriba = document.getElementById("moverArriba");
moverArriba.addEventListener("click", ()=>{window.moveBy(0,-300)});


//------------------------------------------------------------------------

// Actividad 3: Realiza un ejemplo donde obtengas toda la información posible del objeto location de forma ordenada. Utiliza los métodos del objeto location para modificar la url, comprobando la diferencia entre assign y replace, haz uso también del método reload.
console.log("El nombre del hast es: " + location.hast)
console.log("El nombre del host es: " + location.host)
console.log("El nombre del host name es: " + location.hostname)
console.log("La url es: " + location.href)
console.log("El pathname es: " + location.pathname)
console.log("El port es: " + location.port)
console.log("El protocol es: " + location.protocol)
console.log("El search es: " + location.search)

//Cambiamos de pagina con el assign y nos guarda en el historial la nueva y la antigua
//location.assign("https://www.google.com/search?q=imagen+png&sxsrf=AOaemvIFTkyqqRci2tdpUxJ1_AWNhMKOiQ:1633431201383&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjdxJe0jbPzAhVDhRoKHcbuDwcQ_AUoAXoECAEQAw&biw=1294&bih=696&dpr=1")

//Con replace cambiamos de pagina y nos elimina la antigua del historial
//location.replace("https://www.google.com/search?q=imagen+png&sxsrf=AOaemvIFTkyqqRci2tdpUxJ1_AWNhMKOiQ:1633431201383&source=lnms&tbm=isch&sa=X&ved=2ahUKEwjdxJe0jbPzAhVDhRoKHcbuDwcQ_AUoAXoECAEQAw&biw=1294&bih=696&dpr=1")

//Con reload recargamos la pagina, si el argumento es true se carga la pagina
//desde el servidor y si es false se carcha desde la cache
//location.reload(true);

//---------------------------------------------------------------

//Ejercicio 4 Actividad 4: A partir de la página proporcionada en las transparencias https://developer.mozilla.org/es/docs/Web/API/Navigator indica y prueba algunos métodos útiles del objeto navigator.

//Si nos vamos a la consola de la web podemos ir viendo el valor de cada atributo de navigator
console.log("El lenguaje es: " + navigator.language)

//--------------------------------------------------------------------

//Ej 5 Actividad 5: Revisa la documentación del objeto screen https://developer.mozilla.org/es/docs/Web/API/Screen y busca al menos 3 ejemplos útiles que puedas realizar con este objeto.

//Si nos vamos a la consola de la web podemos ir viendo el valor de cada atributo de screen
console.log("La altura en px de la ventana disponible es: " + screen.availHeight)
console.log("Retorna el total de espacio horizontal en pixels disponibles para la ventana. " + screen.availWidth)
