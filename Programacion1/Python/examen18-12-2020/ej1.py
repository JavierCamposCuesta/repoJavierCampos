'''
 Un anagrama es el procedimiento de crear una palabra a partir de otra reordenando las letras de la primera palabra,
  por lo tanto diremos que una palabra es un anagrama de otra si la primera palabra se puede formar a partir de las 
  letras de la otra y no es la misma palabra.

Realizar una función que reciba como argumento dos palabras y devuelva verdadero si dichas palabras son anagramas y 
falso en caso contrario, por ejemplo “sergio” y “riesgo”

Realizar las llamadas necesarias para probar la función anterior de forma que se testee que funciona bien la función 
en todos los posibles casos.

** Considera sólo palabras cuyas letras tengan una sola ocurrencia.
Created on 18 Dec 2020

@author: estudiante
'''
def compruebaAnagrama(palabra1, palabra2):
    contador=0
    for i in palabra1:
        for k in palabra2:
            #Copmprobamos si cada caracterer de la palabra1 es igual a alguno de la palabra2
            if k==i:
                contador+=1
    #Si la cantidad de caracteres iguales entra las dos palabras es igual al pamaño de la palabra1, es porque ambas palabras son anagramas
    return contador==len(palabra1)


print(compruebaAnagrama("sergio", "riesgo"))
assert(compruebaAnagrama("javier", "reivaj"))
assert(not compruebaAnagrama("Hola", "adios"))
assert(compruebaAnagrama("espacio", "copisea"))

