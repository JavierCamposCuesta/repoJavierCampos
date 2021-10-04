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

