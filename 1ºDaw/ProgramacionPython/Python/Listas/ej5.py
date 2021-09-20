'''
5.    Realizar una función que reciba una lista y devuelva si está ordenada o no. 
Llamar a dicha función.
Created on 17 dic. 2020

@author: Javier
'''
def listaOrdenada(lista):
    contador=0
    contadorOrden=2
    intervalo=0
    for i in range (0, len(lista)):
        if contador<1:
            intervalo= lista[i+1]-lista[i]
            contador+=1
        elif contador>=1 and i<len(lista)-1:
            if lista[i+1]-lista[i]==intervalo:
                contadorOrden+=1
    return contadorOrden==len(lista)
        
print(listaOrdenada([2,4,6,8]))
assert(listaOrdenada([1,2,3,4,5,6]))
assert(not listaOrdenada([2,6,4,5,9]))
        
        