// EJERCICIO 
// // •Crea un Arrayque contenga los valores 1,2,3,4,5.
//let numeros = [1,2,3,4,5];

// // •Muestra por consola la posición en la que se encuentra el número 4.
// console.log(numeros[3]);
//console.log(numeros.indexOf(4));

// // •Muestra por consola la suma del segundo y tercer elemento del Array. Deberá ser 5.
// console.log(numeros[1]+numeros[2]);

// // •Crea un Arraycon 4 cadenas y muestra por consola el número de caracteres de la segunda palabra del Array. 
// let cadenaArrays=['Torrente', 'La Veneno', 'Peter la Anguila', 'Belen Esteban'];
// console.log(cadenaArrays[1].length);

// // Utiliza TEMPLATE STRINGS para mostrar el mensaje de “La palabra XXXXXX tiene xx letras
// console.log(`La cadena ${cadenaArrays[1]} , tiene ${cadenaArrays[1].length} letras `);



// Ejercicio
// • Crea un Array con nombre numbers que contenga los valores 1,2,3,4,5,6 y muestra por consola
// el número de elementos que contiene el Array.
let numbers=[1, 2,3,4,5,6];
console.log(numbers.length);

// • Crea una variable con nombre number con valor 4. Muestra por consola si la variable number 
// es un array o no. Muestra por consola si la varibale numbers creada en el primer apartado es un array o no.
let number =4;
console.log(Array.isArray(number));
console.log(Array.isArray(numbers));

// • Elimina el primer elemento del array y muestra por consola el elemento borrado y el resultado del array.
console.log(numbers.shift());
console.log(numbers);

// • Elimina el último elemento del array y muestra por consola el elemento borrado y el resultado del array.
console.log(numbers.pop());
console.log(numbers);

// • Añade al rpincipio del array el elemento borrado anteriormente y muéstralo en consola.
numbers.unshift(6);
console.log(numbers);

// • Invierte el orden de los elementos de un array y muéstralo como un String separado por espacios.
let lista=['Torrente', 'La Veneno', 'Peter la Anguila', 'Belen Esteban', ' Chicote', 'El Sevilla'];

console.log(lista.reverse().join(' '));

// • Reemplaza los elementos 3 y 4 del array por 10, 23 y 54. Muéstralo por consola.
lista.splice(2,2,10, 23, 54);
console.log(lista);

// • Añade los elementos 12 y 14 delante del 10 utilizando un único método.
lista.splice(lista.indexOf(10),0,12, 14);
console.log(lista);