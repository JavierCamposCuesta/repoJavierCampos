'''Crear una función que, tomando una cadena de texto como entrada, construya y devuelva otra cadena formada de
 la siguiente manera: el método debe colocar todas las consonantes al principio y todas las vocales al final de la misma, 
 eliminando los blancos.Por ejemplo, pasándole la cadena "curso de programacion", una posible solución sería 
 "crsdprgrmcnuoeoaaio
Created on 1 Dec 2020

@author: estudiante
'''
def consonantesPrimero(cadena):
    consonantes=""
    vocales=""
    
    for i in cadena:
        if i=="a" or i=="e" or i=="i"  or i=="o"  or i=="u":
            vocales+=i
        elif i != " ":
            consonantes+=i
    
    return consonantes+vocales
print(consonantesPrimero("Hola que haces aqui estamos cojones"))




