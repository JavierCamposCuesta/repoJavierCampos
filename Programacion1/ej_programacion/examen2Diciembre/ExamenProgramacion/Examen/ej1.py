'''
La primitiva es un tipo de sorteo bisemanal en el que se puede elegir combinaciones de 6 números del 1 
al 49. Un boleto resulta ganador si esos 6 números coinciden con la combinación extraída al azar de un 
bombo con todas las bolas. También existen premios menores a partir de los 3 aciertos.
Diseña una función que reciba como entrada dos listas de números que hagan referencia a la combinación 
ganadora y a la apuesta y devuelva como resultado el número de aciertos que tiene la apuesta. 

Adjunta también una captura de pantalla del valor en el IDE de las variables hacia la mitad de la 
ejecución.

2. Realiza un programa que solicite la apuesta de la primitiva y usando la función anterior escriba 
un mensaje con el número de aciertos. Si ha adivinado los 6 números deberá escribir. “ENHORABUENA. 
TIENES EL PLENO”. Valida los datos  de la apuesta de forma adecuada.

Si sabes, debes generar de forma aleatoria la combinación ganadora, si no sabes, utiliza la combinación 
ganadora que quieras.
Created on 2 Dec 2020

@author: estudiante
'''
def primitiava(combinacionGanadora, apuesta):
    contador=0
    aciertos=0
    for i in combinacionGanadora:
        if contador< len(apuesta) and i == apuesta[contador]:
            aciertos+=1
            contador+=1
        else:
            contador+=1
    return aciertos
assert(primitiava([45,15,45,41,32, 23], [45,16,16,14,45,65])==1)
assert(primitiava([45,15,45,41,32, 23], [45,15,16,14,45,23])==3)






