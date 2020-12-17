'''
4.    Realizar un función que reciba una lista y devuelva una nueva lista cuyo contenido 
sea igual a la original pero invertida. Así, dada la lista [‘Di’, ‘buen’, ‘día’, ‘a’, ‘papa’],
 deberá devolver [‘papa’, ‘a’, ‘día’, ‘buen’, ‘Di’]. Llamar a dicha función
Created on 17 dic. 2020

@author: Javier
'''
from _ast import Return
def pideLista():
    lista=["HOLA", "ADIOS", "KASE"]
    return lista
def invierteLista(lista):
    listaInvertida=[]
    for i in range (len(lista)-1,-1,-1):
        listaInvertida.append(lista[i])
    return listaInvertida
    
print(invierteLista(pideLista()))
        