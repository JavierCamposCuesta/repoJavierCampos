//Ejercicio 1

// let nombre=prompt('Introduce tu nombre');
// let edad=prompt('Introduce tu edad');
// edad=parseInt(edad);
// console.log(`Hola ${nombre} , tienes ${edad} años y el año que viene tendrás ${edad +1} `);


//Ejercicio 2

// console.log('1. Triangulo \n2. Rectángulo \n3.Círculo');
// let opcion=prompt('1. Triangulo \n2. Rectángulo \n3.Círculo \n ¿De que figura quiere calcular el area?');
// if (opcion==1){
// console.log('La superficie del triangulo es : '+prompt('Introduce la base')* (prompt('Introduce la altura')/2));
// }
// else if (opcion==2){
//     console.log('La superficie del cuadrado es: ' + prompt('Introduce la base')* prompt('Introduce la altura'));
// }
// else if (opcion==3){
//     console.log('La superficie del circulo es: '+((prompt('Introduce el radio')**2)*Math.PI));
// }
// else{
//     console.log('La opcion introducida no es correcta');
// }



//Ejercicio 3
/*
let numero=prompt('Introduce un número');
for (let i = 0; i <= numero; i++) {
if(i%2==0){
    console.log(i+ ' es par');
}
else{
    console.log(i+ ' es impar');
}
}
*/



//Ejercicio 4

// let numero=prompt('Introduce un número entero mayor que 1');
// numero=parseInt(numero);
// let esPrimo=true;
// if(numero>1){
//     for (let i = 2; i < numero; i++) {
//        if (numero%i==0) {
//            esPrimo=false;
//        }
        
//     }
//     if (esPrimo==true) {
//         console.log('El numero '+numero +' es primo');
//     }
//     else{
//         console.log('El numero '+numero +' no es primo');
//     }
// }
// else{
//     console.log('El numero no es valido');
// }




//Ejercicio 5
/*
let numero=prompt('Introduce un número entero mayor que 0');
numero=parseInt(numero);

let factorial=1;

if(numero>0){
    for (let i = 1; i <= numero; i++) {
       factorial=factorial*i;
        
    }
    console.log(factorial);
}
else{
    console.log('El numero no es valido');
}
*/



//Ejercicio 6

// let contadorNumeros=0;
// contadorNumeros=parseInt(contadorNumeros);
// let sumaNumeros=0;
// sumaNumeros=parseInt(sumaNumeros);
// while (sumaNumeros<50) {
//     let numero=prompt('Introduce un número');
//     numero=parseInt(numero);
//     contadorNumeros++;
//     sumaNumeros+=numero;
// }
// console.log(`Has introducido un total de ${contadorNumeros} numeros y su suma es de ${sumaNumeros}`);




//7 -Crea  3  arrays.  El  primero tendrá5  números  y  el  segundo  se llamará pares y el tercero impares, 
// ambos estarán vacíos. Después multiplica  cada  uno  de  los  números  del  primer  array  por  un número 
// aleatorio entre 1 y 10, si el resultado es par guarda ese número en el array de pares y si es impar en el 
// array de impares. Muestra por consola:
// -la multiplicación que se produce junto con su resultado con el formato 2 x 3 = 6
// -el array de pares e impares

// let numeros=[16, 24, 3, 15, 37];
// let pares=[];
// let impares=[];
// let operacion;
// let numAleatorio;
// for (let i =0; i< numeros.length; i++){
//     numAleatorio=Math.round(Math.random()*9)+1;
//     operacion=(numeros[i]*numAleatorio);
//     if(operacion%2==0){
//         pares.push(operacion);
//         console.log(numeros[i] + ' x '+ numAleatorio +' = '+operacion);
//     }
//     else{
//         impares.push(operacion);
//         console.log(numeros[i] + ' x '+ numAleatorio +' = '+operacion);
//     }
// }
// console.log(impares);
// console.log(pares);


// 8	- Dado	un	array	de	letras,	solicita	un	número	de	DNI	y	calcula	
// que	 letra	 le	 corresponde.	 El	 número	 no	 puede	 ser	 negativo	 ni	
// tener	más	de	8	dígitos.	La	posición	de	la	letra	es	el	resultado	del	
// módulo	del	número	introducido	entre	23.
// const	letras	=	['T',	'R',	'W',	'A',	'G',	'M',	'Y',	'F',	'P',	'D',	'X',	'B',	'N',	'J',	
// 'Z',	'S',	'Q',	'V',	'H',	'L',	'C',	'K',	'E',	'T'];


// letras	=	['T',	'R',	'W',	'A',	'G',	'M',	'Y',	'F',	'P',	'D',	'X',	'B',	'N',	'J',	
// 'Z',	'S',	'Q',	'V',	'H',	'L',	'C',	'K',	'E',	'T'];
// numero = prompt('Introduce los numeros del dni para conocer su letra');
// if((numero+"").length>8 || (numero+"").length<=1){
//     console.log('El numero tiene que ser mayor que 0 y menor que 8');
// }
// else{
//     let resultado=numero%23;
//     let dni= numero+letras[resultado];
//     console.log(dni);
// }



// 9	 - Solicitar	 al	 usuario	 una	 palabra	 y	 mostrar	 por	 consola	 el	
// número	de	consonantes,	vocales	y	longitud	de	la	palabra.


// let palabra;
// 	palabra=prompt("Introduce palabra")
// 	palabra=palabra.toLowerCase().trim();
// 	let sumaVocal=0;
// 	let sumaConsonante=0;
// 	for (let i in palabra){

// 		if( palabra[i]=='a' || palabra[i]=='e' || palabra[i]=='i' || palabra[i]=='o' || palabra[i]=='u'){
			
// 			sumaVocal++;
// 		}else{
// 			sumaConsonante++;
// 		}
// 	}


// 	console.log(`La longitud de la plabra es ${palabra.length}, contiene ${sumaVocal} vocales y ${sumaConsonante} consonantes`);



// 10	 - Dado	 un	 array	 que	 contiene	 ["azul",	 "amarillo",	 "rojo",	
// "verde",	"rosa"]	determinar	si	un	color	introducido	por	el	usuario	
// a	través	de	un	prompt	se	encuentra	dentro	del	array	o	no.


// let color = prompt('Introduce un color');
// let colores= ["azul",	 "amarillo",	 "rojo", "verde",	"rosa"];
// let resultado="No tenemos ese color";
// for (let i in colores) {
//  if(colores[i]==color.toLowerCase()){
//     resultado="Si tenemos ese color";
//  }
// }
// console.log(resultado);