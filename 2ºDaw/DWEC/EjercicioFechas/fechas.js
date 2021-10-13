//1. Un campo que nos permite seleccionar la fecha y hora y la muestra a continuación. 
//La salida deberá tener elsiguiente formato:
//Hoy es martes, 28 de Febrero de 2018 y son las 14:32 horas.

let fecha1 = document.getElementById("fecha1");
let hora1 = document.getElementById("hora1");

let listaSemana= ['Domingo', 'Lunes', 'Martes', 'Miercoles', 'Jueves', 'Viernes', 'Sábado'];
let listaMes = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre','Octubre','Noviembre','Diciembre'];


function obtenerDatos(){
    let fechaIntroducida = new Date(fecha1.value);
    let year = fechaIntroducida.getFullYear();
    let mes = listaMes[fechaIntroducida.getMonth()];
    let diaSemana = listaSemana[fechaIntroducida.getDay()];
    let diaNumero = fechaIntroducida.getDate();

    let solucion1 = document.getElementById("solucion1");
    solucion1.innerText="Hoy es "+diaSemana+", " + diaNumero + " de " + mes + " y son las " + hora1.value;
}


fecha1.addEventListener("change", obtenerDatos);
hora1.addEventListener("change", obtenerDatos);



// 2. A continuación dos campos para introducir un mes y un año e imprima su calendario. No hace falta esmerarse en 
//la presentación del calendario, el calendario simplificado puede ser del tipo:

// OCTUBRE – 2014
// 1 (miercoles), 2 (jueves), ….. , 31 (viernes).

let listaMes2 = ['', 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre','Octubre','Noviembre','Diciembre'];
let mes2 = document.getElementById("mes2");
let year2= document.getElementById("year2");

function obtenerDatos2(){
    let fechaIntroducida2 = new Date( year2.value, mes2.value);
    let mesString2 = listaMes2[fechaIntroducida2.getMonth()];
    let yearString2 = fechaIntroducida2.getFullYear();

    let solucion2 = document.getElementById("solucion2");
    solucion2.innerHTML=mesString2 + " - " + yearString2; 
    
    let calendario="";
    let solucion22=document.getElementById("solucion2-2");
    

    //la funcion getUTCDate() nos da el numero de dias de un mes en una fecha
    for (let index = 1; index < fechaIntroducida2.getUTCDate(); index++) {
        calendario+=index+ "( " + listaSemana[new Date(year2.value, mes2.value, index).getDay()] + " ), " ;
        
    }
    solucion22.innerHTML= calendario;
}

obtenerDatos2();
year2.addEventListener("change", obtenerDatos2);
mes2.addEventListener("change", obtenerDatos2);


// 3. Un campo que nos permita introducir una fecha y otro que nos permita introducir los días de retraso en el pago, 
// una ves introducidos nos devolverá la fecha del pago.


let fecha3 = document.getElementById("fecha3");
let diasDemora3 = document.getElementById("diasDemora3");

function calcularNuevaFecha(){
    let fechaIntroducida3 = new Date(fecha3.value);

    let dias = fechaIntroducida3.getDate();
    let mes= fechaIntroducida3.getMonth();
    let year = fechaIntroducida3.getFullYear();

    console.log(mes)

    let nuevaFecha = new Date(year, mes, (dias+parseInt(diasDemora3.value)) );
    let solucion3 = document.getElementById("solucion3");
    solucion3.innerHTML="La nueva fecha de pago es: " + nuevaFecha.getDate()+" / " + listaMes[nuevaFecha.getMonth()] +" / " + nuevaFecha.getFullYear();
}

fecha3.addEventListener("change", calcularNuevaFecha);
diasDemora3.addEventListener("change", calcularNuevaFecha);



//4. Un cronómetro con el siguiente formato:
//Hoy es 30-9-2019 y son las 21:4:23 horas.

function cronometro(){
    let solucion4 = document.getElementById("solucion4");

    let fechaActual = new Date();


    solucion4.innerHTML = "Hoy es " + fechaActual.getDate() +" / " + (fechaActual.getMonth()+1) + " / " + fechaActual.getFullYear() + 
    " y son las " + fechaActual.getHours() + " : " + fechaActual.getMinutes() + " : " + fechaActual.getSeconds();
}
window.setInterval(cronometro, 1000);


// 5. Una alarma que mostrará la hora actual y nos permite indicar la hora a la que sonará, cuando llegue a 
// la hora, pregunta si se quiere posponer o detener, si se pospone "sonará" a los 2 minutos. 
// EXTRA: haz que suene un sonido además de mostrar el mensaje.

let hora5 = document.getElementById("hora5");

hora5.addEventListener(
    "focusout",
    () => { calcularTiempo(false); }
);

let add2min = document.getElementById("add2min");
add2min.addEventListener("click", ()=> calcularTiempo(120000)); // 120000ms = 2min

let add10seg = document.getElementById("add10seg");
add10seg.addEventListener("click", ()=> calcularTiempo(10000)); // 10000 = 10 segundos

function mostrarAlerta(){
    alert("El tiempo ha terminado!!");
}


 
function calcularTiempo(tiempoAnadido){ 
    let fechaActual = new Date();
    let horaIntroducida = hora5.value.split(":");
    let fechaIntroducida5 = new Date(fechaActual.getFullYear(), fechaActual.getMonth(), fechaActual.getDate());
    fechaIntroducida5.setHours(horaIntroducida[0], horaIntroducida[1]);
    
    // Cuando no queremos añadir tiempo extra lo calculamos
    if (tiempoAnadido === false) {
        tiempoCronometro = (fechaIntroducida5-fechaActual);
    // Cuando queremos añadir tiempo extra
    } else {
        tiempoCronometro = tiempoAnadido;
    }

    const alarma = setTimeout(()=>{
        playAudio();
        mostrarAlerta();

    }, parseInt(tiempoCronometro));
    
}



//Seleccionamos el audio que va a sonar
let sonido;

let gallo = document.getElementById("gallo");
let cobra = document.getElementById("cobra");
gallo.addEventListener("change", ()=>{sonido="gallo"});
cobra.addEventListener("change", ()=>{sonido="cobra"});

var x;
function playAudio() { 
    switch (sonido) {
        case 'gallo': x = document.getElementById("sonido-gallo"); break;
        case 'cobra': x = document.getElementById("sonido-cobra"); break;
        default: x = document.getElementById("sonido-mujer");
    }
    x.play(); 

} 

//Este evento es para parar la musica
let stopMusica = document.getElementById("stopMusica");
stopMusica.addEventListener("click", ()=>{x.pause()})



