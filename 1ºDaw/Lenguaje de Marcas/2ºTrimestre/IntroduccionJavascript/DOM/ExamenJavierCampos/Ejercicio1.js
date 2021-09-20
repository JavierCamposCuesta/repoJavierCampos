// Realiza un script de javascript que genere un entero aleatorio entre 0 y 100 y que vaya preguntando al usuario 
// mediante prompt al usuario el número, indicándole en cada ocasión si el número es mayor que tiene que adivinar 
// es mayor o menor que el introducido, en caso de que sea correcto le dará la enhorabuena indicando el número correcto. 
// Generar número aleatorio entre 0 y 10 → Math.floor(Math.random() * 10)
let numeroSolucion = Math.floor(Math.random() * 100);
let numero = parseInt(prompt('Introduce un numero entero'));

//console.log(numeroSolucion);
//Esto lo dejo aqui para poder ver el numero y probarlo

while (numeroSolucion!=numero){
    if(numeroSolucion>numero){
        alert('El numero es mas grande');
    }
    else{
        alert('El numero es mas pequeño');
    }
    numero = parseInt(prompt('Introduce otro numero entero'));
}
alert('Enhorabuena máquina es ese numero');

