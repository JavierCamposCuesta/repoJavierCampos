// let nombre = prompt('Introduce tu nombre');
// let edad = parseInt(prompt('Introduce tu nombre'));
// console.log(`Hola ${nombre}, tienes ${edad} años y el año que viene tendras ${edad+1}`);



// let numero = parseInt(prompt('Introduce un numero'));
// for(i=0; i<numero;i++){
//     if(i%2==0){
//         console.log(`El numero ${i} es par`);
//     }
//     else{
//         console.log(`El numero ${i} es impar`);
//     }
// }



// let numero = parseInt(prompt('Introduce un numero'));
// let resultado=(`El numero ${numero} es primo`);
// for(i=2;i<numero-1; i++){
//     if(numero%i==0){
//         resultado=(`El numero ${numero} no es primo`);
//     }
// }
// console.log(resultado);



// let numeros=[2,3,45,8,9];
// let pares=[];
// let impares=[];

// for(i=0; i<numeros.length;i++){
//     let aleatorio=Math.round(Math.random()*9)+1;
//     let operacion = aleatorio*numeros[i];
//     if(operacion%2==0){
//         pares.push(operacion);
//     }
//     else{
//         impares.push(operacion);
//     }
// }
// console.log(numeros);
// console.log(pares);
// console.log(impares);



// const letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];

// let numero = prompt('Introduce el dni');

// if((numero+"").length>1 && (numero+"").length<9 && numero>0){
//     let modulo = numero%23;
//     let letra = letras[modulo];
//     console.log(`Tu dni es ${numero+letra}`)
// }
// else{
//     console.log("El numero es invalido");
// }


// let palabra = prompt('Introduce una palabra');
// let contadorVocales=0;
// let contadorConsonatentes=0;

// for(i=0;i<palabra.length;i++){
//    palabra=palabra.trim();
//    palabra=palabra.toLocaleLowerCase();
//     if(palabra[i]=='a' || palabra[i]=='e' || palabra[i]=='i' || palabra[i]=='o' || palabra[i]=='u'){
//         contadorVocales++;
//     }
//     else{
//         contadorConsonatentes++;
//     }
// }
// console.log(`vocales ${contadorVocales} consonantes ${contadorConsonatentes}`);



// class Coche{
//     constructor(marca, modelo, anyo){
//         this.marca=marca;
//         this.modelo=modelo;
//         this.anyo=anyo;
//     }

// }

// const coche1 = new Coche("Citroen", "corsa", 2009);
// const coche2 = new Coche("Peugeot", "307", 20010);
// const coche3 = new Coche("Onda", "civic", 2014);
// const coche4 = new Coche("Audi", "tt", 2020);

// let muestra = "<table><tr><td>Marca</td><td>Modelo</td><td>Año</td></tr></table>";
// muestra+="<tr><td>"+coche1.marca+"</td><td>"+coche1.modelo+"</td><td>"+coche1.anyo+"</td></tr><br>";
// muestra+="<tr><td>"+coche2.marca+"</td><td>"+coche2.modelo+"</td><td>"+coche2.anyo+"</td></tr><br>";
// muestra+="<tr><td>"+coche3.marca+"</td><td>"+coche3.modelo+"</td><td>"+coche3.anyo+"</td></tr><br>";
// muestra+="<tr><td>"+coche4.marca+"</td><td>"+coche4.modelo+"</td><td>"+coche4.anyo+"</td></tr><br>";

// document.writeln(muestra);

function Coche (marca, modelo, anyo){this.marca = marca;this.modelo = modelo;this.anyo = anyo;}//Instancias 
var coche1 =new Coche("Audi","A3","2016");var coche2 =new Coche("BMW","Serie 3","2010");var coche3 =new Coche("Chevrolet","Camaro","1975");var coche4 =new Coche("Dodge","Viper","2000");//Tabla
 var muestra ="<table><tr><th>Marca</th><th>Modelo</th><th>Año</th></tr>";     muestra +="<tr><td>"+ coche1.marca +"</td><td>"+ coche1.modelo +"</td><td>"+     coche1.anyo +"</td></tr>";muestra +="<tr><td>"+ coche2.marca +"</td><td>"+ coche2.modelo +"</td><td>"+     coche2.anyo +"</td></tr>";muestra +="<tr><td>"+ coche3.marca +"</td><td>"+ coche3.modelo +"</td><td>"+     coche3.anyo +"</td></tr>";muestra +="<tr><td>"+ coche4.marca +"</td><td>"+ coche4.modelo +"</td><td>"+     coche4.anyo +"</td></tr>";muestra +="</table>";//Escribir el resultado 
 document.writeln(muestra);