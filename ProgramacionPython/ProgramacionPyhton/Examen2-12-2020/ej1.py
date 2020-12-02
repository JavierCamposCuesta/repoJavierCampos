'''
La primitiva es un tipo de sorteo bisemanal en el que se puede elegir combinaciones de 6 n�meros del 1 
al 49. Un boleto resulta ganador si esos 6 n�meros coinciden con la combinaci�n extra�da al azar de un 
bombo con todas las bolas. Tambi�n existen premios menores a partir de los 3 aciertos.
Dise�a una funci�n que reciba como entrada dos listas de n�meros que hagan referencia a la combinaci�n 
ganadora y a la apuesta y devuelva como resultado el n�mero de aciertos que tiene la apuesta. 

Adjunta tambi�n una captura de pantalla del valor en el IDE de las variables hacia la mitad de la 
ejecuci�n.

2. Realiza un programa que solicite la apuesta de la primitiva y usando la funci�n anterior escriba 
un mensaje con el n�mero de aciertos. Si ha adivinado los 6 n�meros deber� escribir. �ENHORABUENA. 
TIENES EL PLENO�. Valida los datos  de la apuesta de forma adecuada.

Si sabes, debes generar de forma aleatoria la combinaci�n ganadora, si no sabes, utiliza la combinaci�n 
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