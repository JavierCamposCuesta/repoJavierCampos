'''
Crear una funci�n que, tomando una cadena de texto como entrada, construya y devuelva
otra cadena formada de la siguiente manera: el m�todo debe colocar todas las consonantes
al principio y todas las vocales al final de la misma, eliminando los blancos.
Por ejemplo, pas�ndole la cadena curso de programacion, una posible soluci�n ser�a
crsdprgrmcnuoeoaaio
Created on 30 nov. 2020

@author: Javier
'''
def consonantesPrimero (cadena):
    consonantes=""
    vocales=""
    for i in range (0, len(cadena)):
        if cadena[i] != "a" and cadena[i]!="e" and cadena[i]!="i" and cadena[i]!="o" and cadena[i]!="u" and cadena[i]!=" ":
            consonantes=consonantes+cadena[i]
        elif cadena[i]!=" ":
            vocales=vocales+cadena[i]
    print(consonantes+vocales)
consonantesPrimero("Hola que haces cojones estamos aqui")