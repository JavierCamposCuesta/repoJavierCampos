let elemento = document.getElementById("btnmod");
elemento.addEventListener("click", addElemento);

function addElemento(){
    let numero = prompt('Introduce un numero');
    let lista = document.getElementsByTagName("ol")[0];

//Si el numero no es correcto le mandaremos un mensaje
    if(numero === "" || numero > lista.getElementsByTagName("li").length){
        alert("El numero no corresponde con ninguna posicion");
    }

//Si el numero es correcto cambiaremos el dato de la posicion que se introduzca por el nuevo dato
    else{
    
        datoIntroducido=document.getElementById("modifica");
        textoIntroducido=datoIntroducido.value;

        let modificar=document.getElementsByTagName("li")[numero-1];

        modificar.textContent=textoIntroducido;
    
        
    }
}


    let enlace = document.getElementById('uno');
    enlace.addEventListener("click", modificarEnlace);

    let enlace2 = document.getElementById('dos');
    enlace2.addEventListener("click", modificarEnlace2);

    let enlace3 = document.getElementById('tres');
    enlace3.addEventListener("click", modificarEnlace3);

    let enlace4 = document.getElementById('cuatro');
    enlace4.addEventListener("click", modificarEnlace4);

    let enlace5 = document.getElementById('cinco');
    enlace5.addEventListener("click", modificarEnlace5);


    function modificarEnlace(){
        let enlaceCambiar = document.getElementById('uno');
        if(enlaceCambiar.classList.contains('done')){
            enlaceCambiar.classList.remove('done');
        }
        else{
            enlaceCambiar.classList.add('done');

        }
    
    }

    function modificarEnlace2(){
        let enlaceCambiar = document.getElementById('dos');
        if(enlaceCambiar.classList.contains('done')){
            enlaceCambiar.classList.remove('done');
        }
        else{
            enlaceCambiar.classList.add('done');

        }
    
    }

    function modificarEnlace3(){
        let enlaceCambiar = document.getElementById('tres');
        if(enlaceCambiar.classList.contains('done')){
            enlaceCambiar.classList.remove('done');
        }
        else{
            enlaceCambiar.classList.add('done');

        }
    
    }

    function modificarEnlace4(){
        let enlaceCambiar = document.getElementById('cuatro');
        if(enlaceCambiar.classList.contains('done')){
            enlaceCambiar.classList.remove('done');
        }
        else{
            enlaceCambiar.classList.add('done');

        }
    
    }

    function modificarEnlace5(){
        let enlaceCambiar = document.getElementById('cinco');
        if(enlaceCambiar.classList.contains('done')){
            enlaceCambiar.classList.remove('done');
        }
        else{
            enlaceCambiar.classList.add('done');

        }
    
    }

   
    
