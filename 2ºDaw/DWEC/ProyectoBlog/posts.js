let tabla = document.getElementById("tabla");

let peticion = new XMLHttpRequest();
peticion.open('GET', 'http://localhost:3000/posts');
peticion.send();
peticion.addEventListener('readystatechange', function() {
    console.log("Estado de la petición: " + peticion.readyState);
    if (peticion.readyState === 4) {
    if (peticion.status === 200) {
    console.log("Datos recibidos:");

    

    let usuarios = JSON.parse(peticion.responseText); // Convertirmos los datos JSON a un objeto
    let enlace ="";
    
    for(i = 0; i< usuarios.length; i++){
        enlace = "post.html?id="+(i+1);
        tabla.insertRow(-1).innerHTML = '<tr' + '<td>' + usuarios[i].title + '</td>' +
        '<td>' + usuarios[i].author + '</td></tr>' +
        '<td>' + '<a href="'+enlace+'">Ver</a></td></tr>'+
        '<td>' + '<a href="'+enlace+'">Borrar</a></td></tr>'  
        ;
       
    }
    
    console.log(usuarios);
    } else {
    console.log("Error " + peticion.status + " (" + peticion.statusText + ") en la petición");
    }
    }
    });

   