// 1.Crear  una  función  que  calcule  la  media  aritmética  de  cinco  valores  que  se  le  pasan  como argumentos.


const mediaAritmetrica = (num1, num2, num3, num4, num5) => {
let sumaNumeros=num1+ num2+ num3+ num4+ num5;


return(`La media aritmetrica de los numeros que has introducido es ${sumaNumeros/5}`);
};

//console.log(mediaAritmetrica(1,2,3,4,5));

// 2.Crea una función que acepta las notas de los tres trimestres de un alumno. Devolverá “aprobado” o “suspenso” en 
// función de si el promedio de las notas es igual o superior a 5 o no lo es. A continuación de ello, se mostrará cuándo 
// fue modificado por última vez el documento actual. 


const notaAlumno = (trim1, trim2, trim3) => {
    let promedio=(trim1+ trim2+ trim3)/3;
    let resultado;
    if(promedio>=5){
        resultado='Aprobado';
    }
    else{
        resultado='Suspenso';
    }
    
    return(`El alumno está ${resultado} con un promedio de ${promedio} y la ultima actualizacion fue ${document.lastModified}`);
    };

    //console.log(notaAlumno(4,5,6));


// 3.Crea un array de 15 elementos numéricos que el usuario irá introduciendo. Al final, se tiene que mostrar qué número 
// es el menor y en qué posición o posiciones del array está (no olvides que en el array la primera posición es la 0).  



// let lista=[];
// for(let i =0; lista.length<5; i++){
//     lista.push(parseInt(prompt('Introduce el numero '+ parseInt(i+1))));
// }

// let menor=Math.min(...lista);
// console.log('El numero menor es:' + menor + ' y se encuentra en la posicion ' + lista.indexOf(menor));









// 4.Crea un script que tome una serie de palabras ingresadas por el usuario y almacene esas palabras en un array. Posteriormente,
//  manipula ese array para mostrar una nueva ventana con los siguientes datos: 
//  La primera palabra ingresada por el usuario. 
//  La última palabra ingresada por el usuario.  
//  El número de palabras presentes en el array.  
//  Todas las palabras ordenadas alfabéticamente. 


const pedirPalabras=() =>{
 let palabra=prompt('Introduce una palabra, 0 para terminar');
 let contador=0;
 let listaPalabras=[];
 while(palabra!=0){
     contador++;
     listaPalabras.push(palabra);
     palabra=prompt('Introduce otra palabra, 0 para terminar');
 }
 console.log(`La primera palabra introducida ha sido ${listaPalabras[0]} \nLa útlima palabra introducida ha sido ${listaPalabras[listaPalabras.length-1]}
 \nHas introducido un total de ${contador} palabras \n
Las palabras ordenadas alfabeticamente son: ${listaPalabras.sort()}`);

}
//pedirPalabras();


// 5.Crea el objeto Coche con los atributos marca, modelo y anyo. Una vez definido el objeto, crea cuatro instancias del objeto 
// Coche y modifícalo para que los valores de cada una de sus propiedades se impriman en formato HTML( <table>). Utiliza la 
// generación de código HTML desde JavaScript. Cada instancia debe ocupar una línea (<tr>) y el valor de cada propiedad debe 
// ocupar una celda (<td>) de dicha línea. 

class Coche {
    constructor(marca, modelo, year){
        this.marca=marca;
        this.modelo=modelo;
        this.year=year;
    }

    getMarca(){
        return this.marca;
    }

}

const coche1 = new Coche("Citroen", "C4", 2007);
const coche2 = new Coche("Peugeot", "307", 2006);
const coche3 = new Coche("BMW", "X6", 2018);
const coche4 = new Coche("Audi", "A6", 2015);


document.getElementById("marca1").innerHTML=coche1.marca;
document.getElementById("modelo1").innerHTML=coche1.modelo;
document.getElementById("year1").innerHTML=coche1.year;

document.getElementById("marca2").innerHTML=coche2.marca;
document.getElementById("modelo2").innerHTML=coche2.modelo;
document.getElementById("year2").innerHTML=coche2.year;

document.getElementById("marca3").innerHTML=coche3.marca;
document.getElementById("modelo3").innerHTML=coche3.modelo;
document.getElementById("year3").innerHTML=coche3.year;

document.getElementById("marca4").innerHTML=coche4.marca;
document.getElementById("modelo4").innerHTML=coche4.modelo;
document.getElementById("year4").innerHTML=coche4.year;

// 6.Crea un script que defina un objeto llamado Producto_alimenticio. Este objeto debe presentar las propiedades código, 
// nombre y precio, además del método imprimeDatos, el cual escribe por pantalla los valores de sus propiedades. 
// Posteriormente, crea tres instancias de este objeto y guárdalas en un array. Utiliza el método imprimeDatos
//  para mostrar por pantalla el valor de los tres objetos instanciados. 

class ProductoAlimenticio {
    constructor(codigo, nombre, precio){
        this.codigo=codigo;
        this.nombre=nombre;
        this.precio=precio;
    }

    imprimeDatos(){
        return (`Código: ${this.codigo} || Nombre: ${this.nombre} || Precio: ${this.precio}`);
    }
}

producto1 = new ProductoAlimenticio(1, "Platano", 0.75);
producto2 = new ProductoAlimenticio(2, "Manzana", 1);
producto3 = new ProductoAlimenticio(3, "Pera", 1.5);

let listaProductos=[producto1, producto2, producto3];


for (i in listaProductos){
    console.log(listaProductos[i].imprimeDatos());
}

// 7.Crear un objeto usado para representar un artículo de una tienda. El artículo se va a caracterizar por una descripción,
//  un código y un precio, y debe permitir el cálculo de su correspondiente IVA.  
//  Habrá que crear el correspondiente formulario usando el objeto, con sus propiedades y métodos.  
//  La usará la siguiente nomenclatura: la función obj_articulo será el constructor del objeto mientras que las 
//  funciones iva() y total(reb) serán métodos para ese objeto. El argumento de la segunda indica un posible descuento.
//  Estas funciones serán simples operaciones aritméticas.  
//  En cuanto al constructor las propiedades (desc, codigo, valor) se pueden asignar directamente usando this para referirnos 
//  al propio objeto. Para los métodos se puede hacer igual pero asignándole funciones (iva, total).  
//  Una vez introducidos los datos en el formulario, el resultado será mostrar la descripción del artículo, su precio,
//   el iva y el precio de venta aplicando el descuento. Todo ello usando objetos. 

class Articulo {
    constructor(descripcion, codigo, precio){
        this.descripcion=descripcion;
        this.codigo=codigo;
        this.precio=precio;

    }

    calcularIva(){
        return(this.precio*0.21)
    }
}