/*
let cadena = 'Hola Mundo';
let letra='i';
console.log(cadena.length);
console.log(cadena.toUpperCase());
console.log(cadena.toLowerCase());
console.log(cadena.indexOf('o'));
console.log(cadena.indexOf('Hola'));
console.log(cadena.replace('Mundo', 'Youtube'))
console.log(cadena.slice(-5));
console.log(cadena.substring(5));
console.log(cadena.startsWith('h'));
console.log(cadena.startsWith('H'));
console.log(letra.repeat(10));

let nombre='Javier';
let apellido='Campos';
let edad=22;

console.log(`Hola ${nombre} ${apellido}. Tienes ${edad} años.`);


//Ejercicion math
/*Genera un número aleatorio entre 0 y 100 redondeando y muéstralo por consola
•Muestra por consola el valor de PI.
•Genera un número aleatorio entre 5 y 10 redondeando y muéstralo por consola. 
    Para este caso lo recomendado es utilizar la fórmula (Math.random()* (max-min)+min).
•Comprueba como funciona el método sign() para los siguientes valores: -5, 0, 5 
*/

/*
console.log(Math.round(Math.random()*100));
console.log(Math.PI);
console.log(Math.round(Math.random()*(10-5)+5));
console.log(Math.sign(-5));
console.log(Math.sign(5));
console.log(Math.sign(0));

//Condicionales
/*
EJERCICIO 1
•Declara una variable que se llame nume inicialízala a cero.
•Utilizando condicionales deberás comprobar si el valor de la variable numes mayor que cero, menor que cero o igual a cero.
 En cada uno de los casos deberás mostrar un mensaje utilizando TEMPLATE STRING mostrando el valor de la variable nume 
 indicando si es mayor, menor o igual a cero
*/
/*
let num=0;
if(num==0){
    console.log(`El numero es ${num} es igual a 0`);
}
else if(num>0){
    console.log(`El numero es ${num} es mayor que 0`);
}
else{
    console.log(`El numero es ${num} es menor que 0`);
}

/*
EJERCICIO 2
•Declara dos variables una con valor 5 y otra con valor 1.
•Utilizando operadores lógicos && o || utilizada el adecuado para mostrar el mensaje de que ambos valores son mayores 
que cero
*/
/*
let num1=5;
let num2=1;
if(num1>0 && num2>0){
    console.log(`Los numero  ${num1} y ${num2} son mayores que 0`);
}
else{
    console.log(`Los numero  ${num1} y ${num2} no son mayores que 0`);
}
*/

// EJERCICIO 3
// •Dada una cadena, se mostrará un mensaje en el caso de que tenga mas de 4 letras, otro mensaje en el caso de que tenga 
// menos de 4 letras y otro mensaje en el caso de tener 4 letras.


// let cadena1=prompt('Introduce una cadena');
// if(cadena1.length==4){
//     console.log(`La cadena  ${cadena1} tiene 4 letras`);
// }
// else if(cadena1.length>4){
//     console.log(`La cadena  ${cadena1} tiene mas de 4 letras`);
// }
// else{
//     console.log(`La cadena  ${cadena1} tiene menos de 4 letras`);
// }


// EJERCICIO 4
// •Ordena 3 números de mayor a menor.
// •Los números se introducirán por teclado. Para ello es necesario utilizar promptpara que pregunte los números.
// •Muestra por consola los números ordenados de mayor a menor.


// let numero1=prompt('Introduce el primer numero');
// let numero2=prompt('Introduce el segundo numero');
// let numero3=prompt('Introduce el tercer numero');
// let mayor;



// if(numero1>numero2&& numero1>numero3){
// mayor=numero1;
//     if(numero2>numero3){
//         console.log(numero1+", "+numero2+", "+numero3);
//     }
//     else if(numero3>numero2){
//         console.log(numero1+", "+numero3+", "+numero2);
//     }
// }
// else if(numero2>numero1&& numero2>numero3){
//     mayor=numero2;
//     if(numero1>numero3){
//         console.log(numero2+", "+numero1+", "+numero3);
//     }
//     else if(numero3>=numero2){
//         console.log(numero2+", "+numero3+", "+numero1);
//     }
//     }
// else if(numero3>numero1&& numero3>numero2){
//     mayor=numero3;
//     if(numero2>numero1){
//         console.log(numero3+", "+numero2+", "+numero1);
//     }
//     else if(numero1>=numero2){
//         console.log(numero3+", "+numero1+", "+numero2);
//     }
    
//     }
// else{
//     if(numero1==numero2){
//         console.log(numero1+", "+numero2+", "+numero3);
//     }
//     else if(numero1==3){
//         console.log(numero1+", "+numero3+", "+numero2);
//     }
//     else{
//         console.log(numero3+", "+numero2+", "+numero1);
//     }
// }


// //Ejercicio5 


// let numero1=document.getElementById('div1').textContent;

// let numero2=document.getElementById('div2').textContent;

// let numero3=document.getElementById('div3').textContent;
// let mayor;



// if(numero1>numero2&& numero1>numero3){
// mayor=numero1;
//     if(numero2>numero3){
//         document.getElementById('resultado').innerHTML=(`${numero1}, ${numero2} , ${numero3}`);
//     }
//     else if(numero3>numero2){
//         document.getElementById('resultado').innerHTML=(numero1+", "+numero3+", "+numero2);
//     }
// }
// else if(numero2>numero1&& numero2>numero3){
//     mayor=numero2;
//     if(numero1>numero3){
//         document.getElementById('resultado').innerHTML=(numero2+", "+numero1+", "+numero3);
//     }
//     else if(numero3>=numero2){
//         document.getElementById('resultado').innerHTML=(numero2+", "+numero3+", "+numero1);
//     }
//     }
// else if(numero3>numero1&& numero3>numero2){
//     mayor=numero3;
//     if(numero2>numero1){
//         document.getElementById('resultado').innerHTML=(numero3+", "+numero2+", "+numero1);
//     }
//     else if(numero1>=numero2){
//         document.getElementById('resultado').innerHTML=(numero3+", "+numero1+", "+numero2);
//     }
    
//     }
// else{
//     if(numero1==numero2){
//         document.getElementById('resultado').innerHTML=(numero1+", "+numero2+", "+numero3);
//     }
//     else if(numero1==3){
//         document.getElementById('resultado').innerHTML=(numero1+", "+numero3+", "+numero2);
//     }
//     else{
//         document.getElementById('resultado').innerHTML=(numero3+", "+numero2+", "+numero1);
//     }
// }
// document.getElementById

//SWITCH ---------------------------------------------------------------------


// Realizar un programa que pida un numero entre 0 y 10 y te devuelva suspenso si está entre 1 y4, suficiente = 5, bien=6
// 7 y 8 notable, 9 y 10 sobresaliente

// let numero=prompt('Introduce la nota');
// numero=parseInt(numero);

// let resultado;
// switch (numero) {
//     case 1, 2, 3, 4:
//         resultado='Suspenso';
//         break;
//     case 5:
//         resultado='Suficiente';
//         break;
//     case 6:
//         resultado='Bien';
//         break;
//     case 7, 8:
//         resultado='Notable';
//         break;
//     case 9, 10:
//         resultado='Sobresaliente';
//         break;
   
// }
// console.log(resultado);


// let edad=prompt('Introduce tu edad');
// edad=parseInt(edad);

// let resultado;
// switch (true) {
//     case edad>=0 && edad<=12:
//         resultado='Enano';
//         break;
//     case edad<18:
//         resultado='Disfruta ahora que puedes';
//         break;
//     case edad==18:
//         resultado='A partir de ahora puedes ir a la cárcel';
//         break;
//     case edad <=35:
//         resultado=' Casi pureta';
//         break;
//     case edad<=65:
//         resultado='Los últimos años buenos';
//         break;
//     case edad>65:
//     resultado='De mal en peor';
//     break;
   
// }
// console.log(resultado);


//OPERADOR TERNARIO ------------------------------------------------------------


// Con el operador ternario mostrar si un número es par o impar

// let numero=prompt('Introduce un numero');
// numero=parseInt(numero);

// let respuesta = numero%2==0 ? 'El numero es par' : 'El numero es impar';
// console.log(respuesta);


//INTRODUCCION A OBJETOS ----------------------------------------------------------

// Crea un objeto persona. Persona está compuesto por un campo nombre, edad, hijos. Hijos
// será un array con los siguientes valores “Batman”, “Ironman”, “Yoda”, “Hulk”.

// const persona = {
//     nombre: 'Javier',
//     edad: 23,
//     hijos: ['Batman', 'Ironman', 'Yoda', 'Hulk']
// }

// //Muestra por consola todos los nombres de los hijos.
// for (let i = 0; i <persona.hijos.length; i++) {
//    console.log(persona.hijos[i]);
     
//  }

//  //Usando Template String muestra por consola el siguiente mensaje: “Hola nombre. Tienes XX
// //años y tus hijos se llaman XXXX,XXXXX,XXXXX,XXXXXX
// console.log(`Hola ${persona.nombre} . Tienes ${persona.edad} años y tus hijos se llaman ${persona.hijos}`);


//INTRODUCCION A FUNCIONES -------------------------------------------------------------

//Crea una función saludar que imprima por pantalla el texto “Hola desde una función”. Crea
//un bucle que llame 5 veces a la función saludar.

// const saludar = () => {
//     return'Hola desde una funcion';
// }

// for (let i = 0; i <5; i++) {
//        console.log( saludar());
// }


// //Crea una función saludarUsuario que reciba como parámetro el nombre de un usuario e
// //imprima por pantalla el texto “Hola XXXXXXX desde una función”.

// let nombre = prompt('Introduce tu nombre');
// const saludarUsuario= (nombre) =>{
//     return (`Hola ${nombre} desde una funcion`);
// }
// console.log(saludarUsuario(nombre));

// Crea una función suma que reciba 2 parámetros (num1,num2). Si num1 es igual a 3,
// realizara la suma de num1 y num2 y devolverá el resultado. En caso contrario devolverá el
// valor de num1.

// const suma=(num1, num2)=>{
//     let resultado;
//     if (num1==3) {
//         resultado=num1+num2;
//     }
//     else{
//         resultado=num1;
//     }
//     return resultado;
// }

// console.log(suma(3, 5));



//INTRODUCCION A CLASES --------------------------------------------------------------------------------------


// Crea una clase Libro.
// • La clase libro tendrá título, autor, año y género.
// • Crea un método que devuelva toda la información del libro.
// • Pide 3 libros y guárdalos en un array. Los libros se introducirán al arrancar el
// programa pidiendo los datos con prompt.
// • Validar que los campos no se introduzcan vacíos.
// • Validar que el año sea un número y que tenga 4 dígitos.
// • Validar que el género sea: aventuras, terror o fantasía.
// • Crea una función que muestre todos los libros.
// • Crea una función que muestre los autores ordenados alfabéticamente.
// • Crea una función que pida un género y muestre la información de los libros que
// pertenezcan a ese género usando el método que devuelve la información.


class Libro{
    constructor(titulo, autor, year, genero){
        this.titulo=titulo;
        this.autor=autor;
        this.year=year;
        this.genero=genero;
    }

    getAutor(){
        return this.autor;
    }

    getGenero(){
        return this.genero;
    }
    
    mostrarInformacion(){
        return (`Titulo: ${this.titulo} , autor: ${this.autor} , año: ${this.year} , genero:  ${this.genero}`);
    }
}

const pedirTitulo=()=>{
    let fin = true;
    let titulo="";
    while(fin){
        titulo= prompt('Introduce el titulo');
        if(titulo!=null && titulo!=""){
            fin=false;
        }
        else{
            console.log('No puede ser nulo y estar vacio');
        }
    }
    return titulo;
}

const pedirAutor=()=>{
    let fin = true;
    let autor="";
    while(fin){
        autor= prompt('Introduce el autor');
        if(autor!=null && autor!=""){
            fin=false;
        }
        else{
            console.log('No puede ser nulo y estar vacio');
        }
    }
    return autor;
}

const pedirYear=()=>{
    let fin = true;
    let year="";
    while(fin){
        year= prompt('Introduce el año');
        if(year!=null && year!="" && year.length==4 && year== parseInt(year)){
            fin=false;
        }
        else{
            console.log('Tiene que ser un numero de cuatro digitos');
        }
    }
    return year;
}

const pedirGenero=()=>{
    let fin = true;
    let genero="";
    console.log('El genero tiene que ser: aventuras, terror o fantasia ');
    while(fin){
        genero= prompt('Introduce el genero');
        if(genero=='aventuras' || genero=='terror' || genero=='fantasia'){
            fin=false;
        }
        else{
            console.log('El genero tiene que ser: aventuras, terror o fantasia');
        }
    }
    return genero;
}

const libro1 = new Libro(pedirTitulo(), pedirAutor(), pedirYear(), pedirGenero());
const libro2 = new Libro(pedirTitulo(), pedirAutor(), pedirYear(), pedirGenero());
const libro3 = new Libro(pedirTitulo(), pedirAutor(), pedirYear(), pedirGenero());
let listaLibros = [libro1, libro2, libro3];


const autoresOrdenados=() =>{
    let listaAutores=[libro1.autor, libro2.autor, libro3.autor];
    return listaAutores.sort();
}

const librosPorGenero=()=>{
    let genero = prompt('Introduce un genero');
    let resultado;
    for(const Libro of listaLibros){
        if(Libro.getGenero=genero){
            resultado=resultado+ '\n' + Libro.mostrarInformacion();
        }
    }
    
    
    return resultado;
}


console.log(listaLibros);
console.log(autoresOrdenados());
console.log(librosPorGenero());