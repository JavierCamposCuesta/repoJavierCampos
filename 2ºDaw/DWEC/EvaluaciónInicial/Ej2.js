let add = document.getElementById("add");
let borrar = document.getElementById("delete");
let modify = document.getElementById("modify");

//Añadimos al titulo el numero de empleados
let contador = parseInt(document.querySelectorAll("tr").length-1);
let titulo = "Número de empleados: ";
document.querySelector("h1").innerHTML = titulo + " "+contador;

let tabla = document.getElementById("tabla");

add.addEventListener("click", addEmpleado);

borrar.addEventListener("click", borrarEmpleado);

modify.addEventListener("click", modificarEmpleado);




function addEmpleado(){
    let nombre = document.getElementById("nombre").value;
    let dni = document.getElementById("dni").value;
    let apellidos = document.getElementById("apellidos").value;

    //Lo pongo aqui para que se incremente cada vez que ejecute la funcion
    let contador = document.querySelectorAll("tr").length;
    
    let esIgual = false;
    let index = 0;
    while ( index < contador && esIgual==false) {
        //Para que funcione debemos utilizar innerText en vez de textContent
        if (dni === document.getElementsByTagName("tr")[index].getElementsByTagName("td")[1].innerText) {
            esIgual = true;
        }
        index++;
        
    }
    if (esIgual == false) {
        
    //Creamos los nuevos elementos
        let nuevaFila = document.createElement("tr");
        let nuevoContador = document.createElement("td");
        let nuevoDNI = document.createElement("td");
        let nuevoNombre = document.createElement("td");
        let nuevoApellido = document.createElement("td");

    //Insertamos las columnas en la fila    
        nuevaFila.appendChild(nuevoContador);
        nuevaFila.appendChild(nuevoDNI);
        nuevaFila.appendChild(nuevoNombre);
        nuevaFila.appendChild(nuevoApellido);

    //Damos valor a cada columna    
        nuevoContador.innerHTML =contador;
        nuevoDNI.innerHTML=dni;
        nuevoNombre.innerHTML= nombre;
        nuevoApellido.innerHTML= apellidos;

    //Insertamos la nueva fila en la tabla
        tabla.appendChild(nuevaFila);

    //Actualizamos el titulo con el número de empleados
    let titulo = "Número de empleados: ";
        document.querySelector("h1").innerHTML = titulo + contador;
    }
    else{
        alert("Empleado repetido");
    }
}


    //Borrar empleado
    function borrarEmpleado(){
        let nombre = document.getElementById("nombre").value;
    let dni = document.getElementById("dni").value;
    let apellidos = document.getElementById("apellidos").value;
        let contador1 = document.querySelectorAll("tr").length;

        let esIgual = false;
        let index = 0;
    while ( index < contador1 && esIgual==false) {
        //Para que funcione debemos utilizar innerText en vez de textContent
        if (dni === document.getElementsByTagName("tr")[index].getElementsByTagName("td")[1].innerText) {
            esIgual = true;

            //De esta forma no consigo que borre la fila
            //let nuevaFila = document.getElementsByTagName("tr")[index];

            //Busco la fila que quiero borrar por la posicion
            tabla.deleteRow(index);

            //Hacemos este while para corregir el numero de empleado cuando borramos alguno del principio
            document.querySelector("h1").innerHTML = titulo + (document.querySelectorAll("tr").length-1);
            while(index < contador1){
                let nuevoNumero = document.getElementsByTagName("tr")[index].getElementsByTagName("td")[0];
                nuevoNumero.innerHTML=(index);
                index++;
                //console.log("fin while");
            }

         //Actualizamos el titulo con el número de empleados
        

        }
        index++;
        
    }
    if (esIgual == false) {
        alert("Empleado no existe");
    }
}


    //Modificar empleado

    function modificarEmpleado(){
        let nombre = document.getElementById("nombre").value;
        let dni = document.getElementById("dni").value;
        let apellidos = document.getElementById("apellidos").value;
        let contador = document.querySelectorAll("tr").length;

        let esIgual = false;
        let index = 0
        while ( index < contador && esIgual==false) {
            //Para que funcione debemos utilizar innerText en vez de textContent
            if (dni === document.getElementsByTagName("tr")[index].getElementsByTagName("td")[1].innerText) {
                esIgual = true;
    
                let nuevoNombre = document.getElementsByTagName("tr")[index].getElementsByTagName("td")[2];
                let nuevoApellido = document.getElementsByTagName("tr")[index].getElementsByTagName("td")[3];
    
                //Busco la fila que quiero modificar por la posicion
                nuevoNombre.innerHTML = nombre;
                nuevoApellido.innerHTML = apellidos;
            }
            index++;
            
        }
        if (esIgual == false) {
            alert("Empleado no existe");
        }

    }
    